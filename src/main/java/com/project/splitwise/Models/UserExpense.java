package com.project.splitwise.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class UserExpense extends BaseModel{

    int amount;

    @ManyToOne
    User user;

    @Enumerated(value = EnumType.STRING)
    UserExpenseType userExpenseType;

    @ManyToOne
    Expense expense;

}
