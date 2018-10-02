package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Employee;
import domain.Paycheck;
import transaction.Transaction;
/**
 * This class will handle the transaction of the pay day.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class PaydayTransaction implements Transaction {
	//variables
	private final Map<Integer, Paycheck> paychecks = new HashMap<Integer, Paycheck>();
	private final Date payDate;
	
	//constructors.
	public PaydayTransaction(Date payDate) {
		this.payDate = payDate;
	}
	
	/**
	 * Executing the transaction.
	 */
	@Override
	public void execute() {
		List<Integer> empIds = GpayrollDatabase.getAllEmployeeIds();
		for (int empId : empIds) {
			Employee e = GpayrollDatabase.getEmployee(empId);
			if (e != null && e.isPayDay(payDate)) {
				Paycheck pc = new Paycheck(e.getPayPeriodStartDate(payDate), payDate);
				paychecks.put(empId, pc);
				e.payDay(pc);
			}
		}
	}
	
	/**'
	 * Get the paycheck
	 * @param employeeId
	 * @return paycheck of that employee.
	 */
	public Paycheck getPaycheck(int employeeId) {
		return paychecks.get(employeeId);
	}

}
