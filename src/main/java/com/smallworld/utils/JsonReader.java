package com.smallworld.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallworld.data.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonReader {
	public List<Transaction> readFile() {
		File file = new File("./Transactions.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (!file.exists()) {
				throw new FileNotFoundException("No file with path transaction.json found");
			}
			List<Transaction> transaction = mapper.readValue(file, new TypeReference<List<Transaction>>() {
			});
			return transaction;
//			for (Transaction transaction2 : transaction) {
//				System.out.println(transaction2.getBeneficiaryFullName());
//			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
