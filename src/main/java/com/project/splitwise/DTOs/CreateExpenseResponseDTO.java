package com.project.splitwise.DTOs;

import com.project.splitwise.Models.Expense;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateExpenseResponseDTO extends ResponseFormat{

    Expense expense;
    String responseMessage;
    ResponseStatus responseStatus;
}
