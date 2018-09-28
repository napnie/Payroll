package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import java.math.BigDecimal;

import domain.Affiliation;
import domain.Employee;
import impl.UnionAffiliation;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

	private final int memberId;
	private final BigDecimal weeklyDues;

	public ChangeMemberTransaction(int employeeId, int memberId, BigDecimal weeklyDues) {
		super(employeeId);
		this.memberId = memberId;
		this.weeklyDues = weeklyDues;
	}

	@Override
	protected Affiliation getAffiliation() {
		return new UnionAffiliation(memberId, weeklyDues);
	}
	
	@Override
	protected void recordMembership(Employee employee) {
		GpayrollDatabase.addUnionMember(memberId, employee);
	}
	
}
