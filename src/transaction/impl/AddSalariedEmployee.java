package transaction.impl;

import java.math.BigDecimal;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import impl.MonthlySchedule;
import impl.SalariedClassification;
/**
 * This class will add the transaction for the salaried employee
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {
	//variable
	private final BigDecimal salary;
	
	//constructor.
	public AddSalariedEmployee(int employeeId, String name, String address, BigDecimal salary) {
		super(employeeId, name, address);
		this.salary = salary;
	}
	
	/**
	 * get the payment classification 
	 * @return salaried classification
	 */
	@Override
	protected PaymentClassification getClassification() {
		return new SalariedClassification(salary);
	}
	
	/**
	 * get the payment schedule.
	 * @return monthly schedule.
	 */
	@Override
	protected PaymentSchedule getSchedule() {
		return new MonthlySchedule();
	}

}
