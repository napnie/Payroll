package payroll.transaction.impl;

import java.math.BigDecimal;

import payroll.domain.PaymentClassification;
import payroll.domain.PaymentSchedule;
import payroll.impl.MonthlySchedule;
import payroll.impl.SalariedClassification;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {

	private final BigDecimal salary;

	public ChangeSalariedTransaction(int employeeId, BigDecimal salary) {
		super(employeeId);
		this.salary = salary;
	}

	@Override
	protected PaymentClassification getClassification() {
		return new SalariedClassification(salary);
	}
	
	@Override
	protected PaymentSchedule getSchedule() {
		return new MonthlySchedule();
	}
	
}
