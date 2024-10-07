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

public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    public Groupe() {
    }
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Enfant> enfantList;
    @ManyToOne
    @JoinColumn(name = "employé")
    private Employé employé;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Activite> activiteList;
}
