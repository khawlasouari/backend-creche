package com.example.creche.Repository;

import com.example.creche.modele.Inscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription, Long> {

}
