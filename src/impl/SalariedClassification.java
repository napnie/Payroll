package impl;

import java.math.BigDecimal;

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
