package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Payement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayementService {

    public Payement addPayement(Payement payement);

    public List<Payement>listPayement();

    public Payement updatePayement(Long id , Payement payement);

    public String deletePayement(Long id);
}
