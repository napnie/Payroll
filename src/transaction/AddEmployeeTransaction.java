package transaction;
import model.Employee;
import db.PayrollDatabase;
import transaction.PaymentClassification;
import transaction.PaymentSchedule;


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
		PaymentClassification classification = GetClassification();
		PaymentSchedule schedule = GetSchedule();
		//payment method
	}

	private PaymentClassification GetClassification() {
		// TODO Auto-generated method stub
		return null;
	}

	private PaymentSchedule GetSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

}
