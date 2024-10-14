package com.project.splitwise.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GroupResponseDTO extends ResponseFormat{
    private String groupName;
    private long groupId;
    private String groupAdmin;
    private String groupAdminPhoneNumber;
    private List<String> memberList;
    private List<String> memberPhoneList;
    private ResponseStatus responseStatus;
    private String responseMessage;

    public GroupResponseDTO() {
        this.memberList = new ArrayList<>();
        this.memberPhoneList = new ArrayList();;
    }

    @Override
    public String toString() {
        return "GroupResponseDTO{" +
                "groupName='" + groupName + '\'' +
                ", groupId=" + groupId +
                ", groupAdmin='" + groupAdmin + '\'' +
                ", groupAdminPhoneNumber='" + groupAdminPhoneNumber + '\'' +
                ", memberList=" + memberList +
                ", memberPhoneList=" + memberPhoneList +
                ", responseStatus=" + responseStatus +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
