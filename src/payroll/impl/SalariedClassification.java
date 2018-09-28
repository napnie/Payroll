package payroll.impl;

import java.math.BigDecimal;

import payroll.domain.Paycheck;
import payroll.domain.PaymentClassification;

public class SalariedClassification extends PaymentClassification {

	private final BigDecimal salary;

	public SalariedClassification(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	@Override
	public BigDecimal calculatePay(Paycheck pc) {
		return salary;
	}

}
