package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import domain.Affiliation;
import domain.Employee;
import domain.PaymentClassification;
import domain.PaymentMethod;
import domain.PaymentSchedule;
import impl.HoldMethod;
import impl.NoAffiliation;
import transaction.Transaction;
/**
 * This abstract class is used for add theemployee transacton.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 *
 */
public abstract class AddEmployeeTransaction implements Transaction {
	//variables
	private final int employeeId;
	private final String name;
	private final String address;
	
	//Constructor.
	public AddEmployeeTransaction(int employeeId, String name, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}
	
	//Execute the program
	@Override
	public final void execute() {
		PaymentClassification pc = getClassification();
		PaymentSchedule ps = getSchedule();
		PaymentMethod pm = new HoldMethod();
		Affiliation af = new NoAffiliation();
		Employee e = new Employee(employeeId, name, address);
		e.setClassification(pc);
		e.setSchedule(ps);
		e.setMethod(pm);
		e.setAffiliation(af);
		GpayrollDatabase.addEmployee(employeeId, e);
	}

	//Get the classification.
	protected abstract PaymentClassification getClassification();
	//Get the payment schedule.
	protected abstract PaymentSchedule getSchedule();
	
}
