package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Employee;

public class Database implements PayrollDatabase {
	
	private final Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

	@Override
	public Employee getEmployee(int empid) {
		return employees.get(empid);

	}

	@Override
	public void addEmployee(int empid, Employee employee) {
		employees.put(empid, employee);
	}

	@Override
	public void deleteEmployee(int empid) {
		employees.remove(empid);
	}

	@Override
	public List<Integer> getAllEmployeeIds() {
		return new ArrayList<Integer>(employees.keySet());
	}

	@Override
	public void clear() {
		employees.clear();
	}

}
