package payroll.transaction.impl;

import static payroll.db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import payroll.domain.Affiliation;
import payroll.domain.Employee;
import payroll.impl.NoAffiliation;
import payroll.impl.UnionAffiliation;

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
