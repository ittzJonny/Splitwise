package com.project.splitwise.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberInGroupRequestDTO {
    String memberPhoneNumber;
    String groupName;
}
