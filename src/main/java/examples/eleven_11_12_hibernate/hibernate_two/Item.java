package examples.eleven_11_12_hibernate.hibernate_two;

import jakarta.persistence.*;
import org.hibernate.annotations.OptimisticLock;


@Entity
@Table(name = "items", schema = "ave")
public class Item /*implements Serializable*/ {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //@Column(name = "id", columnDefinition = "BIGSERIAL NOT NULL PRIMARY KEY ")
    long id;

    @Column(name = "val")
    //@Column(name = "val", columnDefinition = "NUMERIC ")
    int val;

    @Version
    @Transient
    private long version;

    @Column(name = "junkField")
    @OptimisticLock(excluded = true)
    @Transient
    int junkField;


    public Item(){}

    public long getId() {
        return id;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public long getVersion() {
        return version;
    }

}
