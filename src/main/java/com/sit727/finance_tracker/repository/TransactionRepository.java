package com.sit727.finance_tracker.repository;

import com.sit727.finance_tracker.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}