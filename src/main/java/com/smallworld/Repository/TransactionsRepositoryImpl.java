package com.smallworld.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smallworld.data.Transaction;
import com.smallworld.utils.JsonReader;

public class TransactionsRepositoryImpl implements TransactionsRepository{
	
	JsonReader converter = new JsonReader();
	
	List<Transaction> transactions = converter.readFile();

	public List<Transaction> getTranasactions() {
		return transactions;
	}

	public double getTotalAmount() {
		double totalAmount = 0;
		for (Transaction transaction : transactions) {
			if (transaction.getAmount() != null) {
				totalAmount += transaction.getAmount();
			}
		}
		return totalAmount;
	}

	public double findTotalTransactionAmountBySenderFullName(String senderName) {
		Double totalAmount = null;
		for (Transaction transaction : transactions) {
			if (transaction.getSenderFullName().equals(senderName) && transaction.getAmount() != null) {
				totalAmount += transaction.getAmount();
			}
		}
		return totalAmount;
	}

	public double findMaximumAmount() {
		double maxAmount = Double.MIN_VALUE;

		for (Transaction transaction : transactions) {
			double amount = transaction.getAmount();
			if (amount > maxAmount) {
				maxAmount = amount;
			}
		}
		return maxAmount;
	}

	public long findCountOfUniqueSenders() {
		int count = 0;
		Map<String, Integer> uniqueClients = new HashMap<>();
		for (Transaction transaction : transactions) {
			if (uniqueClients.containsKey(transaction.getSenderFullName())) {
				uniqueClients.put(transaction.getSenderFullName(),uniqueClients.get(transaction.getSenderFullName())+1);
			}else {
				
				uniqueClients.put(transaction.getSenderFullName(), 1);
			}
		}
		
		for (Map.Entry<String,Integer> entry : uniqueClients.entrySet()) {
			if(entry.getValue()==1) {
				count++;
			}
		}
		return count;
	}


	public List<Transaction> findByIssueSolved(Boolean boolValue) {
		List<Transaction> userTransactions = new ArrayList<>();
		// stream.filter
		for (Transaction transaction : transactions) {
			if (transaction.getIssueSolved() && boolValue == true) {
				userTransactions.add(transaction);
			} else if (boolValue == false && !transaction.getIssueSolved()) {
				userTransactions.add(transaction);
			}
			{
			}
		}
		return userTransactions;
	}

	public List<Transaction> findBySenderFullNameAndIssueNotResolved(String name) {
		List<Transaction> particularSendersTransaction = new ArrayList<>();
		for (Transaction transaction : transactions) {
			if (transaction.getSenderFullName().equals(name) && transaction.getIssueSolved() == false) {
				particularSendersTransaction.add(transaction);
			}
		}
		return particularSendersTransaction;
	}

	public Map<String, List<Transaction>> findAllTransactionsByBenificiaryName() {
		Map<String, List<Transaction>> benificiaryTransactions = new HashMap<>();
		for (Transaction transaction : transactions) {
			if (benificiaryTransactions.containsKey(transaction.getBeneficiaryFullName())) {
				List<Transaction> transactionsList = benificiaryTransactions.get(transaction.getBeneficiaryFullName());
				transactionsList.add(transaction);
				benificiaryTransactions.put(transaction.getBeneficiaryFullName(),
						transactionsList) ;
			}
			List<Transaction> transactionList = new ArrayList<>();
			transactionList.add(transaction);
			benificiaryTransactions.put(transaction.getBeneficiaryFullName(), transactionList);
		}
		return benificiaryTransactions;
	}

	public List<Transaction> findTopTransactions(Integer count) {
		java.util.Collections.sort(transactions, new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				// TODO Auto-generated method stub
				return o2.getAmount() - o1.getAmount();
			}

		});
		return transactions.subList(0, count);
	}
	
	public List<String> findTopSender(){
		
		HashMap<String, Integer> senderTotalAmount = new HashMap<>();

		for (Transaction transaction : transactions) {
			senderTotalAmount.put(transaction.getSenderFullName(),
					senderTotalAmount.getOrDefault(transaction.getSenderFullName(), 0) + transaction.getAmount());

		}
		List<String> topSenderList = new ArrayList() ;
		String topSender = null;
		int maxAmount = 0;
		
		for (String sender : senderTotalAmount.keySet()) {
			int totalAmount = senderTotalAmount.get(sender);
			if(maxAmount < totalAmount) {
				maxAmount = totalAmount;
				topSender = sender;
			}
		}
		topSenderList.add(topSender);
		return topSenderList;
	}
}
