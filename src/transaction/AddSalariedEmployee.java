package transaction;

import java.math.BigDecimal;


public class AddSalariedEmployee extends AddEmployeeTransaction {
	
	private final BigDecimal salary;
	
	public AddSalariedEmployee(int empId, String name, String address, BigDecimal salary) {
		super(empId, name, address);
		this.salary = salary;
	}
	
	@Override
    protected PaymentClassification getClassification() {
        return new SalariedClassification();
    }

	@Override
	protected PaymentClassification getClassification() {
		return new SalariedClassification(salary);

	}

	@Override
	protected PaymentSchedule getSchedule() {
		return new MonthlySchedule();
	}
}
