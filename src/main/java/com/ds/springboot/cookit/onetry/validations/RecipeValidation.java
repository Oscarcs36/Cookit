package com.ds.springboot.cookit.onetry.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ds.springboot.cookit.onetry.entities.Recipe;

@Component
public class RecipeValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Recipe.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Recipe recipe = (Recipe) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",  "NotEmpty.recipe.title");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",  "NotBlank.recipe.description");

        if(recipe.getDescription() == null || recipe.getDescription().isBlank()){
            errors.rejectValue("description", "NotBlank.recipe.description");
        }
    }

}
