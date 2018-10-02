package impl;

import java.math.BigDecimal;

import domain.Paycheck;
import domain.PaymentClassification;
/**
 * This card will handle the Salary payment.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class SalariedClassification extends PaymentClassification {
	//Salary in big decimal
	private final BigDecimal salary;

	//constructor.
	public SalariedClassification(BigDecimal salary) {
		this.salary = salary;
	}
	
	/**
	 * Get the salary
	 * @return salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}
	
	/**
	 * Calculate the pay
	 */
	@Override
	public BigDecimal calculatePay(Paycheck pc) {
		return salary;
	}

}
