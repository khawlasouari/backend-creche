package com.example.creche.services;

import com.example.creche.Repository.AdminRepository;
import com.example.creche.modele.Admin;
import com.example.creche.modele.Employé;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AdminService {
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository=adminRepository;
    }
  public List<Admin> getAllAdmins(){
        return (List<Admin>) adminRepository.findAll();
  }
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }
    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    public void deleteAdmin(Long id){
        adminRepository.deleteById(id);
    }
    public Admin updateAdmin(Long id,Admin updateAdmin) {
        Optional<Admin> existingAdminOptional = adminRepository.findById(id);
        if (existingAdminOptional.isPresent()) {
            Admin existingAdmin = existingAdminOptional.get();
            existingAdmin.setNom(updateAdmin.getNom());
            existingAdmin.setPrenom(updateAdmin.getPrenom());
            existingAdmin.setUsername(updateAdmin.getUsername());
            existingAdmin.setEmail(updateAdmin.getEmail());
            existingAdmin.setPassword(updateAdmin.getPassword());
            existingAdmin.setAdresse(updateAdmin.getAdresse());
            return adminRepository.save(existingAdmin);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
