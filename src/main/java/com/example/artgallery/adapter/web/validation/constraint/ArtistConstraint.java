package com.example.artgallery.adapter.web.validation.constraint;

import com.example.artgallery.adapter.web.validation.MyArtistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@NotBlank
@Size(min = 2)
@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyArtistValidator.class)
@Documented
public @interface ArtistConstraint  {
    String message() default "Имя должно начинаять с заглавной буквы";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
