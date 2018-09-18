package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
//import org.junit.Before;
import org.junit.Test;

import db.PayrollDatabase;
import impl.HoldMethod;
import impl.HourlyClassification;
import impl.MonthlySchedule;
import impl.PaymentClassification;
import impl.PaymentMethod;
import impl.PaymentSchedule;
import impl.SalariedClassification;
import impl.UnionAffiliation;
import impl.WeeklySchedule;
import model.Employee;
import transaction.AddCommissionedEmployee;
import transaction.AddHourlyEmployee;
import transaction.AddSalariedEmployee;
import transaction.ChangeHourlyTransaction;
import transaction.ChangeNameTransaction;
import transaction.DeleteEmployeeTransaction;
import transaction.ServiceCharge;
import transaction.ServiceChargeTransaction;
import transaction.TimeCard;
import transaction.TimeCardTransaction;

public class PayrollTest {
	
	Employee e;
	
	@After
	public void after() {
		e = null;
	}
	
	@Test
	public void testAddSalariedEmployee() {
		int empId = 1;
		AddSalariedEmployee t;
		
		t = new AddSalariedEmployee(empId, "Bob", 1000.00);
		t.execute();
		
		getEmp(empId);
		assertEquals("Bob", e.getName(), "");
		
		PaymentClassification c = e.getClassification();
		assertTrue(c instanceof SalariedClassification);
		
		assertEquals(1000.00, e.getSalary(), .001);
		PaymentSchedule ps = e.getSchedule();
		assertTrue(ps instanceof MonthlySchedule);
		
		PaymentMethod pm = e.getMethod();
		assertTrue(pm instanceof HoldMethod);
	}

	private void getEmp(int empId) {
		e = PayrollDatabase.getEmployee(empId);
	}
	
	@Test
	public void testDeleteEmployee() {
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
		t.execute();
		{
			getEmp(empId);
			assertNotNull(e);
		}
		DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
		dt.execute();
		{
			getEmp(empId);
			assertNull(e);
		}
	}
	
	@Test
	public void testTimeCardTransaction() {
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.execute();
		TimeCardTransaction tct = new TimeCardTransaction(20011031, 8.0, empId);
		tct.execute();
		getEmp(empId);
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
		getEmp(empId);
		assertNotNull(e);
		
		UnionAffiliation af = new UnionAffiliation(12.5);
		e.setAffiliation(af);
		
		int memberId = 86;
		PayrollDatabase.addUnionMember(memberId, e);
		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, 20011101, 12.95);
		sct.execute();
		ServiceCharge sc = af.getServiceCharge(20011101);
		assertNotNull(sc);
		assertEquals(12.95, sc.getAmount(), .001);
	}
	
	@Test
	public void testChangeNameTransaction() {
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.execute();
		
		ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "Bob");
		cnt.execute();
		
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNotNull(e);
		assertEquals("Bob", e.getName());
	}
	
	@Test
	public void testChangeHourlyTransaction() {
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
		t.execute();
		
		ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId, 27.52);
		cht.execute();
		getEmp(empId);
		assertNotNull(e);
		PaymentClassification pc = e.getClassification();
		assertNotNull(pc);
		equals(pc instanceof HourlyClassification);
		
		HourlyClassification hc = (HourlyClassification) pc;
		assertEquals(27.52, hc.getRate(), .001);
		
		PaymentSchedule ps = e.getSchedule();
		equals(ps instanceof WeeklySchedule);
	}
	
	@Test
	public void testChangeMemberTransaction() {
		int empId = 2;
		int memberId = 7734;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.execute();
		
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 99.42);
		cmt.execute();
		getEmp(empId);
		assertNotNull(e);
		
		Affiliation af = e.getAffiliation();
		assertNotNull(af);
		
		equals(af instanceof UnionAffiliation);
		UnionAffiliation uf = (UnionAffiliation) af;
		assertEquals(99.42, uf.getDues(), .001);
		
		Employee member = PayrollDatabase.getUnionMember(memberId);
		assertNotNull(member);
		assertEquals(e, member);
	}
	
	@Test
	public void testPaySingleSalariedEmployee() {
		int empId = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
		t.execute();
		
		@SuppressWarnings("deprecation")
		Date payDate = new Date() ;
		
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
		
		Paycheck pc = pt.getPaycheck(empId);
		assertNotNull(pc);
		assertEquals(pc.getPayDate(), payDate);
		assertEquals(1000.00, pc.getGrossPay(), .001);
		assertEquals("Hold", pc.getField("Disposition"));
		assertEquals(0.0, pc.getDeductions(), .001);
		assertEquals(1000.00, pc.getNetPay(), .001);
	}
	
	@Test
	public void testPaySingleSalariedEmployeeOnWrongDate() {
		int empId = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
		t.execute();
		
		Date payDate = new Date(2001, 11, 29);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
		
		Paycheck pc = pt.getPaycheck(empId);
		assertNull(pc);
	}

}
