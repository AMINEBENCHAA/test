package org.example.mspanier.repos;

import org.example.mspanier.enteties.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepos extends JpaRepository<Panier, Long> {
}

