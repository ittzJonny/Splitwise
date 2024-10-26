package com.project.splitwise.Strategy;

import com.project.splitwise.Models.Expense;
import com.project.splitwise.Models.NetAmounts;
import com.project.splitwise.Models.Transaction;
import com.project.splitwise.Models.User;
import org.springframework.data.util.Pair;

import java.util.*;

public class SettleUpStrategyHeap extends SettleUpStrategy{

    private PriorityQueue<Pair<User,Double>> minHeap;
    private PriorityQueue<Pair<User, Double>> maxHeap;

    @Override
    public List<Transaction> settleUp(List<NetAmounts> netAmountsList) {
        creatHeaps(netAmountsList);

        return getSettleUpTransactions();
    }

    private void creatHeaps(List<NetAmounts> netAmounts)
    {
        //creating priority queues// natural ordering is in ascending
        minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getSecond));// min val first
        maxHeap = new PriorityQueue<>(
                Comparator.comparing(Pair<User,Double>::getSecond).reversed()
        );

        netAmounts.forEach(v->
            {
                if (v.getNetAmount()<0)
                {
                    minHeap.add(Pair.of(v.getUser(), v.getNetAmount()));
                }
                else
                {
                    maxHeap.add(Pair.of(v.getUser(), v.getNetAmount()));
                }
            }



        );

    }

    private List<Transaction> getSettleUpTransactions() {

        List<Transaction> transactionList = new ArrayList<>();

        while (!minHeap.isEmpty() && !maxHeap.isEmpty())
        {
            Pair<User,Double> minPair = minHeap.poll();
            Pair<User,Double> maxPair = maxHeap.poll();

            double clash =  minPair.getSecond()+maxPair.getSecond();

            if (clash>0)
            {
                maxHeap.add(Pair.of(maxPair.getFirst(),clash));

            }
            else
            {
                minHeap.add(Pair.of(minPair.getFirst(),clash));

            }


            Transaction transaction= new Transaction();
            transaction.setAmount(Math.abs(minPair.getSecond()));
            transaction.setPaidTo(maxPair.getFirst());
            transaction.setPaidBy(minPair.getFirst());

            transactionList.add(transaction);

        }

        return transactionList;

    }
}
