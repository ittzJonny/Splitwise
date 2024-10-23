package com.project.splitwise.Repositories;

import com.project.splitwise.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {



}
