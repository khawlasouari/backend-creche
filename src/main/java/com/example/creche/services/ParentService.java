package com.example.creche.services;

import com.example.creche.Repository.ParentRepository;
import com.example.creche.modele.User;
import com.example.creche.modele.parent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ParentService {
    private ParentRepository parentRepository;
    private parent existingparent;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<parent> getAllParents() {
        return (List<parent>) parentRepository.findAll();
    }

    public Optional<parent> getParentById(Long id) {
        return parentRepository.findById(id);
    }

    public parent saveParent(parent parent) {
        return parentRepository.save(parent);
    }

    public void deleteUser(Long id) {
        parentRepository.deleteById(id);
    }
    public User updateParent(Long id, parent updatedParent) {
        Optional<parent> existingParentOptional = parentRepository.findById(id);
        if (existingParentOptional.isPresent()) {
            User existingParent = existingParentOptional.get();
            existingParent.setNom(updatedParent.getNom());
            existingParent.setPrenom(updatedParent.getPrenom());
            existingParent.setUsername(updatedParent.getUsername());
            existingParent.setEmail(updatedParent.getEmail());
            existingParent.setPassword(updatedParent.getPassword());
            existingParent.setAdresse(updatedParent.getAdresse());
            return parentRepository.save(existingparent);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }
}
