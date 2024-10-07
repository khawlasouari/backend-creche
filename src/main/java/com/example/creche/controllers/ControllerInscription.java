package com.example.creche.controllers;

import com.example.creche.modele.Inscription;
import com.example.creche.modele.User;
import com.example.creche.services.InscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
@CrossOrigin(origins = " http://localhost:4200")

public class ControllerInscription {
    private InscriptionService inscriptionService;

    public ControllerInscription(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }
    @PostMapping("/saveInscription")
    public Inscription saveInscription(@RequestBody Inscription inscription){
        return  inscriptionService.saveInscription(inscription);
    }
    @GetMapping()
    public List<Inscription> getAllInscriptions(){
        return  inscriptionService.getAllInscriptions();
    }
    @DeleteMapping("/{id}")
    public  void  deleteInscription (@PathVariable Long id){
        inscriptionService.deleteInscription(id);
    }
    @PutMapping("/{id}")
    public  Inscription updateInscription(@PathVariable Long id, @RequestBody Inscription inscriptionDetails){
        return  inscriptionService.updateInscription(id, inscriptionDetails);
    }
}
