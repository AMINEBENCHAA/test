package org.example.mspanier;

import org.example.mspanier.enteties.Client;
import org.example.mspanier.enteties.Panier;
import org.example.mspanier.repos.ClientRepo;
import org.example.mspanier.repos.PanierRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class MsPanierApplication implements CommandLineRunner {
    @Autowired
    ClientRepo clientRep;
    @Autowired
    PanierRepos panierRepos;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(MsPanierApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Client.class);
        repositoryRestConfiguration.exposeIdsFor(Panier.class);


        Client c1 = clientRep.save(new Client(null,"Amine",null));
        Client c2 = clientRep.save(new Client(null,"Brahim",null));
        List<Client> clients = new ArrayList<>();
        clients.add(c1);
        clients.add(c2);
        List<Long> profuitsids= new ArrayList<>();
        profuitsids.add(1L);
        profuitsids.add(2L);


        Panier pn1 = panierRepos.save(new Panier(null,profuitsids,null,null));

    }
}
