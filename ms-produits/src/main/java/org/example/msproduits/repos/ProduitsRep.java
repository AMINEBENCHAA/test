package org.example.msproduits.repos;

import org.example.msproduits.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitsRep extends JpaRepository<Produit, Long> {
}
