package com.example.creche.services;

import com.example.creche.Repository.GroupeRepository;
import com.example.creche.modele.Enfant;
import com.example.creche.modele.Groupe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GroupeService {
    private GroupeRepository groupeRepository;

    public GroupeService(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }
    public List<Groupe> getAllGroupes(){
        return (List<Groupe>) groupeRepository.findAll();
    }
    public Optional<Groupe> getGroupeById(Long id) {
        return groupeRepository.findById(id);
    }
    public  void deleteGroupe(Long id ){
        groupeRepository.deleteById(id);
    }
    public Groupe updateGroupe(Long id,Groupe updateGroupe) {
        Optional<Groupe> existingGroupeOptional = groupeRepository.findById(id);
        if (existingGroupeOptional.isPresent()) {
            Groupe existingGroupe = existingGroupeOptional.get();
            existingGroupe.setNom(updateGroupe.getNom());
            return groupeRepository.save(existingGroupe);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public Groupe saveGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }
}
