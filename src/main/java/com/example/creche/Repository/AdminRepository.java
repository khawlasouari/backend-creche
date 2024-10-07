package com.example.creche.Repository;

import com.example.creche.modele.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin findByEmail(String email);
}
