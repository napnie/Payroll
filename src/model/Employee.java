package model;

import transaction.Schedule;
import transaction.Classification;

public class Employee {

	private Schedule schedule;
	private Classification classification;
	
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}
}
