package com.project.splitwise.Services;

import com.project.splitwise.Models.*;
import com.project.splitwise.Repositories.ExpenseRepo;
import com.project.splitwise.Repositories.GroupRepo;
import com.project.splitwise.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private UserExpenseService userExpenseService;

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private UserService userService;


    @Autowired
    public ExpenseService(UserRepo userRepo, GroupRepo groupRepo, UserExpenseService userExpenseService, ExpenseRepo expenseRepo, UserService userService) {
        this.userRepo = userRepo;
        this.groupRepo = groupRepo;
        this.userExpenseService = userExpenseService;
        this.expenseRepo = expenseRepo;
        this.userService = userService;
    }

    public Expense addExpense(String creatorPhoneNumber, String groupName, String description ,
                              List<Integer> amounts, List<String> userPhones, List<UserExpenseType> userExpenseTypes) {

        User user= userService.getUserByPhone(creatorPhoneNumber);
        Group gp = null;
        if (groupName!=null)
        {
            gp=groupRepo.findByName(groupName).orElseThrow(()-> new RuntimeException("Group not found"));
        }

        List<UserExpense> userExpenses= new ArrayList<>();

        int totalExpenseAmount=0;

        for (int i=0;i<amounts.size();i++) {
            int amount= amounts.get(i);
            String phone =userPhones.get(i);
            UserExpenseType userExpenseType= userExpenseTypes.get(i);

            UserExpense ue = userExpenseService.createUserExpense(amount,phone,userExpenseType);

            userExpenses.add(ue);

            if (userExpenseType.equals(UserExpenseType.PAID_BY)) {
                totalExpenseAmount += amount;
            }

        }

        Expense expense= new Expense();
        expense.setAmount(totalExpenseAmount);
        expense.setDescription(description);
        expense.setGroup(gp);
        expense.setExpenseType(gp==null?ExpenseType.DIRECT:ExpenseType.GROUP);
        expense.setAddedBy(user);
        expense.setUserExpenseList(userExpenses);

        expense=expenseRepo.save(expense);

        for (UserExpense ue: userExpenses) {
            ue.setExpense(expense);
        }

        userExpenseService.saveUserExpenses(userExpenses);

        return expense;

    }


}
