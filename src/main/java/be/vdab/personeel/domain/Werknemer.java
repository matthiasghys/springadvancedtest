package be.vdab.personeel.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "werknemers")
public
class Werknemer implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String familienaam;
    @NotBlank
    private String voornaam;
    @Email
    @Column(name = "email")
    private String emailAdres;
    @ManyToOne(optional = true)
    @JoinColumn(name = "chefid")
    private Werknemer chef;
    @ManyToOne(optional = false)
    @JoinColumn(name = "jobtitelid")
    private JobTitel jobTitel;
    private BigDecimal salaris;
    private String paswoord;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate geboorte;
    private long rijksRegisterNr;
    @Version
    private int versie;

    @OneToMany
    @JoinColumn(name="id")
    private Set<Werknemer> ondergeschikten;

    protected Werknemer(){}

    public Werknemer(@NotBlank String familienaam, @NotBlank String voornaam, @Email String emailAdres, Werknemer chef, JobTitel jobTitel, BigDecimal salaris, String paswoord, LocalDate geboorte, long rijksRegisterNr) {
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.emailAdres = emailAdres;
        this.chef = chef;
        this.jobTitel = jobTitel;
        this.salaris = salaris;
        this.paswoord = paswoord;
        this.geboorte = geboorte;
        this.rijksRegisterNr = rijksRegisterNr;
    }

    public long getId() {
        return id;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public Werknemer getChef() {
        return chef;
    }

    public JobTitel getJobTitel() {
        return jobTitel;
    }

    public BigDecimal getSalaris() {
        return salaris;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public LocalDate getGeboorte() {
        return geboorte;
    }

    public long getRijksRegisterNr() {
        return rijksRegisterNr;
    }
}
