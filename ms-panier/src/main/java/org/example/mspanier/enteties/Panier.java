package org.example.mspanier.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mspanier.models.Produit;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Panier{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;
    @ElementCollection
    private List<Long> produitsIds;
    @Transient
    List<Produit> produits;

    @ManyToMany(mappedBy = "paniers")
    private Set<Client> Clients = new HashSet<>();


}
