package payroll.transaction.impl;

import static payroll.db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import transaction.Transaction;

public class DeleteEmployeeTransaction implements Transaction {

	private final int employeeId;

	public DeleteEmployeeTransaction(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public void execute() {
		GpayrollDatabase.deleteEmployee(employeeId);
	}

}
