package com.med.msbanque.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2 {
    public double getSolde();
    public TypeCompte getType();
}
