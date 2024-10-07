package com.example.creche.controllers;

import com.example.creche.modele.Planning;
import com.example.creche.services.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plannings")
public class ControllerPlanning {
    private  PlanningService planningService;

    @Autowired
    public ControllerPlanning(PlanningService planningService ) {
        this.planningService = planningService;
    }

    @PostMapping("/savePlanning")
    public Planning savePlanning(@RequestBody Planning planning) {
        return planningService.savePlanning(planning);
    }

    @GetMapping()
    public List<Planning> getAllPlannings() {
        return planningService.getAllPlannings();
    }

    @DeleteMapping("/{id}")
    public void deletePlanning(@PathVariable Long id) {
        planningService.deletePlanning(id);
    }

    @PutMapping("/{id}")
    public Planning updatePlanning(@PathVariable Long id, @RequestBody Planning planningDetails) {
        return planningService.updatePlanning(id, planningDetails);
    }
}
