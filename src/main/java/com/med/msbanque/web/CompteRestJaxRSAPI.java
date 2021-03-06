package com.med.msbanque.web;

import com.med.msbanque.entities.Compte;
import com.med.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    //-> l'injection de dependence ne peux faire que sur les composant spring, c-a-d spring ne va pas
    // interpreter @Autowired si c'est ne pas spring qui a instancier la class
    // d'habitude on utilise @RestController (c'est un composant spring) mais @Path c'est pas un composant spring (pas un
    // annotation de spring il a connait pas)
    // c'est pour cela il foudrais ajouter l'annotation @Component
    // alors le fait d'ajouter l'annotation @Component c-a-d c'est un composant spring (spring qui va instancier, sinon tu va
    // avoir null pointer exception).
    @Autowired
    private CompteRepository compteRepository;


    // pour json jersey il utilise Jackson
    // pour xml jersey il utilise JaxB (il y'a un condition vous devez ajouter l'annotation @XmlRoutElement dans la class que vous allez serializer Compte (POJO)
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }

    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Compte getCompte(@PathParam(value = "id") Long id){
        return compteRepository.findById(id).get();
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte, @PathParam("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id){
        compteRepository.deleteById(id);
    }
}
