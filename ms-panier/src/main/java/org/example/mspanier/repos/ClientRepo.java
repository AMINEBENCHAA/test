package org.example.mspanier.repos;

import org.example.mspanier.enteties.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}

