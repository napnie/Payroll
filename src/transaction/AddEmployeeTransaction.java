package transaction;
import model.Employee;


import db.PayrollDatabase;
import transaction.PaymentClassification;
import transaction.PaymentSchedule;
import db.PayrollDatabase.GlobalInstance;


public abstract class AddEmployeeTransaction implements Transaction {

	private int empId;
	private String itsAddress;
	private String itsName;
	
	public AddEmployeeTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	public  AddEmployeeTransaction(int empId, String name, String adress) {
		this.empId = empId;
		this.itsName = name;
		this.itsAddress = adress;	
	}
	
	public void execute() {
		PaymentClassification classification = getClassification();
		PaymentSchedule schedule = getSchedule();
		PaymentMethod method = new HoldMethod();
		Affiliation af = new NoAffiliation();
		Employee e = new Employee(empId, itsName, itsAddress);
		e.setClassification(classification);
		e.setSchedule(schedule);
		e.setMethod(method);
		e.setAffiliation(af);
		GlobalInstance.GpayrollDatabase.addEmployee(empId, e);		
	}

	protected abstract PaymentClassification getClassification();
	protected abstract PaymentSchedule getSchedule();

}
