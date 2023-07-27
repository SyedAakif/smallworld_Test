package coding_test;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallworld.Repository.TransactionsRepository;
import com.smallworld.Repository.TransactionsRepositoryImpl;
import com.smallworld.data.Transaction;

public class TransactionRepositoryTest {
	
	TransactionsRepository repo = new TransactionsRepositoryImpl();
	
	final String TEST_PATH_TRANSACTION = "./src/test/java/coding_test/testTransactions.json";
	
	File testFile = null;
	
	@SuppressWarnings("deprecation")
	@Test
	public void getTotalTransactionAmount_Test() {
		System.out.println(repo.getTotalAmount());
		junit.framework.Assert.assertEquals(4368.0, repo.getTotalAmount());
	}

	@Test
	public void findBySenderFullName_Test() {
		File file = getTestTrasactionFile();
		ObjectMapper mapper = new ObjectMapper();
		List<Transaction> transaction;
		try {
			transaction = mapper.readValue(file, new TypeReference<List<Transaction>>() {
			});
			Assert.assertTrue(transaction.size() == repo.findBySenderFullNameAndIssueNotResolved("Arthur Shelby").size()
					&& transaction.containsAll(repo.findBySenderFullNameAndIssueNotResolved("Arthur Shelby")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}

	}

	@Test
	public void findMaximumAmount_Test() {
		System.out.println("Maximum Amount :: " + repo.findMaximumAmount());
		junit.framework.Assert.assertEquals(985.0, repo.findMaximumAmount());
	}

	@Test
	public void findCountOfUniqueSenders_Test() {
		System.out.println("Unique Senders Count :: " + repo.findCountOfUniqueSenders());
		junit.framework.Assert.assertEquals(1, repo.findCountOfUniqueSenders());
	}

	@Test
	public void findBySenderFullNameAndIssueNotResolved_Test() {
		File file = getTestTrasactionFile();
		ObjectMapper mapper = new ObjectMapper();
		List<Transaction> transaction;
		try {
			transaction = mapper.readValue(file, new TypeReference<List<Transaction>>() {
			});
			Assert.assertTrue(transaction.size() == repo.findBySenderFullNameAndIssueNotResolved("Arthur Shelby").size()
					&& transaction.containsAll(repo.findBySenderFullNameAndIssueNotResolved("Arthur Shelby")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}

	@Test
	public void findAllTransactionsByBenificiaryName_Test() {
		File file = getTestTrasactionFile();
		ObjectMapper mapper = new ObjectMapper();
		List<Transaction> transaction;
		try {
			transaction = mapper.readValue(file, new TypeReference<List<Transaction>>() {
			});
			Assert.assertTrue(
					transaction.size() == repo.findAllTransactionsByBenificiaryName().get("Ben Younger").size()
							&& transaction.containsAll(repo.findAllTransactionsByBenificiaryName().get("Ben Younger")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}

	@Test
	public void findByIssueSolved_Test() {
		File file = getTestTrasactionFile();
		ObjectMapper mapper = new ObjectMapper();
		List<Transaction> transaction;
		try {
			transaction = mapper.readValue(file, new TypeReference<List<Transaction>>() {
			});
			Assert.assertTrue(repo.findByIssueSolved(false).containsAll(transaction));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}

	@Test
	public void findTopTransactions_Test() {
		File file = getTestTrasactionFile();
		ObjectMapper mapper = new ObjectMapper();
		List<Transaction> transaction;
		try {
			transaction = mapper.readValue(file, new TypeReference<List<Transaction>>() {
			});
			Assert.assertTrue(repo.findTopTransactions(1).containsAll(transaction));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}

	@Test
	public void findTopSender_Test() {
		junit.framework.Assert.assertEquals("Grace Burgess" ,repo.findTopSender().get(0));
	}
	
	private File getTestTrasactionFile() {
		if(testFile == null) {
			testFile = new File(TEST_PATH_TRANSACTION);
		}
		return testFile;
	}
}
