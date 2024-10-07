package com.example.creche.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nbJeux;
    private String typeJeux;


    public Ressource() {

    }


    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Activite> activiteList;
}
