import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mage {

    @Id
    private String name;
    private Integer level;
    @ManyToOne
    private Tower tower;

    public Mage() {
    }

    public Mage (String name, Integer level, Tower tower)
    {
        this.name = name;
        this.level = level;
        this.tower = tower;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public Integer getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Tower getTower() {
        return tower;
    }

    public void printMage()
    {
        System.out.println("  Name: " + name + " | level: " + level );
    }
}
