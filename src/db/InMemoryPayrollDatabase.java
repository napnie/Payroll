package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Employee;
/**
 * This class will store employee data base as a Map.
 * 
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 *
 */
public class InMemoryPayrollDatabase implements PayrollDatabase {

	//employee
	private final Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	//union bank member.
	private final Map<Integer, Employee> unionMembers = new HashMap<Integer, Employee>();
	
	/**
	 * get the employee id.
	 */
	@Override
	public Employee getEmployee(int employeeId) {
		return employees.get(employeeId);
	}
	
	/**
	 *  add employee id
	 */
	@Override
	public void addEmployee(int employeeId, Employee employee) {
		employees.put(employeeId, employee);
	}
	
	/**
	 * Delete employee id
	 */
	@Override
	public void deleteEmployee(int employeeId) {
		employees.remove(employeeId);
	}
	
	/**
	 * get all the employee id.
	 */
	@Override
	public List<Integer> getAllEmployeeIds() {
		return new ArrayList<Integer>(employees.keySet());
	}
	
	/**
	 * union bank member id.
	 */
	@Override
	public Employee getUnionMember(int memberId) {
		return unionMembers.get(memberId);
	}
	
	/**
	 * add union bank member id.
	 */
	@Override
	public void addUnionMember(int memberId, Employee employee) {
		unionMembers.put(memberId, employee);
	}
	
	/**
	 * delete union bank member id.
	 */
	@Override
	public void deleteUnionMember(int memberId) {
		unionMembers.remove(memberId);
	}
	
	/**
	 * Clear employee id and union member id.
	 */
	@Override
	public void clear() {
		employees.clear();
		unionMembers.clear();
	}

}
