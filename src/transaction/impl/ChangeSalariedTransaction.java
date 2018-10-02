package transaction.impl;

import java.math.BigDecimal;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import impl.MonthlySchedule;
import impl.SalariedClassification;
/**
 * This class have a role in Changing the salaried transaction.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 *
 */
public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
	//variables
	private final BigDecimal salary;
	
	//constructor(s).
	public ChangeSalariedTransaction(int employeeId, BigDecimal salary) {
		super(employeeId);
		this.salary = salary;
	}
	
	/**
	 * Get the payment classification.
	 * @return salaried  classification.
	 */
	@Override
	protected PaymentClassification getClassification() {
		return new SalariedClassification(salary);
	}
	
	/**
	 * Get payment schedule.
	 * @return monthly schedule.
	 */
	@Override
	protected PaymentSchedule getSchedule() {
		return new MonthlySchedule();
	}
	
}
