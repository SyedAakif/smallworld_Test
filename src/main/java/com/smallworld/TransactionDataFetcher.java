package com.smallworld;

import com.smallworld.Repository.TransactionsRepository;
import com.smallworld.Repository.TransactionsRepositoryImpl;
import com.smallworld.data.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TransactionDataFetcher {
	TransactionsRepository repo = new TransactionsRepositoryImpl();

	/**
	 * Returns the sum of the amounts of all transactions
	 */
	public double getTotalTransactionAmount() {
		double totalAmount = repo.getTotalAmount();
		System.out.println("Total Transaction Amount :: " + totalAmount);
		return totalAmount;
//        throw new UnsupportedOperationException();
	}

	/**
	 * Returns the sum of the amounts of all transactions sent by the specified
	 * client
	 */
	public double getTotalTransactionAmountSentBy(String senderFullName) {
		Double totalAmount = repo.findTotalTransactionAmountBySenderFullName(senderFullName);
		if (totalAmount != 0.0 && totalAmount != null) {
			System.out.println("Total Transaction Amount by sender " + senderFullName + " is :: " + totalAmount);
		} else {
			System.out.println("No Transaction found for this sender " + senderFullName);
		}
		
		return totalAmount;

	}

	/**
	 * Returns the highest transaction amount
	 */
	public double getMaxTransactionAmount() {
		Double maxAmount = repo.findMaximumAmount();
		System.out.println("Maximum Transaction amount :: " + maxAmount);
		return maxAmount;
	}

	/**
	 * Counts the number of unique clients that sent or received a transaction
	 */
	public long countUniqueClients() {
		long UniqueCount = repo.findCountOfUniqueSenders();
		System.out.println("Unique clients count :: " + UniqueCount);
		return UniqueCount;
	}

	/**
	 * Returns whether a client (sender or beneficiary) has at least one transaction
	 * with a compliance issue that has not been solved
	 */
	public boolean hasOpenComplianceIssues(String clientFullName) {
		List<Transaction> trans = repo.findBySenderFullNameAndIssueNotResolved(clientFullName);
		if (trans.size() > 0) {
			System.out.println("Client has open a compliance Issue");
			return true;
		}
		System.out.println("No open Issues. ");
		return false;
	}

	/**
	 * Returns all transactions indexed by beneficiary name
	 */
	public Map<String, Transaction> getTransactionsByBeneficiaryName() {
		List<Transaction> trans = repo.getTranasactions();
		Map<String, Transaction> benificiaryTransactions = new HashMap<>();
		for (Transaction transaction : trans) {
			benificiaryTransactions.put(transaction.getBeneficiaryFullName(), transaction);
		}
		return benificiaryTransactions;
	}

	// This is an override method as there  is a list of transaction for particular benificiary
	public Map<String, List<Transaction>> getTransactionsByBeneficiaryNameModified() {
		// TODO Auto-generated method stub
		Map<String, List<Transaction>> benificiaryTransactions = repo.findAllTransactionsByBenificiaryName();
		return benificiaryTransactions;
	}

	/**
	 * Returns the identifiers of all open compliance issues
	 */
	public Set<Integer> getUnsolvedIssueIds() {
		List<Transaction> trans = repo.findByIssueSolved(false);
		Set<Integer> unsolvedIds = new HashSet<>();
		for (Transaction transaction : trans) {
			unsolvedIds.add(transaction.getIssueId());
		}
		System.out.println(unsolvedIds.size());
		return unsolvedIds;
	}

	/**
	 * Returns a list of all solved issue messages
	 */
	public List<String> getAllSolvedIssueMessages() {
		List<Transaction> trans = repo.findByIssueSolved(true);
		List<String> message = new ArrayList<>();
		for (Transaction transaction : trans) {
			message.add(transaction.getIssueMessage());
			System.out.println(transaction.getIssueMessage());
		}
		return message;
	}

	/**
	 * Returns the 3 transactions with the highest amount sorted by amount
	 * descending
	 */
	public List<Transaction> getTop3TransactionsByAmount() {
		List<Transaction> topTransactions = repo.findTopTransactions(3);
		return topTransactions;
	}

	/**
	 * Returns the senderFullName of the sender with the most total sent amount
	 */
	public List<String> getTopSender() {
		List<String> topSenderList = repo.findTopSender();
		return topSenderList;
	}

}
