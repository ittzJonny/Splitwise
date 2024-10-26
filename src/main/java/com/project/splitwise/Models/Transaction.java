package com.project.splitwise.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Transaction extends BaseModel{
    double amount;
    @ManyToOne
    User paidTo;
    @ManyToOne
    User paidBy;
}
