package com.project.splitwise.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupRequestDTO {

    private String groupName;
    private String phoneNumber;

    @Override
    public String toString() {
        return "CreateGroupRequestDTO{" +
                "groupName='" + groupName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
