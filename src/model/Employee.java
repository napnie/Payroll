package model;

import transaction.PaymentSchedule;
import transaction.PaymentClassification;
import transaction.PaymentMethod;

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
}
