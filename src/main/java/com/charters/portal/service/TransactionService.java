package com.charters.portal.service;

import com.charters.portal.model.Reward;
import com.charters.portal.model.Transaction;
import com.charters.portal.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Reward fetchRewards(Integer customerId){
        LocalDate date = getDate();
        List<Transaction> transactions = transactionRepository.findByCustomerIdAndTransactionDateGreaterThan(customerId, date);
        Integer totalRewards = getTotalRewards(transactions);
        Map<Month, Integer> monthlyWiseRewards = getMonthlyWiseRewards(transactions);
        return Reward.builder().customerId(customerId).totalRewards(totalRewards).rewardsByMonthly(monthlyWiseRewards).build();
    }

    private Integer getTotalRewards(List<Transaction> transactions) {
        return transactions.stream()
                    .map(Transaction::getRewards)
                    .reduce(0, Integer::sum);
    }

    private Map<Month, Integer> getMonthlyWiseRewards(List<Transaction> transactions) {

        Map<Month, List<Transaction>> transactionsByMonthly = transactions.stream()
                .collect(Collectors.groupingBy(item -> item.getTransactionDate().getMonth()));

        Map<Month, Integer> rewardsByMonthly = new HashMap<>();
        transactionsByMonthly.forEach((key, value) -> {
            rewardsByMonthly.put(key, value.stream().mapToInt(Transaction::getRewards).reduce(0, Integer::sum));
        });

        return rewardsByMonthly;
    }

    public List<Transaction> fetchTransactions(Integer customerId){
        return transactionRepository.findByCustomerId(customerId);
    }

    public void save(Transaction transaction) {
        Integer rewards = calculateRewards(transaction.getAmount());
        transaction.setRewards(rewards);
        Transaction save = transactionRepository.save(transaction);
    }

    private LocalDate getDate() {
        return LocalDate.now().minusMonths(2).withDayOfMonth(1);
    }

    private Integer calculateRewards(Integer amount) {
        return amount > 50 ? amount > 100 ? (amount - 100) * 2 + 50 : amount - 50 : 0;
    }

    private void testMethod(){
        // nothing to add
    }

    private void testMethod1(){
        // nothing to add
        // nothing to add
        // hello
    }


}
