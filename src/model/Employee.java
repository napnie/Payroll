package model;

import transaction.*;
import transaction.PaymentClassification;



public class Employee {

	private PaymentSchedule schedule;
	private PaymentClassification classification;
	private PaymentMethod method;
	private Affiliation affiliation;
	private final int empid;
	private String name;
	private String address;
	
	
	public Employee(int empid, String name, String address) {
		this.empid = empid;
		this.name = name;
		this.address = address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public int getId() {
		return this.empid;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void setSchedule(PaymentSchedule schedule) {
		this.schedule = schedule;
	}

	public PaymentSchedule getSchedule() {
		return this.schedule;
	}
	
	public void setClassification(PaymentClassification classification) {
		this.classification = classification;
	}

	public PaymentClassification getClassification() {
		return this.classification;
	}
	
	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}
	
	public Affiliation getAffiliation() {
		return this.affiliation;
	}
	
	public void setMethod(PaymentMethod method) {
		this.method = method;
	}

	public PaymentMethod getMethod() {
		return this.method;
	}


	public double getSalary() {
		return 0 ;
	}
}
