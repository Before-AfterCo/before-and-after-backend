package com.mpm.beforeandafter.user.service;

import com.mpm.beforeandafter.role.model.Role;
import com.mpm.beforeandafter.user.dto.CreateAboutMeResponseDto;
import com.mpm.beforeandafter.user.dto.CreateUserResponseDto;
import com.mpm.beforeandafter.user.dto.GetAboutMeResponseDto;
import com.mpm.beforeandafter.user.dto.GetUserResponseDto;
import com.mpm.beforeandafter.user.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    CreateUserResponseDto mapToCreateUserResponseDto(User user) {
        return CreateUserResponseDto.builder()
                .userName(user.getName())
                .email(user.getEmail())
                .roles(changeRoleToString(user.getRoles()))
                .build();
    }

    CreateAboutMeResponseDto mapToCreateAboutMeResponseDto(User user) {
        return CreateAboutMeResponseDto.builder()
                .aboutMe(user.getAboutMe())
                .build();
    }

    public GetUserResponseDto mapToGetUserResponseDto(User user) {
        return GetUserResponseDto.builder()
                .userName(user.getName())
                .email(user.getEmail())
                .roles(changeRoleToString(user.getRoles()))
                .build();
    }

    GetAboutMeResponseDto mapToGetAboutMeResponseDto(User user) {
        return GetAboutMeResponseDto.builder()
                .aboutMe(user.getAboutMe())
                .build();
    }

    private List<String> changeRoleToString(Set<Role> roleSet){
        return roleSet.stream().map(role -> role.getName().name()).collect(Collectors.toList());
    }
}
