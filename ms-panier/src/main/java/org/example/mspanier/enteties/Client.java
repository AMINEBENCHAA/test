package org.example.mspanier.enteties;


import jakarta.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCLient;
    private String nom;


    @ManyToMany
    @JoinTable(
            name = "client_panier",
            joinColumns = @JoinColumn(name = "idCLient"),
            inverseJoinColumns = @JoinColumn(name = "idPanier"))
    private Set<Panier> paniers = new HashSet<>();

}

