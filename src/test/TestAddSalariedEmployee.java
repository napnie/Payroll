package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import db.PayrollDatabase;
import model.Employee;
import transaction.AddSalariedEmployee;
import transaction.PaymentClassification;
import transaction.HoldMethod;
import transaction.MonthlySchedule;
import transaction.PaymentMethod;
import transaction.SalariedClassification;
import transaction.PaymentSchedule;

public class TestAddSalariedEmployee {
	
	int empId = 1;
	AddSalariedEmployee t;

//	@Before
//	public void setup() {
//		t = new AddSalariedEmployee(empId, "Bob", 1000.00);
//		t.execute();
//	}
	
	@Test
	public void testCase1() {
		t = new AddSalariedEmployee(empId, "Bob", 1000.00);
		t.execute();
		
		PayrollDatabase database = new PayrollDatabase();
		
		Employee e = database.getEmployee(empId);
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
