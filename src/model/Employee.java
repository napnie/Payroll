package model;

import impl.PaymentClassification;
import impl.PaymentMethod;
import impl.PaymentSchedule;

public class Employee {

	private PaymentSchedule schedule;
	private PaymentClassification classification;
	private int id;
	
	public void setSchedule(PaymentSchedule schedule) {
		this.schedule = schedule;
	}

	public void setClassification(PaymentClassification classification) {
		this.classification = classification;
	}
	
	public int getId() {
		return this.id;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	public PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	public PaymentClassification getClassification() {
		// TODO Auto-generated method stub
		return null;
	}

	public PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
