package com.GestionDesBiscuits.Valk.repository;
import com.GestionDesBiscuits.Valk.models.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepo extends JpaRepository<Conge , Long> {

}
