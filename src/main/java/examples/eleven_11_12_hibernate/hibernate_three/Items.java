package examples.eleven_11_12_hibernate.hibernate_three;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.OptimisticLock;


@Entity
@Table(name = "items", schema="ave")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "val")
    @OptimisticLock(excluded = true)
    private int val;

    /*
    @Version
    @Transient
    @Getter
    private long version;
    */

    public Items() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }


    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", val=" + val +
                '}';
    }

}
