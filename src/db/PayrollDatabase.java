package db;
import java.util.ArrayList;
import java.util.Arrays;

import model.Employee;

public class PayrollDatabase {
	
	private static ArrayList<Employee> employee =  new ArrayList<Employee>();
	
	public PayrollDatabase() { 
	
	}
	
	public static Employee getEmployee(int empId) {
		for (Employee num : employee) {
			if(num.getId() == empId) return num;
		}
		return null;
	}

	
	public void addEmployee(int empId, Employee e){
		employee.set(empId, e);
	}
	
	public void clear() {
		employee = null;
	}
}
