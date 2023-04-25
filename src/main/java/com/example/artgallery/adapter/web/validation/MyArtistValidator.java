package com.example.artgallery.adapter.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyArtistValidator implements ConstraintValidator<ArtistConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (! value.equals("")) {
            return Character.isUpperCase(value.charAt(0));
        }
        return false;
    }
}
