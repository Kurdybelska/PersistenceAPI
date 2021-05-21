import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TowerRepository {

    private EntityManager em;

    public TowerRepository (EntityManager em) {
        this.em = em;
    }

    public void createNewTower (String name, Integer height)
    {
        System.out.println("----- CREATING TOWER: name: " + name);
        Tower newTower = new Tower(name, height);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newTower);

        transaction.commit();
    }

    public Tower findByName(String name)
    {
        return em.find(Tower.class, name);
    }

    public void deleteTower(Tower t)
    {
        EntityTransaction transaction = em.getTransaction();

        for (Mage m : t.getMages()) {
            t.deleteMage(m);
        }

        transaction.begin();
        em.remove(t);
        transaction.commit();
    }

    public void printAll()
    {
        Query query = em.createQuery("SELECT t FROM Tower t");
        List<Tower> towers = query.getResultList();
        System.out.println("------ PRINTING DATABASE: ");
        for (Tower t : towers) {
            t.printMages();
        }
        System.out.println(" ");
    }

    public List<Tower> TowersShorterThan20 ()
    {
        Query query = em.createQuery("SELECT t FROM Tower t WHERE t.height < 20");
        List<Tower> towers = query.getResultList();
        return towers;
    }
}
