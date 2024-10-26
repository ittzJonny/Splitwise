package com.project.splitwise.Services;

import com.project.splitwise.Models.Expense;
import com.project.splitwise.Models.Group;
import com.project.splitwise.Models.NetAmounts;
import com.project.splitwise.Models.Transaction;
import com.project.splitwise.Repositories.ExpenseRepo;
import com.project.splitwise.Repositories.GroupRepo;
import com.project.splitwise.Strategy.SettleUpStrategy;
import com.project.splitwise.Strategy.SettleUpStrategyHeap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettleUpService {

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private ExpenseRepo expenseRepo;

    private SettleUpStrategy settleUpStrategy;

    public SettleUpService() {
        settleUpStrategy= new SettleUpStrategyHeap();
    }

    public List<Transaction> settleUpGroup(Long groupId){
        Group gp = groupRepo.findById(groupId).orElseThrow(()-> new RuntimeException("Group not found with id: " + groupId));

        List<Expense> groupExpenseList= expenseRepo.findAllByGroup_Id(groupId);

        List<NetAmounts> netAmountsList= settleUpStrategy.getNetAmounts(groupExpenseList);

        return settleUpStrategy.settleUp(netAmountsList);

    }

}
