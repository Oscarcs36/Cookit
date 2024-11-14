package com.ds.springboot.cookit.onetry.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "{NotEmpty.recipe.title}")
    @Size(max = 25)
    private String title;

    private String image;

    @NotBlank(message = "{NotBlank.recipe.description}")
    @Size(max = 150)
    private String description;
    
    @ManyToOne()
    private User user;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "recipe")
    private List<Procedure> procedures;
 
    @Column(name = "recipe_duration")
    @Min(1)
    @NotNull(message = "{NotNull.recipe.recipeDuration}")
    private int recipeDuration;

    public Recipe(){
        this.procedures = new ArrayList<>();
    }

    public Recipe(String title, String description, String image, int recipeDuration) {
        this();
        this.title = title;
        this.description = description;
        this.image = image;
        this.recipeDuration = recipeDuration;
    }

    public Recipe(String title, String description, String image, int recipeDuration, User user) {
        this();
        this.title = title;
        this.description = description;
        this.image = image;
        this.recipeDuration = recipeDuration;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRecipeDuration() {
        return recipeDuration;
    }

    public void setRecipeDuration(int recipeDuration) {
        this.recipeDuration = recipeDuration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
