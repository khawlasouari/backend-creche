package com.example.creche.controllers;

import com.example.creche.modele.Groupe;
import com.example.creche.modele.User;
import com.example.creche.services.GroupeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")


public class ControllerGroupe {
    private GroupeService groupeService;

    public ControllerGroupe(GroupeService groupeService) {
        this.groupeService = groupeService;
    }
    @PostMapping("/saveGroupe")
    public Groupe saveGroupe(@RequestBody Groupe groupe){
        return  groupeService.saveGroupe(groupe);
    }
    @GetMapping()
    public List<Groupe> getAllGroupes(){
        return  groupeService.getAllGroupes();
    }
    @DeleteMapping("/{id}")
    public  void  deleGroupe (@PathVariable Long id){
        groupeService.deleteGroupe(id);
    }
    @PutMapping("/{id}")
    public  Groupe updateGroupe(@PathVariable Long id, @RequestBody Groupe groupeDetails){
        return  groupeService.updateGroupe(id, groupeDetails);
    }
}
