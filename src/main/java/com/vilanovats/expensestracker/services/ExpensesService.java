package com.vilanovats.expensestracker.services;

import com.vilanovats.expensestracker.entities.Expenses;

import java.util.List;
import java.util.UUID;

public interface ExpensesService {
    void addExpense(Expenses expenses);
    List<Expenses> getAllexpenses();
    Expenses getExpenseById(UUID id);
    List<Expenses> getAllByMonth(String date);
}
