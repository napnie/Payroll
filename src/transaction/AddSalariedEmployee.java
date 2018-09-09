package transaction;

public class AddSalariedEmployee extends AddEmployeeTransaction {
	
	private double salary;
	
	public AddSalariedEmployee(int empId, String name, String adress, double saraly) {
		super(empId, name, adress);
		this.salary = salary;
	}
	
	@Override
    protected PaymentClassification getClassification() {
        return new SalariedClassification();
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new SalariedSchedule();
    }
	
}
