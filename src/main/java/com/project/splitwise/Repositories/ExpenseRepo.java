package com.project.splitwise.Repositories;

import com.project.splitwise.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    List<Expense> findAllByGroup_Id(Long id);

}
