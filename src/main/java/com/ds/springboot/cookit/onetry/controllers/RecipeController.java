package com.ds.springboot.cookit.onetry.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ds.springboot.cookit.onetry.entities.Recipe;
import com.ds.springboot.cookit.onetry.models.RecipeDto;
import com.ds.springboot.cookit.onetry.services.RecipeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    RecipeService service;

    @GetMapping
    public List<RecipeDto> listAll() {
        return service.listAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<RecipeDto> recipeOptional = service.findById(id);

        if(recipeOptional.isPresent()){
            return ResponseEntity.ok(recipeOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Recipe recipe, BindingResult result) {
        if(result.hasFieldErrors()){
            return validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(recipe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid  @RequestBody Recipe recipe, BindingResult result, @PathVariable Long id) {
        if(result.hasFieldErrors()){
            return validation(result);
        }
        
        Optional<Recipe> recipeOptional = service.update(id, recipe);

        if(recipeOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(recipeOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Recipe> recipeOptional = service.delete(id);

        if(recipeOptional.isPresent()){
            return ResponseEntity.ok(recipeOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}
