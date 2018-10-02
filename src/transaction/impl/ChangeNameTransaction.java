package transaction.impl;

import domain.Employee;
/**
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 *
 */
public class ChangeNameTransaction extends ChangeEmployeeTransaction {
	
	//variables
	private final String name;
	
	//constructor(s).
	public ChangeNameTransaction(int employeeId, String name) {
		super(employeeId);
		this.name = name;
	}

	/**
	 * Change employee name.
	 */
	@Override
	protected void change(Employee employee) {
		employee.setName(name);
	}
	
}
