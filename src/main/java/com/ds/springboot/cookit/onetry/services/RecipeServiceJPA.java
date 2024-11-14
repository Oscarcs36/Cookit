package com.ds.springboot.cookit.onetry.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.springboot.cookit.onetry.entities.Recipe;
import com.ds.springboot.cookit.onetry.mapper.ReciperMapper;
import com.ds.springboot.cookit.onetry.models.RecipeDto;
import com.ds.springboot.cookit.onetry.repositories.RecipeRepository;

@Service
public class RecipeServiceJPA implements RecipeService{

    @Autowired
    RecipeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<RecipeDto> listAll() {
        List<Recipe> recipes = (List<Recipe>) repository.findAll();

         return recipes
            .stream()
            .map(ReciperMapper::mapTorRecipeDto) 
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RecipeDto> findById(Long id) {
        Optional<Recipe> optionalRecipe = repository.findById(id);
        Recipe recipe = optionalRecipe.orElseThrow(() -> new RuntimeException("Recipe not found"));

        return Optional.of(ReciperMapper.mapTorRecipeDto(recipe));
    }

    @Override
    @Transactional
    public Recipe save(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    @Transactional
    public Optional<Recipe> delete(Long id) {
        Optional<Recipe> recipeOptional = repository.findById(id);

        recipeOptional.ifPresent(recipeDb -> {
            repository.delete(recipeDb);
        });

        return recipeOptional;
    }

    @Override
    @Transactional
    public Optional<Recipe> update(Long id, Recipe recipe) {
        Optional<Recipe> recipeOptional = repository.findById(id);

        if(recipeOptional.isPresent()){
            Recipe recipeDb = recipeOptional.orElseThrow();
            
            recipeDb.setTitle(recipe.getTitle());
            recipeDb.setDescription(recipe.getDescription());
            recipeDb.setImage(recipe.getImage());
            recipeDb.setRecipeDuration(recipe.getRecipeDuration());

            return Optional.of(repository.save(recipeDb));
        }

        return recipeOptional;
    }

}
