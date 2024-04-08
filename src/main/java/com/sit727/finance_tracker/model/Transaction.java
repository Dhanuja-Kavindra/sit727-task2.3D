package com.sit727.finance_tracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String type; // "Income" or "Expense"
    private String description;
    private BigDecimal amount;
    private Date transactionDate;

    // Constructors
    public Transaction() {}

    public Transaction(String type, String description, BigDecimal amount, Date transactionDate) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}