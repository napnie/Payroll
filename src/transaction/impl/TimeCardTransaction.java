package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import java.math.BigDecimal;
import java.util.Date;

import domain.Employee;
import domain.PaymentClassification;
import impl.HourlyClassification;
import impl.TimeCard;
import transaction.Transaction;
/**
 * 
 * This class will do the transaction of the time card.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class TimeCardTransaction implements Transaction {
	
	//variables
	private final Date date;
	private final BigDecimal hours;
	private final int employeeId;
	
	//constructors
	public TimeCardTransaction(Date date, BigDecimal hours, int employeeId) {
		this.date = date;
		this.hours = hours;
		this.employeeId = employeeId;
	}
	
	/**
	 * Execute the transaction.
	 */
	@Override
	public void execute() {
		Employee e = GpayrollDatabase.getEmployee(employeeId);
		if (e != null) {
			PaymentClassification pc = e.getClassification();
			if (pc instanceof HourlyClassification) {
				HourlyClassification hc = (HourlyClassification) pc;
				hc.addTimeCard(new TimeCard(date, hours));
			} else {
				throw new RuntimeException("Tried to add timecard to non-hourly employee");
			}
		} else {
			throw(new RuntimeException("No such employee."));
		}
	}

}
