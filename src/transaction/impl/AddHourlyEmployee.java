package transaction.impl;

import java.math.BigDecimal;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import impl.HourlyClassification;
import impl.WeeklySchedule;
/**
 * This class will have a role in add transaction for hourly employee.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {
	//variable
	private final BigDecimal hourlyRate;
	
	//constructor
	public AddHourlyEmployee(int employeeId, String name, String address, BigDecimal hourlyRate) {
		super(employeeId, name, address);
		this.hourlyRate = hourlyRate;
	}
	
	/**
	 * get the payment classification 
	 * @return hourly rate
	 */
	@Override
	protected PaymentClassification getClassification() {
		return new HourlyClassification(hourlyRate);
	}
	
	/**
	 * get the payment schedule.
	 * @return weekly schedule;
	 */
	@Override
	protected PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}

}
