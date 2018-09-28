package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import domain.Affiliation;
import domain.Employee;
import impl.NoAffiliation;
import impl.UnionAffiliation;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

	public ChangeUnaffiliatedTransaction(int employeeId) {
		super(employeeId);
	}

	@Override
	protected Affiliation getAffiliation() {
		return new NoAffiliation();
	}
	
	@Override
	protected void recordMembership(Employee employee) {
		Affiliation af = employee.getAffiliation();
		if (af instanceof UnionAffiliation) {
			UnionAffiliation uf = (UnionAffiliation) af;
			GpayrollDatabase.deleteUnionMember(uf.getMemberId());			
		}
	}
	
}
