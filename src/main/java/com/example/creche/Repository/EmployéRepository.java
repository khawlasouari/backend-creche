package com.example.creche.Repository;

import com.example.creche.modele.Employé;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;
@Repository
public interface EmployéRepository extends CrudRepository<Employé, Long> {
    Employé findByEmail(String email);
}
