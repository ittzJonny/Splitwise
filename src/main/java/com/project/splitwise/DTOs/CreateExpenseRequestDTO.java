package com.project.splitwise.DTOs;

import com.project.splitwise.Models.UserExpenseType;
import lombok.Data;

import java.util.List;

@Data
public class CreateExpenseRequestDTO {
    String expenseCreatorPhoneNumber;
    String groupName;
    String description ;
    java.util.List<Integer> amounts;
    List<String> userPhones;
    List<UserExpenseType> userExpenseTypes;
}
