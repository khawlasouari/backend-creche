package com.example.creche.Repository;

import com.example.creche.modele.Activite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteRepository extends CrudRepository<Activite, Long> {
}
