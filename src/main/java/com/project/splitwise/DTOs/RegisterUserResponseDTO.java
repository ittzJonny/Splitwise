package com.project.splitwise.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDTO extends ResponseFormat {
    private long userId;
    private String name;
    private String phoneNumber;
    private String password;
    private ResponseStatus responseStatus;
    private String responseMessage;

    @Override
    public String toString() {
        return "RegisterUserResponseDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", responseStatus=" + responseStatus +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
