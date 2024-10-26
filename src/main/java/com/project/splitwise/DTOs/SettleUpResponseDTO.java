package com.project.splitwise.DTOs;

import com.project.splitwise.Models.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleUpResponseDTO extends ResponseFormat{
    List<Transaction> transactionList;
    ResponseStatus responseStatus;
}
