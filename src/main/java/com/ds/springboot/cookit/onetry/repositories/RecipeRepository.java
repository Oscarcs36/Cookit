package com.ds.springboot.cookit.onetry.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ds.springboot.cookit.onetry.entities.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
