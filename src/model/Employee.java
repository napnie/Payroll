package model;

import impl.PaymentClassification;
import impl.PaymentMethod;
import impl.PaymentSchedule;

public class Employee {
	
	private int id;
	private String name;
	private String address;

	private PaymentSchedule schedule;
	private PaymentClassification classification;
	private PaymentMethod method;
	
	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
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
		return schedule;
	}

	public PaymentClassification getClassification() {
		return classification;
	}

	public PaymentMethod getMethod() {
		return method;
	}

	public void setMethod(PaymentMethod pm) {
		// TODO Auto-generated method stub
		
	}
}
