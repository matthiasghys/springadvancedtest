package be.vdab.personeel.constraints;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.forms.RijksregisterForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class RijksRegisterValidator implements ConstraintValidator<RijksregisterNummer, RijksregisterForm> {

    @Override
    public void initialize(RijksregisterNummer rijksregisterNummer) {

    }

    @Override
    public boolean isValid(RijksregisterForm form, ConstraintValidatorContext constraintValidatorContext) {

        Long nr = form.getWerknemer().getRijksRegisterNr();

        Long geboortedag = nr / 100000L;

        String geboortelong = "19" +geboortedag.toString();
        if (form.getWerknemer().getGeboorte().toString().replace("-","").equals(geboortelong)){
            long controlegetal = nr % 100L;
            if(nr/10000000 % 100 > 20){
                nr += 200000000000L;
            }
            long eerste9Cijfers = nr / 100;

            return (97- eerste9Cijfers % 97 == controlegetal);

        }return false;
    }
}
