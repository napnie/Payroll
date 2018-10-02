package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import domain.Affiliation;
import domain.Employee;
import impl.NoAffiliation;
import impl.UnionAffiliation;
/**
 * This class change the un-affiliatied transcation.s
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
	//constructor(s).
	public ChangeUnaffiliatedTransaction(int employeeId) {
		super(employeeId);
	}
	
	/**
	 * Get the affiliation.
	 * @return return no affiliation.
	 */
	@Override
	protected Affiliation getAffiliation() {
		return new NoAffiliation();
	}
	
	/**
	 * Record the membership.
	 */
	@Override
	protected void recordMembership(Employee employee) {
		Affiliation af = employee.getAffiliation();
		if (af instanceof UnionAffiliation) {
			UnionAffiliation uf = (UnionAffiliation) af;
			GpayrollDatabase.deleteUnionMember(uf.getMemberId());			
		}
	}
	
}
