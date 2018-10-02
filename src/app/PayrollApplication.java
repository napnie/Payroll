package app;
import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import db.InMemoryPayrollDatabase;
import transaction.TextParserTransactionSource;
import transaction.TransactionApplication;
import transaction.TransactionFactory;
import transaction.impl.TransactionFactoryImpl;
/**
 * This class will launch the user interface (not implement yet).
 * 
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 *
 */
public class PayrollApplication {
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		GpayrollDatabase = new InMemoryPayrollDatabase();
		TransactionFactory transFactory = new TransactionFactoryImpl();
		TextParserTransactionSource source = new TextParserTransactionSource(transFactory);
		TransactionApplication app = new TransactionApplication(source);
		app.run();
	}
	
}
