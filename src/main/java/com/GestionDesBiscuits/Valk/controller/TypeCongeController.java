package com.GestionDesBiscuits.Valk.controller;

import com.GestionDesBiscuits.Valk.models.TypeConge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "valk")
public class TypeCongeController {

    @GetMapping(path = "typeConge")
    public TypeConge[] getTypesConge() {
        return TypeConge.values();
    }
}
