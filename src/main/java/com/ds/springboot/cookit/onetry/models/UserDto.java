package com.ds.springboot.cookit.onetry.models;


public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String aboutMe;
    private String profilePicture;

    public UserDto(){}

    public UserDto(Long id, String name, String lastName, String email, String aboutMe, String profilePicture) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.aboutMe = aboutMe;
        this.profilePicture = profilePicture;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAboutMe() {
        return aboutMe;
    }
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }    
}
