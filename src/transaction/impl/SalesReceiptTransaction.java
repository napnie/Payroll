package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import java.math.BigDecimal;
import java.util.Date;

import domain.Employee;
import domain.PaymentClassification;
import impl.CommissionedClassification;
import impl.SalesReceipt;
import transaction.Transaction;
/**
 * This class will do the transaction of the sale receipt.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class SalesReceiptTransaction implements Transaction {
	//variables
	private final Date date;
	private final BigDecimal amount;
	private final int employeeId;
	
	//constructors
	public SalesReceiptTransaction(Date date, BigDecimal amount, int employeeId) {
		this.date = date;
		this.amount = amount;
		this.employeeId = employeeId;
	}
	
	/**
	 * Execute the transaction.
	 */
	@Override
	public void execute() {
		Employee e = GpayrollDatabase.getEmployee(employeeId);
		if (e != null) {
			PaymentClassification pc = e.getClassification();
			if (pc instanceof CommissionedClassification) {
				CommissionedClassification cc = (CommissionedClassification) pc;
				cc.addSalesReceipt(new SalesReceipt(date, amount));
			} else {
				throw new RuntimeException("Tried to add sales receipt to non-commissioned employee");
			}
		} else {
			throw(new RuntimeException("No such employee."));
		}
	}

}
