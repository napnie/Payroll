package transaction;
import model.Employee;
import db.PayrollDatabase;
import transaction.Classification;
import transaction.Schedule;


public class AddEmployeeTransaction implements Transaction {

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
//		Classification classification = GetClassification();
//		Schedule schedule = GetSchedule();
		//payment method
	}

}
