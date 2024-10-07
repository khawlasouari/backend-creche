package com.example.creche.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date Date;
    private Time heureDeb;
    private Time heureFin;



    public Planning() {

    }
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Activite> activiteList;


}
