package com.ds.springboot.cookit.onetry.mapper;

import com.ds.springboot.cookit.onetry.entities.User;
import com.ds.springboot.cookit.onetry.models.UserDto;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getAboutMe(),
                user.getProfilePicture()
        );
        return userDto;
    }
}
