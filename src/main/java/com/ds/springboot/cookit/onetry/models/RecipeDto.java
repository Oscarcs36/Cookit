package com.ds.springboot.cookit.onetry.models;

public class RecipeDto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private int recipeDuration;
    private String userName;

    public RecipeDto(){}
    
    public RecipeDto(Long id, String title, String image, String description, int recipeDuration, String userName) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.recipeDuration = recipeDuration;
        this.userName = userName;
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getRecipeDuration() {
        return recipeDuration;
    }
    public void setRecipeDuration(int recipeDuration) {
        this.recipeDuration = recipeDuration;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
