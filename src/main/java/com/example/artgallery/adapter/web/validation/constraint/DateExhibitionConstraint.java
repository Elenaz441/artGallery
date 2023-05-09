package com.example.artgallery.adapter.web.validation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@NotNull
@Future
@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { })
@Documented
public @interface DateExhibitionConstraint {

    String message() default "{DateExhibitionConstraint.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
