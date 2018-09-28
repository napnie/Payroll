package transaction.impl;

import domain.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

	private final String name;

	public ChangeNameTransaction(int employeeId, String name) {
		super(employeeId);
		this.name = name;
	}

	@Override
	protected void change(Employee employee) {
		employee.setName(name);
	}
	
}
