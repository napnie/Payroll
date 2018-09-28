package transaction.impl;

import java.math.BigDecimal;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import impl.MonthlySchedule;
import impl.SalariedClassification;

public class AddSalariedEmployee extends AddEmployeeTransaction {

	private final BigDecimal salary;

	public AddSalariedEmployee(int employeeId, String name, String address, BigDecimal salary) {
		super(employeeId, name, address);
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
