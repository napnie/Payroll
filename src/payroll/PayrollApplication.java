package payroll;
import static payroll.db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import payroll.db.impl.InMemoryPayrollDatabase;
import payroll.transaction.TransactionFactory;
import payroll.transaction.impl.TransactionFactoryImpl;
import payroll.transaction.source.TextParserTransactionSource;
import transaction.TransactionApplication;

public class PayrollApplication {

	public static void main(String[] args) {
		GpayrollDatabase = new InMemoryPayrollDatabase();
		TransactionFactory transFactory = new TransactionFactoryImpl();
		TextParserTransactionSource source = new TextParserTransactionSource(transFactory, null);
		TransactionApplication app = new TransactionApplication(source);
		app.run();
	}
	
}
