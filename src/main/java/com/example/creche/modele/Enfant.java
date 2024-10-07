package com.example.creche.modele;

import com.example.creche.modele.Groupe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Enfant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;
    private String nom,prenom;
    private LocalDate dateNaissance;

    private Long age;
    private String genre;


    public Enfant() {

    }
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nom: " + nom + "\n" +
                "Prénom: " + prenom + "\n" +
                "Date de Naissance: " + dateNaissance + "\n" + // Utilisation de LocalDate.toString()
                "age:"+age+"\n"+
                "genre:"+genre+"\n"+
                "Parent: " + (parent != null ? parent.getId() : "Aucun parent");
    }
    @ManyToOne
    @JoinColumn(name = "parent")
    private parent parent;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Groupe> GroupeList;}