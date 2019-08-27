package be.vdab.personeel.forms;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OpslagForm {
    @NotNull
    @Range(min=1)
    private final BigDecimal opslag;

    public OpslagForm(@NotNull @Min(1) BigDecimal opslag) {
        this.opslag = opslag;
    }

    public BigDecimal getOpslag() {
        return opslag;
    }
}
