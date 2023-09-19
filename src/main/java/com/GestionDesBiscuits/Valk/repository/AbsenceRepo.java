package com.GestionDesBiscuits.Valk.repository;

import com.GestionDesBiscuits.Valk.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence , Long> {
}
