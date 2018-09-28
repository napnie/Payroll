package payroll.transaction.impl;

import java.math.BigDecimal;

import payroll.domain.PaymentClassification;
import payroll.domain.PaymentSchedule;
import payroll.impl.BiweeklySchedule;
import payroll.impl.CommissionedClassification;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {

	private final BigDecimal salary;
	private final BigDecimal commissionRate;

	public ChangeCommissionedTransaction(int employeeId, BigDecimal salary, BigDecimal commissionRate) {
		super(employeeId);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	@Override
	protected PaymentClassification getClassification() {
		return new CommissionedClassification(salary, commissionRate);
	}
	
	@Override
	protected PaymentSchedule getSchedule() {
		return new BiweeklySchedule();
	}
	
}
