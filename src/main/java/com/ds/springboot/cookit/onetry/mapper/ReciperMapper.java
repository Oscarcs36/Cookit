package com.ds.springboot.cookit.onetry.mapper;

import com.ds.springboot.cookit.onetry.entities.Recipe;
import com.ds.springboot.cookit.onetry.models.RecipeDto;

public class ReciperMapper {
    public static RecipeDto mapTorRecipeDto(Recipe recipe){
        RecipeDto recipeDto = new RecipeDto(
                recipe.getId(),
                recipe.getTitle(),
                recipe.getImage(),
                recipe.getDescription(),
                recipe.getRecipeDuration(),
                recipe.getUser().getName() + " " + recipe.getUser().getLastName()
        );
        return recipeDto;
    }

    public static Recipe mapToRecipe(RecipeDto recipeDto){
        Recipe recipe = new Recipe(
            recipeDto.getTitle(),
            recipeDto.getImage(),
            recipeDto.getDescription(),
            recipeDto.getRecipeDuration()
        );
        return recipe;
    }
}
