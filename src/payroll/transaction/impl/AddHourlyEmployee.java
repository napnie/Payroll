package payroll.transaction.impl;

import java.math.BigDecimal;

import payroll.domain.PaymentClassification;
import payroll.domain.PaymentSchedule;
import payroll.impl.HourlyClassification;
import payroll.impl.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction {

	private final BigDecimal hourlyRate;

	public AddHourlyEmployee(int employeeId, String name, String address, BigDecimal hourlyRate) {
		super(employeeId, name, address);
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
