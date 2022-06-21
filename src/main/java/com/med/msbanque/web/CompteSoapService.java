package com.med.msbanque.web;

import com.med.msbanque.entities.Compte;
import com.med.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component // la meme chose que JaxRS parce que le protocol Soap il utilise JaxWS.
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {

    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "id") Long id){
        return compteRepository.findById(id).get();
    }

}
