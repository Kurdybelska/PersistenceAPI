import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class Repository {

    private EntityManager em;
    MageRepository mr;
    TowerRepository tr;

    public Repository (EntityManager em) {
        this.em = em;
        this.mr = new MageRepository(em);
        this.tr = new TowerRepository(em);
    }

    public void createNewTower(String name, Integer height) {
        tr.createNewTower(name,height);
    }

    public void createNewMage(String name, Integer level, Tower tower) {
        mr.createNewMage(name, level, tower);
    }

    public Tower findTower(String name) {
        return tr.findByName(name);
    }

    public Mage findMage(String name) {
        return mr.findByName(name);
    }

    public void deleteTower(Tower t) {

        System.out.println("------ DELETE: " + t.getName());
        for (Mage m : t.getMages()) {
            mr.deleteMage(m);
        }
        tr.deleteTower(t);
    }

    public void deleteMage(Mage m) {
        mr.deleteMage(m);
    }

    public void printEverything() {
        tr.printAll();
    }

    public List<Mage> MagsLevelHigherThan10() {
        return mr.LevelHigherThan10();
    }

    public List<Tower> TowersShorterThan20() {
        return tr.TowersShorterThan20();
    }

    public List<Mage> MagesBetterThanEarthTower() {
        Query query = em.createQuery("SELECT m FROM Mage m WHERE m.level > 22");
        List<Mage> mages = query.getResultList();
        return mages;
    }
}
