package com.example.creche.Repository;

import com.example.creche.modele.Reclamation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {
}
