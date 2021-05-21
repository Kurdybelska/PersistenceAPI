import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Tower {

    @Id
    private String name;
    private Integer height;

    @OneToMany
    private List<Mage> mages;

    public Tower() {
    }

    public Tower (String name, Integer height)
    {
        this.name = name;
        this.height = height;
        this.mages = new LinkedList<>();
    }

    public void addMage(Mage mage) {
        this.mages.add(mage);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public List<Mage> getMages() {
        return mages;
    }

    public void printMages()
    {
        System.out.println("Mages from " + name + ":");
        for (Mage m : mages) {
            m.printMage();
        }
    }

    public void deleteMage(Mage mage)
    {
        List<Mage> newMages = new LinkedList<>();
        for (Mage m : mages) {
            if(m != mage) {
                newMages.add(m);
            }
        }
        this.mages = newMages;
    }

    public void printTower()
    {
        System.out.println("  Name: " + name + " | height: " + height );
    }
}
