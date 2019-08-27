package be.vdab.personeel.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "jobtitels")
public
class JobTitel implements Serializable {

    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @Version
    private int versie;
    @OneToMany
    @JoinColumn(name = "jobtitelid")
    private Set<Werknemer> werknemers;

    public JobTitel(String naam) {
        this.naam = naam;
    }

    protected JobTitel(){}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Werknemer> getWerknemers() {
        return Collections.unmodifiableSet(werknemers);
    }
}
