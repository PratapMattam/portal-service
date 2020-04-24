package com.charters.portal.controller;

import com.charters.portal.model.Reward;
import com.charters.portal.model.Transaction;
import com.charters.portal.repository.TransactionRepository;
import com.charters.portal.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
	@Autowired
	private TransactionService transactionRepository;

	@GetMapping("/{customerId}")
	public Reward getRewards(@PathVariable Integer customerId) {
		return transactionRepository.fetchRewards(customerId);
	}
}
