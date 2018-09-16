package transaction;

import java.math.BigDecimal;


public class AddHourlyEmployee extends AddEmployeeTransaction {
	
	private final BigDecimal hourlyRate;

	public AddHourlyEmployee(int employeeId, String name, String address, BigDecimal hourlyRate) {
		super(employeeId, name, address);
		this.hourlyRate = hourlyRate;
	}

	@Override
	protected PaymentClassification getClassification() {
		//return new HourlyClassification(hourlyRate);
		return null;
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}
}
