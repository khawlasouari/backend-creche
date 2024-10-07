package com.example.creche.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Utiliser Long pour correspondre aux méthodes getter et setter
    private float montant;
    private Date datePaiem;
    private String mode;
    private String description;

    public Inscription() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private parent parent;


    public Long getId() {
        return id;
    }
}
