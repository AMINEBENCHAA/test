package org.example.msproduits;


import org.example.msproduits.entities.Produit;
import org.example.msproduits.repos.ProduitsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableFeignClients
public class MsProduitsApplication implements CommandLineRunner {
    @Autowired
    ProduitsRep produitsRep;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(MsProduitsApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Produit.class);

        Produit p1 = produitsRep.save(new Produit(null,"ifri",50));
        Produit p2 = produitsRep.save(new Produit(null,"saida",45));

    }
}
