package com.example.creche.controllers;
import com.example.creche.modele.Enfant;
import com.example.creche.services.EnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enfants")



@CrossOrigin(origins = "http://localhost:64605")

public class ControllerEnfant {
    @Autowired
    private final EnfantService enfantService;


    public ControllerEnfant(EnfantService enfantService) {
        this.enfantService = enfantService;
    }

    @CrossOrigin(origins = " http://localhost:64605")  // Remplacez par l'origine de votre application front-end
    @PostMapping("/saveEnfant")
    public ResponseEntity<Enfant> saveEnfant(@RequestBody Enfant enfant) {
        Enfant savedEnfant = enfantService.saveEnfant(enfant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnfant);
    }
    @CrossOrigin(origins = "http://localhost:64605")
    @GetMapping
    public List<Enfant> getAllEnfants() {
        return enfantService.getAllEnfants();
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public void deleteEnfant(@PathVariable Long id) {
        enfantService.deleteEnfant(id);
    }
    @CrossOrigin(origins = "*")

    @PutMapping("/{id}")
    public Enfant updateEnfant(@PathVariable Long id, @RequestBody Enfant enfantDetails) {
        return enfantService.updateEnfant(id, enfantDetails);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/rechercher-par-nom")
    public ResponseEntity<String> rechercherEnfantsParNom(@RequestParam String nom) {
        List<Enfant> enfants = enfantService.findEnfantsByNom(nom);
        if (enfants.isEmpty()) {
            // Aucun enfant trouvé
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aucun enfant trouvé avec le nom : " + nom);
        } else {
            // Enfants trouvés
            StringBuilder details = new StringBuilder("Enfants trouvés avec le nom : " + nom + " :\n");
            for (Enfant enfant : enfants) {
                details.append(enfant.toString()).append("\n");
            }
            return ResponseEntity.ok(details.toString());
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/count")
    public ResponseEntity<Long> compterEnfants() {
        long count = enfantService.countEnfants();
        return ResponseEntity.ok(count);
    }
}


