package model;

import transaction.PaymentSchedule;
import transaction.PaymentClassification;
import transaction.PaymentMethod;

public class Employee {

	private PaymentSchedule schedule;
	private PaymentClassification classification;
	
	public void setSchedule(PaymentSchedule schedule) {
		this.schedule = schedule;
	}

	public void setClassification(PaymentClassification classification) {
		this.classification = classification;
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
