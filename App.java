import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class App {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    public static void main(String[] args) {

        Repository r = new Repository(em);

        r.createNewTower("Water Tower", 8);
        r.createNewTower("Earth Tower", 6);
        r.createNewTower("Air Tower", 20);
        r.createNewTower("Fire Tower", 14);

        Tower t1 = r.findTower("Water Tower");
        Tower t2 = r.findTower("Earth Tower");
        Tower t3 = r.findTower("Air Tower");
        Tower t4 = r.findTower("Fire Tower");

        r.createNewMage("Aquarius",5, t1);
        r.createNewMage("Aries",7, t1);
        r.createNewMage("Sagittarius", 16, t1);

        r.createNewMage("Lucid",10, t2);
        r.createNewMage("Daisy", 22, t2);

        r.createNewMage("Sigil",12, t3);
        r.createNewMage("Alex",26, t3);
        r.createNewMage("Gina",8, t3);

        r.createNewMage("Fenix", 19, t4);
        r.createNewMage("Lucifer", 24, t4);



        Mage mage1 = r.findMage("Aquarius");
        //r.deleteMage(mage1);
        //r.printEverything();

        //r.deleteTower(t1);
        r.printEverything();

        List<Mage> l1 = r.MagsLevelHigherThan10();
        System.out.println("------ Mages with level > 6 :");
        for (Mage m : l1) {
            m.printMage();
        }
        System.out.println(" ");


        List<Tower> l2 = r.TowersShorterThan20();
        System.out.println("------ Towers shorter than 20 :");
        for (Tower t : l2) {
            t.printTower();
        }
        System.out.println(" ");


        List<Mage> l3 = r.MagesBetterThanEarthTower();
        System.out.println("------ Mages better than anyone from Earth Tower:");
        for (Mage m : l3) {
            m.printMage();
        }
        System.out.println(" ");


        System.out.println(" ");
        System.out.println("------ Closing database");
        em.close();
        factory.close();;
    }

}
