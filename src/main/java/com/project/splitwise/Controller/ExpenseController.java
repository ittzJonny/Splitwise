package com.project.splitwise.Controller;

import com.project.splitwise.DTOs.*;
import com.project.splitwise.Models.Expense;
import com.project.splitwise.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    public ResponseFormat addExpense(CreateExpenseRequestDTO req)
    {
        ResponseFormat resp=null;
        try {
            CreateExpenseResponseDTO res= new CreateExpenseResponseDTO();
            Expense expense = expenseService.addExpense(req.getExpenseCreatorPhoneNumber(),
                    req.getGroupName(),
                    req.getDescription(),
                    req.getAmounts(),
                    req.getUserPhones(),
                    req.getUserExpenseTypes());
            res.setExpense(expense);
            res.setResponseStatus(ResponseStatus.SUCCESS);
            res.setResponseMessage("Successfully added expense");
            resp=res;
        }
        catch (Exception e)
        {
            FailureResponse res = new FailureResponse();
            res.setMessage("Error while adding expense"+e.getMessage());
            res.setResponseStatus(ResponseStatus.FAIL);
            resp=res;
        }


        return resp;
    }

}
