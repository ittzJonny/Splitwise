package com.project.splitwise.Strategy;

import com.project.splitwise.Models.*;

import java.util.HashMap;
import java.util.List;

public abstract class SettleUpStrategy {


    public abstract List<Transaction> settleUp (List<NetAmounts> netAmountsList);

    public List<NetAmounts> getNetAmounts(List<Expense> expenses)
    {
        HashMap<User,Double> netAmounts = new HashMap<>();
        for (Expense expense : expenses)
        {
            for (UserExpense userExpense : expense.getUserExpenseList())
            {
                User user = userExpense.getUser();
                double userAmt= userExpense.getAmount();

                if(!netAmounts.containsKey(user))
                {
                    netAmounts.put(user,0.0);
                }

                if (userExpense.getUserExpenseType().equals(UserExpenseType.PAID_FOR))
                {
                    userAmt=0-userAmt;
                }
                netAmounts.put(user,netAmounts.get(user)+userAmt);
            }
        }

        List<NetAmounts> netAmountsList=netAmounts.entrySet().parallelStream()
                .map(entry-> new NetAmounts(entry.getValue(), entry.getKey()))
                .toList();

        return netAmountsList;
    }

}
