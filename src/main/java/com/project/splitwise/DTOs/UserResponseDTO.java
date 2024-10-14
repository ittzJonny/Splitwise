package com.project.splitwise.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO extends ResponseFormat{
    private String name;
    private String phoneNumber;
    private List<String> groupList;
    private ResponseStatus responseStatus;
    private String responseMessage;

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", groupList=" + groupList +
                ", responseStatus=" + responseStatus +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
