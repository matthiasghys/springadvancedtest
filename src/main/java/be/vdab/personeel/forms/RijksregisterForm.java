package be.vdab.personeel.forms;

import be.vdab.personeel.constraints.RijksregisterNummer;
import be.vdab.personeel.domain.Werknemer;

import javax.validation.constraints.NotNull;

@RijksregisterNummer
public class RijksregisterForm {

    @NotNull
    private final Long nr;

    private final Werknemer werknemer;


    public RijksregisterForm(@NotNull Long nr, Werknemer werknemer) {
        this.nr = nr;
        werknemer.updateRijksRegisterNr(nr);
        this.werknemer = werknemer;
    }

    public long getNr() {
        return nr;
    }

    public Werknemer getWerknemer() {
        return werknemer;
    }
}

