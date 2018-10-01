package transaction;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class TextParserTransactionSource implements TransactionSource {

	private final String transactionsFile = "./res/transactions.txt";
	private final TransactionFactory factory;
	private BufferedReader reader;

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

	private String string(String value) {
		return value.substring(1, value.length() - 1);
	}
	
	private Integer integer(String value) {
		return Integer.valueOf(value);
	}
	
	private BigDecimal decimal(String value) {
		return new BigDecimal(value);
	}
	
}
