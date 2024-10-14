package com.project.splitwise.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{

    private int amount;
    private String description;

    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;

    @OneToMany(mappedBy = "expense")
    private List<UserExpense> userExpenseList;

    @ManyToOne
    private Group group;
}