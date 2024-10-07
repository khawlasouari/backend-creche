package com.example.creche.controllers;

import com.example.creche.modele.Reclamation;
import com.example.creche.services.ReclamationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamations")
public class ControllerReclamation {
    private final ReclamationService reclamationService;

    public ControllerReclamation(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @PostMapping("/saveReclamation")
    public Reclamation saveReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.saveReclamation(reclamation);
    }

    @GetMapping()
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getAllReclamations();
    }

    @DeleteMapping("/{id}")
    public void deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
    }

    @PutMapping("/{id}")
    public Reclamation updateReclamation(@PathVariable Long id, @RequestBody Reclamation reclamationDetails) {
        return reclamationService.updateReclamation(id, reclamationDetails);
    }
}
