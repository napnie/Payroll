package app;
import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import db.InMemoryPayrollDatabase;
import transaction.TextParserTransactionSource;
import transaction.TransactionApplication;
import transaction.TransactionFactory;
import transaction.impl.TransactionFactoryImpl;

public class PayrollApplication {

	public static void main(String[] args) {
		GpayrollDatabase = new InMemoryPayrollDatabase();
		TransactionFactory transFactory = new TransactionFactoryImpl();
		TextParserTransactionSource source = new TextParserTransactionSource(transFactory, null);
		TransactionApplication app = new TransactionApplication(source);
		app.run();
	}
	
}
