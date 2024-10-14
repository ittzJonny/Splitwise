package com.project.splitwise.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupResponseDTO extends ResponseFormat{

    private String groupName;
    private long groupId;
    private String groupAdmin;
    private String groupAdminPhoneNumber;
    private ResponseStatus responseStatus;
    private String responseMessage;

    @Override
    public String toString() {
        return "CreateGroupResponseDTO{" +
                "groupName='" + groupName + '\'' +
                ", groupId=" + groupId +
                ", groupAdmin='" + groupAdmin + '\'' +
                ", groupAdminPhoneNumber='" + groupAdminPhoneNumber + '\'' +
                ", responseStatus=" + responseStatus +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
