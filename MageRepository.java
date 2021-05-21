import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

public class MageRepository {

    private EntityManager em;

    public MageRepository (EntityManager em) {
        this.em = em;
    }

    public void createNewMage (String name, Integer level, Tower tower)
    {
        System.out.println("------ CREATING MAGE: name: " + name);
        Mage newMage = new Mage(name, level, tower);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newMage);
        tower.addMage(newMage);

        transaction.commit();
    }

    public Mage findByName(String name)
    {
        return em.find(Mage.class, name);
    }

    public void deleteMage(Mage m)
    {
        EntityTransaction transaction = em.getTransaction();
        System.out.println("------ DELETE: Mage " + m.getName());

        transaction.begin();
        Tower t = m.getTower();
        t.deleteMage(m);
        em.remove(m);
        transaction.commit();
    }

    public List<Mage> LevelHigherThan10()
    {
        Query query = em.createQuery("SELECT m FROM Mage m WHERE m.level > 10");
        List<Mage> mages = query.getResultList();
        return mages;
    }

    public List<Mage> getAllMages() {
        Query query = em.createQuery("SELECT m FROM Mage m");
        List<Mage> mages = query.getResultList();
        return mages;
    }
}
