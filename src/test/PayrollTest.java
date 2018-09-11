package test;

import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;

import db.PayrollDatabase;
import model.Employee;
import transaction.AddCommissionedEmployee;
import transaction.AddHourlyEmployee;
import transaction.AddSalariedEmployee;
import transaction.DeleteEmployeeTransaction;
import transaction.PaymentClassification;
import transaction.HoldMethod;
import transaction.MonthlySchedule;
import transaction.PaymentMethod;
import transaction.SalariedClassification;
import transaction.PaymentSchedule;
import transaction.TimeCardTransaction;
import transaction.HourlyClassification;

public class PayrollTest {
	
	@Test
	public void testAddSalariedEmployee() {
		int empId = 1;
		AddSalariedEmployee t;
		
		t = new AddSalariedEmployee(empId, "Bob", 1000.00);
		t.execute();
		
		Employee e = PayrollDatabase.getEmployee(empId);
		assertEquals("Bob", e.getName(), "");
		
		PaymentClassification c = e.getClassification();
		assertTrue(c instanceof SalariedClassification);
		
		assertEquals(1000.00, e.getSalary(), .001);
		PaymentSchedule ps = e.getSchedule();
		assertTrue(ps instanceof MonthlySchedule);
		
		PaymentMethod pm = e.getMethod();
		assertTrue(pm instanceof HoldMethod);
	}
	
	@Test
	public void testDeleteEmployee() {
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
		t.execute();
		{
			Employee e = PayrollDatabase.getEmployee(empId);
			assertNotNull(e);
		}
		DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
		dt.execute();
		{
			Employee e = PayrollDatabase.getEmployee(empId);
			assertNull(e);
		}
	}
	
	@Test
	public void testTimeCardTransaction() {
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.execute();
		TimeCardTransaction tct = new TimeCardTransacton(20011031, 8.0, empId);
		tct.excute();
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNotNull(e);
		
		PaymentClassification pc = e.getClassification();
		equals(pc instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification) pc;
		
		TimeCard tc = hc.getTimeCard(20011031);
		assertNotNull(tc);
		assertEquals(8.0, tc.getHours());
	}
	
	@Test
	public void testAddServiceCharge() {
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.execute();
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNotNull(e);
		
		UnionAffiliation af = new UnionAffiliation(12.5);
		e.setAffiliation(af);
		
		int memberId = 86;
		PayrollDatabase.addUnionMember(memberId, e);
		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, 20011101, 12.95);
		sct.excute();
		ServiceCharge sc = af.getServiceCharge(20011101);
		assertNotNull(sc);
		assertEquals(12.95, sc.getAmount(), .001);
	}

}
