package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import java.math.BigDecimal;

import domain.Affiliation;
import domain.Employee;
import impl.UnionAffiliation;
/**
 * This class have a job in Changing member transaction.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
	//variables
	private final int memberId;
	private final BigDecimal weeklyDues;
	
	//constructor(s).
	public ChangeMemberTransaction(int employeeId, int memberId, BigDecimal weeklyDues) {
		super(employeeId);
		this.memberId = memberId;
		this.weeklyDues = weeklyDues;
	}
	
	/**
	 * Get the affiliation.
	 * @return union affiliation.
	 */
	@Override
	protected Affiliation getAffiliation() {
		return new UnionAffiliation(memberId, weeklyDues);
	}
	
	/**
	 * Record the membership into database.
	 */
	@Override
	protected void recordMembership(Employee employee) {
		GpayrollDatabase.addUnionMember(memberId, employee);
	}
	
}
