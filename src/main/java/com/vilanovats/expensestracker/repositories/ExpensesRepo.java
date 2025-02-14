package com.vilanovats.expensestracker.repositories;

import com.vilanovats.expensestracker.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses, Integer> {

    List<Expenses> findAllByDateBetween(LocalDate dateBefore, LocalDate dateAfter);
}
