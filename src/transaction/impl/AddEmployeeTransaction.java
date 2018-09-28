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

public abstract class AddEmployeeTransaction implements Transaction {

	private final int employeeId;
	private final String name;
	private final String address;

	public AddEmployeeTransaction(int employeeId, String name, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}

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


	protected abstract PaymentClassification getClassification();
	protected abstract PaymentSchedule getSchedule();
	
}
