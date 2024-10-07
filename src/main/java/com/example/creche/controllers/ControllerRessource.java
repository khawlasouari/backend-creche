package com.example.creche.controllers;

import com.example.creche.modele.Ressource;
import com.example.creche.services.RessourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ressources")
public class ControllerRessource {
    private final RessourceService ressourceService;

    public ControllerRessource(RessourceService ressourceService) {
        this.ressourceService = ressourceService;
    }

    @PostMapping("/saveRessource")
    public Ressource saveRessource(@RequestBody Ressource ressource) {
        return ressourceService.saveRessource(ressource);
    }

    @GetMapping()
    public List<Ressource> getAllRessources() {
        return ressourceService.getAllRessources();
    }

    @DeleteMapping("/{id}")
    public void deleteRessource(@PathVariable Long id) {
        ressourceService.deleteRessource(id);
    }

    @PutMapping("/{id}")
    public Ressource updateRessource(@PathVariable Long id, @RequestBody Ressource ressourceDetails) {
        return ressourceService.updateRessource(id, ressourceDetails);
    }
}
