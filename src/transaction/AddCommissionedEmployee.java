package transaction;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
	
	private double salary;
	private double commissionRate;
	
	public AddCommissionedEmployee(int empId, String name, String adress, double saraly, double commissionRate) {
		super(empId, name, adress);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
	
	@Override
    protected PaymentClassification getClassification() {
        return new CommissionClassification();
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new CommissionSchedule();
    }
	
}
