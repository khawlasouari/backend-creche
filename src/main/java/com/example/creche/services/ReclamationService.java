package com.example.creche.services;

import com.example.creche.Repository.ReclamationRepository;
import com.example.creche.modele.Reclamation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService {
    private final ReclamationRepository reclamationRepository;

    public ReclamationService(ReclamationRepository reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    public List<Reclamation> getAllReclamations() {
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    public Optional<Reclamation> getReclamationById(Long id) {
        return reclamationRepository.findById(id);
    }

    public Reclamation saveReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }

    public Reclamation updateReclamation(Long id, Reclamation updatedReclamation) {
        Optional<Reclamation> existingReclamationOptional = reclamationRepository.findById(id);
        if (existingReclamationOptional.isPresent()) {
            Reclamation existingReclamation = existingReclamationOptional.get();
            existingReclamation.setMessage(updatedReclamation.getMessage());
            existingReclamation.setDateRec(updatedReclamation.getDateRec());

            return reclamationRepository.save(existingReclamation);
        } else {
            throw new RuntimeException("Reclamation not found with id: " + id);
        }
    }
}
