package com.evc.expense_tracker.DAO;

import com.evc.expense_tracker.entity.Expense;

import java.util.List;

public interface ExpenseDAO {
    Expense save(Expense expense);
    Expense findById(Long id);
    List<Expense> findByUserId(Long userId);
    List<Expense> findAll();
    void deleteById(Long id);
}
