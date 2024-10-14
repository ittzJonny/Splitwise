package com.project.splitwise.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FailureResponse extends ResponseFormat{
    ResponseStatus responseStatus;
    String message;

    @Override
    public String toString() {
        return "FailureResponse{" +
                "responseStatus=" + responseStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
