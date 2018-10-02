package transaction.impl;

import domain.Affiliation;
import domain.Employee;
/**
 * This abstract class wll change the affiliation transaction.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
	
	//constructor(s).
	public ChangeAffiliationTransaction(int employeeId) {
		super(employeeId);
	}
	
	/**
	 * change affiliation
	 */
	@Override
	protected void change(Employee employee) {
		recordMembership(employee);
		employee.setAffiliation(getAffiliation());
	}
	
	//Record the membership 
	protected abstract void recordMembership(Employee employee);
	
	//Get affiliation.
	protected abstract Affiliation getAffiliation();

}