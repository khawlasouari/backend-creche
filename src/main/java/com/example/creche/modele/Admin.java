package com.example.creche.modele;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Admin extends User {

    public Admin(String nom, String prenom, String username,
                 String email, String encode, String adresse, String telephone) {
        super(nom, prenom, username, email, encode, adresse, telephone);
    }


}
