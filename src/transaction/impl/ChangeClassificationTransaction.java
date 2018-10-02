package transaction.impl;

import domain.Employee;
import domain.PaymentClassification;
import domain.PaymentSchedule;
/**
 * This abstract class have a role in changing the classification of the transaction.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
	
	//constructors(s).
	public ChangeClassificationTransaction(int employeeId) {
		super(employeeId);
	}
	
	/**
	 * Change employee classfication.
	 */
	@Override
	protected void change(Employee employee) {
		employee.setClassification(getClassification());
		employee.setSchedule(getSchedule());
	}

	//Get payment classification.
	protected abstract PaymentClassification getClassification();
	
	//Get payment schedule.
	protected abstract PaymentSchedule getSchedule();

}
