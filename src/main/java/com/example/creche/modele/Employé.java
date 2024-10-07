package com.example.creche.modele;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter

public class Employé extends User {
    private String poste;
    private Double salaire;

    // Constructor with all parameters
    public Employé(String nom, String prenom, String username, String email, String encode, String adresse, String telephone, String poste, Double salaire) {
        super(nom, prenom, username, email, encode, adresse, telephone);
        this.poste = poste;
        this.salaire = salaire;
    }

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Groupe> groupeList;



    // If you need this constructor, ensure the parent class attributes are properly set

}
