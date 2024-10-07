package com.example.creche.controllers;

import com.example.creche.modele.Activite;
import com.example.creche.services.ActiviteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activites")



public class ControllerActivite {
    private final ActiviteService activiteService;

    public ControllerActivite(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }

    @CrossOrigin(origins = "*")  // Permettre CORS
    @PostMapping("/saveActivite")
    public Activite saveActivite(@RequestBody Activite activite) {
        return activiteService.saveActivite(activite);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Activite> getAllActivites() {
        return activiteService.getAllActivites();
    }
    @CrossOrigin(origins = "*")


    @DeleteMapping("/{id}")
    public void deleteActivite(@PathVariable Long id) {
        activiteService.deleteActivite(id);
    }
    @CrossOrigin(origins = "*")


    @PutMapping("/{id}")
    public Activite updateActivite(@PathVariable Long id, @RequestBody Activite activiteDetails) {
        return activiteService.updateActivite(id, activiteDetails);
    }

}
