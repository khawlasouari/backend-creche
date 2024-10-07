package com.example.creche.Repository;

import com.example.creche.modele.Enfant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnfantRepository extends CrudRepository<Enfant, Long> {
     List<Enfant> findEnfantsByNom(String nom);

     List<Enfant> findByNom(String nom);
}
