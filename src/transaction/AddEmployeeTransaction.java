package transaction;
import model.Employee;
import db.PayrollDatabase;
import impl.PaymentClassification;
import impl.PaymentSchedule;

import db.PayrollDatabase;
import model.Employee;

public abstract class AddEmployeeTransaction implements Transaction {

	protected int empId;
	protected String itsName;
	protected String itsAddress;
	
	public AddEmployeeTransaction(int empId, String name, String adress) {
		this.empId = empId;
		this.itsName = name;
		this.itsAddress = adress;	
	}
	
	public void execute() {
		Employee e = new Employee(empId, itsName, itsAddress);
		
		e.setClassification( getClassification() );
		e.setSchedule( getSchedule() );
		e.setMethod( new HoldMethod());
		PayrollDatabase.addEmployee(e);
	}
	
    protected abstract PaymentClassification getClassification() ;

    protected abstract PaymentSchedule getSchedule() ;

}
