package com.charters.portal.controller;

import com.charters.portal.model.Reward;
import com.charters.portal.model.Transaction;
import com.charters.portal.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/add")
	public void createTransaction(@RequestBody Transaction transaction) {
		transactionService.save(transaction);
	}

	@GetMapping("/{customerId}")
	public List<Transaction> getTransactions(@PathVariable Integer customerId) {
		// pratap
		return transactionService.fetchTransactions(customerId);
	}
}
