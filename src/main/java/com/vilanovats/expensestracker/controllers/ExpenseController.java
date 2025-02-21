package com.vilanovats.expensestracker.controllers;

import com.vilanovats.expensestracker.entities.Expenses;
import com.vilanovats.expensestracker.services.ExpensesService;
import com.vilanovats.expensestracker.utils.ExpensesServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpenseController {

    ExpensesService expensesService;

    @Autowired
    public ExpenseController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllExpenses() {
        try {
            List<Expenses> allExpensesList = expensesService.getAllexpenses();
            return ExpensesServiceResponse.generateResponse("Request completed", HttpStatus.OK, allExpensesList);
        } catch (Exception e) {
            return ExpensesServiceResponse.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, e.getStackTrace());
        }
    }

    @GetMapping("/allByMonth/{date}")
    public ResponseEntity<Object> getAllExpensesByMonth(@PathVariable String date) {
        List<Expenses> allExpensesList = expensesService.getAllByMonth(date);
        return ExpensesServiceResponse.generateResponse("Request completed", HttpStatus.OK, allExpensesList);
    }

    @GetMapping("/expenseId/{expenseId}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("expenseId") UUID expenseId) {
        Expenses expense = expensesService.getExpenseById(expenseId);
        return ExpensesServiceResponse.generateResponse("Request completed", HttpStatus.OK, expense);
    }

    @GetMapping("/userId/{userId}")
    public String getExpensesByUserId(@PathVariable("userId") Integer userId) {
        return "User " + userId;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addExpense(@RequestBody Expenses expense) {
        System.out.println("expense = " + expense);

        try {
            expensesService.addExpense(expense);

            return ExpensesServiceResponse.generateResponse("Request completed", HttpStatus.OK, expense.getName());
        }
        catch (RuntimeException e) {
            return ExpensesServiceResponse.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, e.getStackTrace());
        }
    }

}
