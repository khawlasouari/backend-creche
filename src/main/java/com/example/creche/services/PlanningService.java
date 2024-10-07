package com.example.creche.services;

import com.example.creche.Repository.PlanningRepository;
import com.example.creche.modele.Planning;
import com.example.creche.modele.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlanningService {
    private PlanningRepository planningRepository;

    public PlanningService(PlanningRepository planningRepository) {
        this.planningRepository = planningRepository;
    }
    public List<Planning> getAllPlannings() {
        return (List<Planning>) planningRepository.findAll();
    }

    public Optional<Planning> getPlanningById(Long id) {
        return planningRepository.findById(id);
    }

    public Planning savePlanning(Planning planning) {
        return planningRepository.save(planning);
    }

    public void deletePlanning(Long id) {
        planningRepository.deleteById(id);
    }

    public Planning updatePlanning(Long id, Planning updatedPlanning) {
        Optional<Planning> existingPlanningOptional = planningRepository.findById(id);
        if (existingPlanningOptional.isPresent()) {
            Planning existingPlanning = existingPlanningOptional.get();
            existingPlanning.setDate(updatedPlanning.getDate());
            existingPlanning.setHeureDeb(updatedPlanning.getHeureDeb());
            existingPlanning.setHeureDeb(updatedPlanning.getHeureFin());
            return planningRepository.save(existingPlanning);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}


