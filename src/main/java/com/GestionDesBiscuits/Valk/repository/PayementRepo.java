package com.GestionDesBiscuits.Valk.repository;

import com.GestionDesBiscuits.Valk.models.Payement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayementRepo extends JpaRepository<Payement, Long>{
}
