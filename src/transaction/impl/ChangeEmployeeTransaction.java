package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import domain.Employee;
import transaction.Transaction;
/**
 * 
 * This abtract class will have a roles in changing employee transaction.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public abstract class ChangeEmployeeTransaction implements Transaction {
	
	//variables
	private final int employeeId;
	
	//constructors.
	public ChangeEmployeeTransaction(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 *Get the employee from database.
	 */
	@Override
	public void execute() {
		Employee e = GpayrollDatabase.getEmployee(employeeId);
		if (e != null) {
			change(e);
		}
	}
	
	//Change employee.
	protected abstract void change(Employee employee);
	
}
