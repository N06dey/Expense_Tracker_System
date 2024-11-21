package com.evc.expense_tracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double amount;
    private LocalDate date;


    // Connects user table to the entity table
    // where user.id==expense.user_id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User connection;

    // Category
    private String category;

}
