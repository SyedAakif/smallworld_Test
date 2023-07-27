package com.smallworld.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smallworld.data.Transaction;

public interface TransactionsRepository{

	public List<Transaction> getTranasactions();

	public double getTotalAmount();

	public double findTotalTransactionAmountBySenderFullName(String senderName);

	public double findMaximumAmount();

	public long findCountOfUniqueSenders();

	public List<Transaction> findByIssueSolved(Boolean boolValue);

	public List<Transaction> findBySenderFullNameAndIssueNotResolved(String name);

	public Map<String, List<Transaction>> findAllTransactionsByBenificiaryName();

	public List<Transaction> findTopTransactions(Integer count);

	public List<String> findTopSender();
}
