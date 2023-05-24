package com.example.artgallery.adapter.web.validation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

// Аннотация валидации для даты создания картины (при создании картины):
// дата должна быть не позднее текущего времени
@NotNull
@PastOrPresent
@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { })
@Documented
public @interface DatePictureConstraint {

    String message() default "{DatePictureConstraint.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
