package com.example.creche.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor



public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;


    public Activite() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "groupe")
    private Groupe groupe;
    @ManyToOne
    @JoinColumn(name = "planning")
    private Planning  planning;
    @ManyToOne
    @JoinColumn(name = "ressource")
    private Ressource ressource;
}