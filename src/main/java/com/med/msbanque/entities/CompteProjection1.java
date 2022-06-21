package com.med.msbanque.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde",types = Compte.class)
public interface CompteProjection1 {
    //les projection dans spring c'est un peu prés similaire a graphql qui crée par facebook.
    //mais graphql est plus performant il donne le client qui choisir les attribut qui a besoin
    //mais projection dans spring il faut faire ça dans le backend
    public double getSolde();
}

