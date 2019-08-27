package be.vdab.personeel.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = RijksRegisterValidator.class)
public @interface RijksregisterNummer {
    String message() default "{be.vdab.personeel.constraints.Rijksregister.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
