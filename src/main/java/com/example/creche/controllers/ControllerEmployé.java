package com.example.creche.controllers;

import com.example.creche.modele.Employé;
import com.example.creche.services.EmployéService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employés")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerEmployé {

    private final EmployéService employéService;

    public ControllerEmployé(EmployéService employéService) {
        this.employéService = employéService;
    }

    @PostMapping("/saveEmployé")
    public Employé saveEmployé(@RequestBody Employé employé) {
        return employéService.saveEmployé(employé);
    }

    @GetMapping()
    public List<Employé> getAllEmployés() {
        return employéService.getAllEmployés();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployé(@PathVariable Long id) {
        employéService.deleteEmployé(id);
    }

    @PutMapping("/{id}")
    public Employé updateEmployé(@PathVariable Long id, @RequestBody Employé employéDetails) {
        return employéService.updateEmployé(id, employéDetails);
    }
}
