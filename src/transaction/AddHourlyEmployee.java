package transaction;

public class AddHourlyEmployee extends AddEmployeeTransaction {

	private double hourlyRate;
	
	public AddHourlyEmployee(int empId, String name, String adress, double hourlyRate) {
		super(empId, name, adress);
		this.hourlyRate = hourlyRate;
	}
	
	@Override
    protected PaymentClassification getClassification() {
        return new HourlyClassification();
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new HourlySchedule();
    }
	
}
