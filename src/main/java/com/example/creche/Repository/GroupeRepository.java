package com.example.creche.Repository;

import com.example.creche.modele.Groupe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends CrudRepository<Groupe, Long> {
}
