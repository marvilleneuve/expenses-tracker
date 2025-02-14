package com.vilanovats.expensestracker.services.impl;

import com.vilanovats.expensestracker.entities.Expenses;
import com.vilanovats.expensestracker.repositories.ExpensesRepo;
import com.vilanovats.expensestracker.services.ExpensesService;
import com.vilanovats.expensestracker.utils.DateTimeFormatterUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    private final ExpensesRepo expensesRepo;

    final static public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ExpensesServiceImpl(ExpensesRepo expensesRepo) {
        this.expensesRepo = expensesRepo;
    }

    public List<Expenses> getAllexpenses() {
        return expensesRepo.findAll();
    }

    @Override
    public List<Expenses> getAllByMonth(String date) {

        DateTimeFormatter dtfu = DateTimeFormatterUtils.formatter;
        LocalDate localDate = LocalDate.parse(date, dtfu);

        //Getting First and Last day of received month
        LocalDate initialDate = localDate.withMonth(1);
        LocalDate finalDate = localDate.withDayOfMonth(localDate.lengthOfMonth());


        System.out.println("dateBefore:" + initialDate);
        System.out.println("dateAfter:" + finalDate);
        return expensesRepo.findAllByDateBetween(initialDate, finalDate);
    }

    @Override
    public void addExpense(Expenses expenses) {
        expensesRepo.save(expenses);
        System.out.println("Saving expenses");
    }
}
