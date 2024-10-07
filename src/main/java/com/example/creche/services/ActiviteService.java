package com.example.creche.services;

import com.example.creche.Repository.ActiviteRepository;
import com.example.creche.modele.Activite;
import com.example.creche.modele.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActiviteService {
    private ActiviteRepository activiteRepository;

    public ActiviteService(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }
    public List<Activite> getAllActivites() {
        return (List<Activite>) activiteRepository.findAll();
    }

    public Optional<Activite> getActiviteById(Long id) {
        return activiteRepository.findById(id);
    }

    public Activite saveActivite(Activite activite) {
        return activiteRepository.save(activite);
    }

    public void deleteActivite(Long id) {
        activiteRepository.deleteById(id);
    }

    public Activite updateActivite(Long id, Activite updatedActivite) {
        Optional<Activite> existingActiviteOptional = activiteRepository.findById(id);
        if (existingActiviteOptional.isPresent()) {
            Activite existingActiite = existingActiviteOptional.get();
            existingActiite.setNom(updatedActivite.getNom());
            existingActiite.setDescription(updatedActivite.getDescription());
            return activiteRepository.save(existingActiite);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}


