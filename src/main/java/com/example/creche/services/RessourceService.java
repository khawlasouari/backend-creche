package com.example.creche.services;

import com.example.creche.Repository.ReclamationRepository;
import com.example.creche.Repository.RessourceRepository;
import com.example.creche.modele.Ressource;
import com.example.creche.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RessourceService {
    private final RessourceRepository ressourceRepository;

    @Autowired
    public RessourceService(RessourceRepository ressourceRepository) {
        this.ressourceRepository = ressourceRepository;
    }

    public List<Ressource> getAllRessources() {
        return (List<Ressource>) ressourceRepository.findAll();
    }

    public Optional<Ressource> getRessourceById(Long id) {
        return ressourceRepository.findById(id);
    }

    @Transactional
    public Ressource saveRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Transactional
    public void deleteRessource(Long id) {
        ressourceRepository.deleteById(id);
    }

    @Transactional
    public Ressource updateRessource(Long id, Ressource updatedRessource) {
        Optional<Ressource> existingRessourceOptional = ressourceRepository.findById(id);
        if (existingRessourceOptional.isPresent()) {
            Ressource existingRessource = existingRessourceOptional.get();
            existingRessource.setNbJeux(updatedRessource.getNbJeux());
            existingRessource.setTypeJeux(updatedRessource.getTypeJeux());
            return ressourceRepository.save(existingRessource);
        } else {
            throw new RuntimeException("Reclamation not found with id: " + id);
        }
    }
}



