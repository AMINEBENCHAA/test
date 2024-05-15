package org.example.mspanier.models;
import lombok.Data;

@Data
public class Produit {
    private Long idProduit;
    private String nom;
    private int prix;

}
