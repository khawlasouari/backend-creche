package com.example.creche.Repository;

import com.example.creche.modele.Planning;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningRepository extends CrudRepository<Planning, Long> {
}
