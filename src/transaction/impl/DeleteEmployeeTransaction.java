package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import transaction.Transaction;
/**
 * This class is used for deleting employee transaction.
 * @author Theeruth Borisuth
 *
 */
public class DeleteEmployeeTransaction implements Transaction {
	//variable
	private final int employeeId;
	
	//constructor.
	public DeleteEmployeeTransaction(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * Delete the employee
	 */
	@Override
	public void execute() {
		GpayrollDatabase.deleteEmployee(employeeId);
	}

}
