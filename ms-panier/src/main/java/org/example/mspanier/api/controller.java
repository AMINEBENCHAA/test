package org.example.mspanier.api;


import org.example.mspanier.enteties.Panier;
import org.example.mspanier.models.Produit;
import org.example.mspanier.repos.ClientRepo;

import org.example.mspanier.repos.PanierRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    PanierRepos panierRepos;

    // Assuming you have a ProduitProxy class defined elsewhere
//    @Autowired
//    ProduitProxy produitProxy;

    @GetMapping("/clientproduits/{id}")
    public List<Produit> getClientProduits(@PathVariable("id") Long id) {
        List<Panier> paniers = (List<Panier>) clientRepo.findById(id).orElseThrow(() -> new RuntimeException("Client not found")).getPaniers();
        List<Produit> produits = new ArrayList<>();
        for (Panier p : paniers) {
            produits.addAll(p.getProduits());
        }
        return produits;
    }
}
