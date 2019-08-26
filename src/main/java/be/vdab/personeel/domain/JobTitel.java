package be.vdab.personeel.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jobtitels")
class JobTitel implements Serializable {

    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @Version
    private int versie;

    public JobTitel(String naam) {
        this.naam = naam;
    }

    protected JobTitel(){}

}
