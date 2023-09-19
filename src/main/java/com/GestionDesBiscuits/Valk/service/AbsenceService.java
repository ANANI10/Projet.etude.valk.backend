package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Absence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AbsenceService {

    Absence addAbsence(Absence absence);

    List<Absence>listAbsence();

    Absence updateAbsence(Long id , Absence absence);

    String deleteAbsence(Long id);
}
