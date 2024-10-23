package com.project.splitwise.Services;

import com.project.splitwise.Models.*;
import com.project.splitwise.Repositories.UserExpenseRepo;
import com.project.splitwise.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserExpenseService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserExpenseRepo userExpenseRepo;

    public UserExpense createUserExpense(int amount, String phone, UserExpenseType userExpenseType) {

        User user= userRepo.findByPhoneNumber(phone).orElseThrow(()-> new RuntimeException("User not found"));

        UserExpense userExpense = new UserExpense();
        userExpense.setUser(user);
        userExpense.setUserExpenseType(userExpenseType);
        userExpense.setAmount(amount);

//        userExpense= userExpenseRepo.save(userExpense);

        return userExpense;

    }

    public List<UserExpense> saveUserExpenses(List<UserExpense> userExpenseList) {
        return userExpenseRepo.saveAll(userExpenseList);
    }

}
