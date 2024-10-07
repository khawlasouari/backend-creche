package com.example.creche.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Reclamation {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Date dateRec;

    public Reclamation() {
    }
    @ManyToOne
    @JoinColumn(name = "parent")
    private parent parent;
}


