package payroll.transaction.impl;

import java.math.BigDecimal;

import payroll.domain.PaymentClassification;
import payroll.domain.PaymentSchedule;
import payroll.impl.HourlyClassification;
import payroll.impl.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

	private final BigDecimal hourlyRate;

	public ChangeHourlyTransaction(int employeeId, BigDecimal hourlyRate) {
		super(employeeId);
		this.hourlyRate = hourlyRate;
	}

	@Override
	protected PaymentClassification getClassification() {
		return new HourlyClassification(hourlyRate);
	}
	
	@Override
	protected PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}
	
}
