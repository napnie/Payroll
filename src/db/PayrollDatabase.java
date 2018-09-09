package db;
import model.Employee;

public class PayrollDatabase {
	
	private Employee[] itsEmployees;
	
	public PayrollDatabase() { 
	
	}
	
	public Employee getEmployee(int empId) {
		return itsEmployees[empId];
	}
	
	public void addEmployee(int empId, Employee e) {
		itsEmployees[empId] = e;
	}
	
	public void clear() {
		itsEmployees.clear();
	}		
	
}
