package com.example.creche.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class parent extends User {
    private String fidelite;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Enfant> enfantList;

    @OneToMany(mappedBy = "parent")
    private List<Inscription> inscriptionList;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Reclamation> reclamationList;





    public parent(String nom, String prenom, String username, String email, String encode, String adresse, String telephone, String fidelite) {
        super(nom,prenom,username,email,encode,adresse,telephone);
        this.fidelite = this.fidelite;
    }



}
