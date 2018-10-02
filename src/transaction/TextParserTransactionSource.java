package transaction;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
/**
 * This class will handle the insertion of the transaction.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */

public class TextParserTransactionSource implements TransactionSource {
	
	//variables
	private final String transactionsFile = "./res/transactions.txt";
	private final TransactionFactory factory;
	private BufferedReader reader;
	
	//constructor
	public TextParserTransactionSource(TransactionFactory factory) {
		this.factory = factory;
		
		System.out.println(System.getProperty("user.dir"));
		InputStream input;
		try {
			input = new FileInputStream(transactionsFile);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("not found transactions file", e);
		}
		
		reader = new BufferedReader(new InputStreamReader(input));
	}
	
	/**
	 * get the transaction.
	 */
	@Override
	public Transaction getTransaction() {
		try {
			String line = reader.readLine();
			if (line == null) { return null; }
			return parseLine(line);
		} catch (IOException e) {
			throw new RuntimeException("unable to read transaction", e);
		}
	}
	
	/**
	 * get the line of the transaction.
	 * @param line
	 * @return if parts[0] == "emp": add the employee transaction.
	 * 			  parts[0] == "change": change the transaction.
	 * 			  parts[0] == "del" : delete the transaction.
	 * 	else make the transaction null.
	 */			
	private Transaction parseLine(String line) {
		
		String[] parts = line.split(" ");
		
		if( parts[0].equals("emp") ) {
			return makeAddEmployeeTrans(parts);
		} else if( parts[0].equals("change") ) { 
			return makeChangeTrans(parts);
		} else if( parts[0].equals("del") ) {
			return factory.makeDeleteEmployeeTransaction(integer(parts[1]));
		}
		return factory.makeNullTransaction();
	}
	
	/**
	 * Make the change transactions.
	 * @param parts
	 * @return if parts[2] == "c": make change to the commissioned transaction.
	 * 			  parts[2] == "h": make change to the hourly transaction.
	 * 			  parts[2] == "m": make change to the member transaction.
	 * 			  parts[2] == "n": make change to the name transaction.
	 * 			  parts[2] == "s": make change to the salaried transaction.
	 * 			  parts[2] == "u": make change to the unaffiliated transaction.
	 * 	else make the transaction null.
	 */
	private Transaction makeChangeTrans(String[] parts) {
		if( parts[2].equals("c") ) {
			return factory.makeChangeCommissionedTransaction( integer(parts[1])
					, decimal(parts[3])
					, decimal(parts[4]));
		} else if( parts[2].equals("h") ) {
			return factory.makeChangeHourlyTransaction( integer(parts[1])
					, decimal(parts[3]));
		} else if( parts[2].equals("m") ) {
			return factory.makeChangeMemberTransaction( integer(parts[1])
					, integer(parts[3])
					, decimal(parts[4]));
		} else if( parts[2].equals("n") ) {
			return factory.makeChangeNameTransaction( integer(parts[1])
					, string(parts[3]));
		} else if( parts[2].equals("s") ) {
			return factory.makeChangeSalariedTransaction( integer(parts[1])
					, decimal(parts[3]));
		} else if( parts[2].equals("u") ) {
			return factory.makeChangeUnaffiliatedTransaction( integer(parts[1] ));
		}
		return factory.makeNullTransaction();
	}
	
	/**
	 * Make the employee transaction.
	 * @param parts
	 * @return if parts[4] == "h": add hourly transaction in part 1, 2, 3 and decimals in part 5 of the transaction that convert into array of strings.
	 * 			  parts[4] == "c": add commissioned transaction in part 1, 2, 3 and decimals in part 5  of the transaction that convert into array of strings.
	 * 			  parts[4] == "s": add salaried transaction in part 1, 2, 3 and decimals in part 5  of the transaction that convert into array of strings.
	 */
	private Transaction makeAddEmployeeTrans(String[] parts) {
		if (parts[4].equals("h")) {
			return factory.makeAddHourlyTransaction(integer(parts[1]), string(parts[2]), string(parts[3]), decimal(parts[5]));
		} else if( parts[4].equals("c") ) {
			return factory.makeAddCommissionedTransaction(integer(parts[1]), string(parts[2]), string(parts[3]), decimal(parts[5]), decimal(parts[6]));
		} else if( parts[4].equals("s") ) {
			return factory.makeAddSalariedTransaction(integer(parts[1])
					, string(parts[2])
					, string(parts[3])
					, decimal(parts[5]));
		}
		return factory.makeNullTransaction();
	}
	
	/**
	 * cut the front and back of the string
	 * @param value
	 * @return return the string values.
	 */
	private String string(String value) {
		return value.substring(1, value.length() - 1);
	}
	
	/**
	 * return Integer value
	 * @param value
	 * @return return the integer values.
	 */
	private Integer integer(String value) {
		return Integer.valueOf(value);
	}
	
	/**
	 * return BigDecimal value
	 * @param value
	 * @return return the decimal values.
	 */
	private BigDecimal decimal(String value) {
		return new BigDecimal(value);
	}
	
}
