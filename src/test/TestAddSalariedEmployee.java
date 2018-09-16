package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import db.Database;
import db.PayrollDatabase.GlobalInstance;
import model.Employee;
import transaction.AddSalariedEmployee;
import transaction.HoldMethod;
import transaction.MonthlySchedule;
import transaction.PaymentClassification;
import transaction.PaymentMethod;
import transaction.PaymentSchedule;
import transaction.SalariedClassification;

public class TestAddSalariedEmployee {

	
	int empId = 1;
	AddSalariedEmployee t;
	final BigDecimal salary = BigDecimal.valueOf(50000.00);


	@Before
	public void setup() {
		GlobalInstance.GpayrollDatabase = new Database();
		t = new AddSalariedEmployee(empId, "Bob", "Home", salary );
		t.execute();
	}
	
	@Test
	public void testCase1() {
		t = new AddSalariedEmployee(empId, "Bob", "Home", salary);
		t.execute();
				
		Employee e = GlobalInstance.GpayrollDatabase.getEmployee(empId);
		assertEquals("Bob", e.getName(), "");
		
		PaymentClassification c = e.getClassification();
		assertTrue(c instanceof SalariedClassification);
		
		assertEquals(1000.00, e.getSalary(), .001);
		PaymentSchedule ps = e.getSchedule();
		assertTrue(ps instanceof MonthlySchedule);
		
		PaymentMethod pm = e.getMethod();
		assertTrue(pm instanceof HoldMethod);
	}

}
