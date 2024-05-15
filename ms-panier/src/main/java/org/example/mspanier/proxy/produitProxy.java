package org.example.mspanier.proxy;

import org.example.mspanier.models.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-produits", url = "localhost:7272")
public interface produitProxy {
    @GetMapping("/produits/{id}")
    public Produit getproduitById(@PathVariable("id") Long id);
}
