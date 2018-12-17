package fr.wildcodeschool.quetespring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Outputter implements CommandLineRunner {

    @Autowired
    private BeerDao beerDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD
        System.out.println("******************");
        System.out.println("Beers in DB : " + beerDao.count());

        // Crée une nouvelle bière et l'enregistre dans la BDD
        Beer beer1 = new Beer("Leffe", "blonde", 4);
        System.out.println("******************");
        System.out.println(beer1 + " has been created !");
        beerDao.save(beer1);
        System.out.println(beer1 + " has been saved !");

        // Lit les informations correspondant à beer1
        Beer selectBeer = beerDao.findById(1L).get();
        System.out.println("******************");
        System.out.println("Brand " + selectBeer.getBrand());
        System.out.println("Color " + selectBeer.getColor());
        System.out.println("Degree " + selectBeer.getDegree());

        // Liste les bières enregistrés dans la BDD
        System.out.println("******************");
        System.out.println("Beers in list are ");
        for (Beer myBeer : beerDao.findAll()) {
            System.out.println(myBeer.toString());
        }

        // Supprime beer1 de la BDD
        beerDao.deleteById(1L);

        // Liste les bieres enregistrés dans la BDD
        System.out.println("******************");
        System.out.println("Beers in list are ");
        for (Beer myBeer : beerDao.findAll()) {
            System.out.println(myBeer.toString());
        }

    }
}
