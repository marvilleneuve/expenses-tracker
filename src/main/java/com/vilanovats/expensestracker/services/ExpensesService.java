package com.vilanovats.expensestracker.services;

import com.vilanovats.expensestracker.entities.Expenses;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExpensesService {
    public void addExpense(Expenses expenses);
    public List<Expenses> getAllexpenses();
    public List<Expenses> getAllByMonth(String date);
}
