package com.project.splitwise.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {

    private String name;
    private String phoneNumber;
    private String password;


    @Override
    public String toString() {
        return "RegisterUserRequestDTO{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
