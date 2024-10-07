package com.example.creche.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Login {
    private Long id;
    private String prenom;
    private String username;
    private String email;
    private String password;
    private String adresse;
    private String telephone;
    private String role;
    private  String fidelite;
    private String poste;
    private Double salaire;

}
