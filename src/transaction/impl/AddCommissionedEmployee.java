package transaction.impl;

import java.math.BigDecimal;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import impl.BiweeklySchedule;
import impl.CommissionedClassification;
/**
 * This class will add the commissioned employee.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {
	
	//variables
	private final BigDecimal salary;
	private final BigDecimal commissionRate;
	
	//constructor.
	public AddCommissionedEmployee(int employeeId, String name, String address,
			BigDecimal salary, BigDecimal commissionRate) {
		super(employeeId, name, address);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
	
	/**
	 * Get the payment classification.
	 */
	@Override
	protected PaymentClassification getClassification() {
		return new CommissionedClassification(salary, commissionRate);
	}
	
	/**
	 * Get payment schedule but return in bi-weekly.
	 */
	@Override
	protected PaymentSchedule getSchedule() {
		return new BiweeklySchedule();
	}

}
