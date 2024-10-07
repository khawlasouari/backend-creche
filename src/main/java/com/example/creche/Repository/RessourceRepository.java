package com.example.creche.Repository;

import com.example.creche.modele.Ressource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends CrudRepository<Ressource, Long> {
}
