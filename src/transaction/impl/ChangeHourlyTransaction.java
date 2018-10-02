package transaction.impl;

import java.math.BigDecimal;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import impl.HourlyClassification;
import impl.WeeklySchedule;
/**
 * This class change the hourly classification.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
	//variable
	private final BigDecimal hourlyRate;
	
	//constructor(s)
	public ChangeHourlyTransaction(int employeeId, BigDecimal hourlyRate) {
		super(employeeId);
		this.hourlyRate = hourlyRate;
	}
	
	/**
	 * Get the payment classification.
	 * @return hourly classification.
	 */
	@Override
	protected PaymentClassification getClassification() {
		return new HourlyClassification(hourlyRate);
	}
	
	/**
	 * Get the payment Schedule.
	 * @return weekly schedule.
	 */
	@Override
	protected PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}
	
}
