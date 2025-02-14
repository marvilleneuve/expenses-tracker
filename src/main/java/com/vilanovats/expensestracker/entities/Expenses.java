package com.vilanovats.expensestracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private Integer categoryId;
    private Integer userId;
    private LocalDate date;
    private double amount;

    public Expenses(String name, String description, LocalDate date, double amount) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

}
