package com.example.creche.services;

import com.example.creche.Repository.InscriptionRepository;
import com.example.creche.modele.Inscription;
import com.example.creche.modele.User;
import com.example.creche.modele.parent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class InscriptionService {
    private InscriptionRepository inscriptionRepository;

    public InscriptionService(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }
    public List<    Inscription> getAllInscriptions() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

    public Optional<Inscription> getInscriptionById(Long id) {
        return inscriptionRepository.findById(id);
    }

    public Inscription saveInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }

    public Inscription updateInscription(Long id, Inscription updatedInscription) {
        Optional<Inscription> existingInscriptionOptional = inscriptionRepository.findById(id);
        if (existingInscriptionOptional.isPresent()) {
            Inscription existingInscription = existingInscriptionOptional.get();
            existingInscription.setMontant(updatedInscription.getMontant());
            existingInscription.setMode(updatedInscription.getMode());
            existingInscription.setDescription(updatedInscription.getDescription());
            existingInscription.setDatePaiem(updatedInscription.getDatePaiem());
            return inscriptionRepository.save(existingInscription);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
