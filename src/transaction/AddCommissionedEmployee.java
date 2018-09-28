package transaction;

import java.math.BigDecimal;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
	
	private BigDecimal salary;
	private BigDecimal commissionRate;
	
	public AddCommissionedEmployee(int empid, String name, String address, BigDecimal salary, BigDecimal commission) {
		super(empid, name, address);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
	
	@Override
	protected PaymentClassification getClassification() {
		return new CommissionedClassification(salary, commissionRate);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return new BiweeklySchedule();
	}
}
