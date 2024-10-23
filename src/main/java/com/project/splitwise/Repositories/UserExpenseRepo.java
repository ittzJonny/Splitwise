package com.project.splitwise.Repositories;

import com.project.splitwise.Models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepo extends JpaRepository<UserExpense, Long> {


}
