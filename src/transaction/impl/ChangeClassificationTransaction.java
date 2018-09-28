package transaction.impl;

import domain.Employee;
import domain.PaymentClassification;
import domain.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

	public ChangeClassificationTransaction(int employeeId) {
		super(employeeId);
	}
	
	@Override
	protected void change(Employee employee) {
		employee.setClassification(getClassification());
		employee.setSchedule(getSchedule());
	}

	protected abstract PaymentClassification getClassification();
	
	protected abstract PaymentSchedule getSchedule();

}
