package com.med.msbanque;

import com.med.msbanque.entities.Compte;
import com.med.msbanque.entities.TypeCompte;
import com.med.msbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }

}
