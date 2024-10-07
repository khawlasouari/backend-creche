package com.example.creche.services;

import com.example.creche.Repository.EmployéRepository;
import com.example.creche.modele.Employé;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployéService {
    private EmployéRepository employéRepository;

    public EmployéService(EmployéRepository employéRepository) {
        this.employéRepository=employéRepository;
    }
    public List<Employé> getAllEmployés(){
        return (List<Employé>) employéRepository.findAll();
    }
    public Optional<Employé> getEmployéById(Long id) {
        return employéRepository.findById(id);
    }

    public  Employé saveEmployé(Employé employé) {
        return employéRepository.save(employé);
    }
    public void deleteEmployé(Long id){
        employéRepository.deleteById(id);
    }
    public Employé updateEmployé(Long id, Employé updateEmployé) {
        Optional<Employé> existingEmployéOptional = employéRepository.findById(id);
        if (existingEmployéOptional.isPresent()) {
            Employé existingEmploye = existingEmployéOptional.get();
            existingEmploye.setNom(updateEmployé.getNom());
            existingEmploye.setPrenom(updateEmployé.getPrenom());
            existingEmploye.setUsername(updateEmployé.getUsername());
            existingEmploye.setEmail(updateEmployé.getEmail());
            existingEmploye.setPassword(updateEmployé.getPassword());
            existingEmploye.setAdresse(updateEmployé.getAdresse());
            return employéRepository.save(existingEmploye);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

}
