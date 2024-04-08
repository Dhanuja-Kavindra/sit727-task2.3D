package com.sit727.finance_tracker.controller;

import com.sit727.finance_tracker.model.Transaction;
import com.sit727.finance_tracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Date;
import java.util.List;

@Controller
public class FinanceTrackerController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/financeTracker")
    public String showFinanceTrackerPage(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "financeTracker";
    }

    @PostMapping("/addTransaction")
    public String addTransaction(Transaction transaction) {
        transaction.setTransactionDate(new Date()); // Set the current date as the transaction date
        transactionRepository.save(transaction);
        return "redirect:/financeTracker";
    }
    
    @GetMapping("/financeHistory")
    public String showFinanceHistory(Model model) {
        List<Transaction> transactions = transactionRepository.findAll();
        model.addAttribute("transactions", transactions);
        return "financeHistory";
    }
}