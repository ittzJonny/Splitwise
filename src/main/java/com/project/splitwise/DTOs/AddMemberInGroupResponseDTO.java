package com.project.splitwise.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddMemberInGroupResponseDTO extends ResponseFormat{
    String message;
    ResponseStatus responseStatus;


}
