package com.charters.portal.repository;

import com.charters.portal.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByCustomerIdAndTransactionDateGreaterThan(Integer customerId, LocalDate transactionDate);
	List<Transaction> findByCustomerId(Integer customerId);
}
