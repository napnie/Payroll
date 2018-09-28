package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import domain.Employee;
import transaction.Transaction;

public abstract class ChangeEmployeeTransaction implements Transaction {

	private final int employeeId;

	public ChangeEmployeeTransaction(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@Override
	public void execute() {
		Employee e = GpayrollDatabase.getEmployee(employeeId);
		if (e != null) {
			change(e);
		}
	}
	
	protected abstract void change(Employee employee);
	
}
