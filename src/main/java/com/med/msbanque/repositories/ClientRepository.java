package com.med.msbanque.repositories;

import com.med.msbanque.entities.Client;
import com.med.msbanque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
}
