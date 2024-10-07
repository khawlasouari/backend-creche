package com.example.creche.controllers;

import com.example.creche.modele.User;
import com.example.creche.modele.parent;
import com.example.creche.services.ParentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")

public class ControllerParent {
    private ParentService parentService;

    public ControllerParent( ParentService parentService) {
        this.parentService=parentService;

    }
    @PostMapping("/saveParent")
    public parent saveParent(@RequestBody parent parent){
        return  parentService.saveParent(parent);
    }
    @GetMapping()
    public List<parent> getAllParents(){
        return parentService.getAllParents();
    }
    @DeleteMapping("/id")
    public void  deleteParent (@PathVariable Long id){
        parentService.deleteParent(id);
    }
    @PutMapping("/id")
    public parent updateParent(@PathVariable Long id, @RequestBody parent parentDetails){
        return (parent) parentService.updateParent(id, parentDetails);
    }

}
