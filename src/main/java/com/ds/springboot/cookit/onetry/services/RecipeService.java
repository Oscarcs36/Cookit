package com.ds.springboot.cookit.onetry.services;

import java.util.*;

import com.ds.springboot.cookit.onetry.entities.Recipe;
import com.ds.springboot.cookit.onetry.models.RecipeDto;

public interface RecipeService {
    List<RecipeDto> listAll();

    Optional<RecipeDto> findById(Long id);
    
    Recipe save(Recipe recipe);

    Optional<Recipe> update(Long id, Recipe recipe);
    
    Optional<Recipe> delete(Long id);
}
