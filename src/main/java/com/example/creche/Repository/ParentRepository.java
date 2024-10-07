package com.example.creche.Repository;

import com.example.creche.modele.parent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends CrudRepository<parent, Long> {
    // Méthode pour trouver un parent par email
    parent findByEmail(String email);

}
