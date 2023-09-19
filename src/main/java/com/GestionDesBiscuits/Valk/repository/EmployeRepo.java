package com.GestionDesBiscuits.Valk.repository;

import com.GestionDesBiscuits.Valk.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepo extends JpaRepository<Employe , Long> {

}
