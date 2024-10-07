package com.example.creche.services;

import com.example.creche.modele.Enfant;
import com.example.creche.Repository.EnfantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnfantService {
    @Autowired
    private final EnfantRepository enfantRepositry;

    public EnfantService(EnfantRepository enfantRepositry) {
        this.enfantRepositry = enfantRepositry;
    }
    public List<Enfant> findEnfantsByNom(String nom) {
        return enfantRepositry.findByNom(nom);
    }

    public Enfant saveEnfant(Enfant enfant) {
        return enfantRepositry.save(enfant);
    }

    public void deleteEnfant(Long id) {
        enfantRepositry.deleteById(id);
    }

    public List<Enfant> getAllEnfants() {
        return (List<Enfant>) enfantRepositry.findAll();
    }

    public Enfant updateEnfant(Long id, Enfant updatedEnfant) {
        Optional<Enfant> existingEnfantOptional = enfantRepositry.findById(id);
        if (existingEnfantOptional.isPresent()) {
            Enfant existingEnfant = existingEnfantOptional.get();
            existingEnfant.setNom(updatedEnfant.getNom());
            existingEnfant.setPrenom(updatedEnfant.getPrenom());
            existingEnfant.setAge(updatedEnfant.getAge());
            existingEnfant.setGenre(updatedEnfant.getGenre());
            existingEnfant.setDateNaissance(updatedEnfant.getDateNaissance());
            return enfantRepositry.save(existingEnfant);
        } else {
            throw new RuntimeException("Enfant not found with id: " + id);
        }
    }
    public long countEnfants() {
        return enfantRepositry.count();
    }
}