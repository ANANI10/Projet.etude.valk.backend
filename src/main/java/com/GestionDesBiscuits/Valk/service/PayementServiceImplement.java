package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Payement;
import com.GestionDesBiscuits.Valk.repository.PayementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PayementServiceImplement implements  PayementService{

    @Autowired
    private PayementRepo payementRepo;
    @Override
    public Payement addPayement(Payement payement) {
        return payementRepo.save(payement);
    }

    @Override
    public List<Payement> listPayement() {
        return payementRepo.findAll();
    }

    @Override
    public Payement updatePayement(Long id, Payement payement) {
        return payementRepo.findById(id)
                .map(p->{
                    p.setSalaire(payement.getSalaire());
                    p.setDate_payement(payement.getDate_payement());
                    p.setStatus(payement.getStatus());
                    return payementRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Payement mis à jours avec succes"));
    }

    @Override
    public String deletePayement(Long id) {
         payementRepo.deleteById(id);
         return "Payement supprimé avec sucess";
    }
}
