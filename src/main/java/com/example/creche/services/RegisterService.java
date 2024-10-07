package com.example.creche.services;


import com.example.creche.Repository.AdminRepository;
import com.example.creche.Repository.EmployéRepository;
import com.example.creche.Repository.ParentRepository;
import com.example.creche.modele.Admin;
import com.example.creche.modele.ConnexionDtO;
import com.example.creche.modele.Employé;
import com.example.creche.modele.parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final ParentRepository parentRepository;
    private final AdminRepository adminRepository;
    private final EmployéRepository employéRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(ParentRepository parentRepository, AdminRepository adminRepository, EmployéRepository employéRepository, PasswordEncoder passwordEncoder) {
        this.parentRepository = parentRepository;
        this.adminRepository = adminRepository;
        this.employéRepository = employéRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void inscrireUtilisateur(ConnexionDtO connexionDto) {
        switch (connexionDto.getRole().toLowerCase()) {
            case "parent":
                inscrireParent(connexionDto);
                break;
            case "admin":
                inscrireAdmin(connexionDto);
                break;
            case "employe":
                inscrireEmploye(connexionDto);
                break;
            default:
                throw new IllegalArgumentException("Rôle non valide pour l'inscription.");
        }
    }

    private void inscrireEmploye(ConnexionDtO connexionDto) {
        Employé employé = new Employé(
                connexionDto.getNom(),
                connexionDto.getPrenom(),
                connexionDto.getUsername(),
                connexionDto.getEmail(),
                passwordEncoder.encode(connexionDto.getPassword()),
                connexionDto.getAdresse(),
                connexionDto.getTelephone(),
                connexionDto.getPoste(),
                (double) connexionDto.getSalaire()
        );

        employéRepository.save(employé);
    }

    private void inscrireAdmin(ConnexionDtO connexionDto) {
        Admin admin = new Admin(
                connexionDto.getNom(),
                connexionDto.getPrenom(),
                connexionDto.getUsername(),
                connexionDto.getEmail(),
                passwordEncoder.encode(connexionDto.getPassword()),
                connexionDto.getAdresse(),
                connexionDto.getTelephone()
        );

        adminRepository.save(admin);
    }

    private void inscrireParent(ConnexionDtO connexionDto) {
        parent parent = new parent(
                connexionDto.getNom(),
                connexionDto.getPrenom(),
                connexionDto.getUsername(),
                connexionDto.getEmail(),
                passwordEncoder.encode(connexionDto.getPassword()),
                connexionDto.getAdresse(),
                connexionDto.getTelephone(),
                connexionDto.getFidelite()
        );

        parentRepository.save(parent);
    }

    public ConnexionDtO connecterUtilisateur(ConnexionDtO connexionDto) {
        parent parent = parentRepository.findByEmail(connexionDto.getEmail());
        if (parent != null && passwordEncoder.matches(connexionDto.getPassword(), parent.getPassword())) {
            connexionDto.setRole("parent");
            connexionDto.setUsername(parent.getUsername());
            connexionDto.setNom(parent.getNom());
            connexionDto.setEmail(parent.getEmail());
            connexionDto.setTelephone(parent.getTelephone());
            connexionDto.setAdresse(parent.getAdresse());
            connexionDto.setId(parent.getId());
            connexionDto.setFidelite(parent.getFidelite());
            return connexionDto;
        }

        Admin admin = adminRepository.findByEmail(connexionDto.getEmail());
        if (admin != null && passwordEncoder.matches(connexionDto.getPassword(), admin.getPassword())) {
            connexionDto.setRole("admin");
            connexionDto.setTelephone(admin.getTelephone());
            connexionDto.setNom(admin.getNom());
            connexionDto.setAdresse(admin.getAdresse());
            connexionDto.setUsername(admin.getUsername());
            connexionDto.setEmail(admin.getEmail());
            connexionDto.setId(admin.getId());
            return connexionDto;
        }

        Employé employe = employéRepository.findByEmail(connexionDto.getEmail());
        if (employe!= null && passwordEncoder.matches(connexionDto.getPassword(), employe.getPassword())) {
            connexionDto.setRole("employe");
            connexionDto.setTelephone(employe.getTelephone());
            connexionDto.setNom(employe.getNom());
            connexionDto.setAdresse(employe.getAdresse());
            connexionDto.setUsername(employe.getUsername());
            connexionDto.setEmail(employe.getEmail());
            connexionDto.setId(employe.getId());
            return connexionDto;
        }

        // Aucune correspondance trouvée, retourner l'objet ConnexionDto sans le rôle
        return connexionDto;
    }
}

