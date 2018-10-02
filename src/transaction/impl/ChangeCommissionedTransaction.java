package transaction.impl;

import java.math.BigDecimal;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import impl.BiweeklySchedule;
import impl.CommissionedClassification;
/**
 * This class will do the changing commission transaction.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
	//variable
	private final BigDecimal salary;
	private final BigDecimal commissionRate;
	
	//constructors.
	public ChangeCommissionedTransaction(int employeeId, BigDecimal salary, BigDecimal commissionRate) {
		super(employeeId);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	/**
	 * Get the payment classification.
	 * @return commission classification 
	 */
	@Override
	protected PaymentClassification getClassification() {
		return new CommissionedClassification(salary, commissionRate);
	}
	
	/**
	 * Get the payment schedule.
	 * @return Bi-weekly schedule.
	 */
	@Override
	protected PaymentSchedule getSchedule() {
		return new BiweeklySchedule();
	}
	
}
