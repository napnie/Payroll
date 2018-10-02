package db;

import java.util.List;
import domain.Employee;
/**
 * 
 * This class was created for letting the Store-able database implementing.
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 */

public interface PayrollDatabase {
	
	//use the variable globally.
	class GlobalInstance {
		public static PayrollDatabase GpayrollDatabase;
	}
	
	/**
	 * clear employee
	 */
	void clear();
	/**
	 * add employee id
	 * @param employeeId
	 * @param employee
	 */
	void addEmployee(int employeeId, Employee employee);
	
	/**
	 * delete the employee id.
	 * @param employee id
	 */
	void deleteEmployee(int employeeId);
	
	/**
	 * Get the employee id.
	 * @param employeeId
	 * @return employee id
	 */
	Employee getEmployee(int employeeId);
	
	/**
	 * return all employees id.
	 * @return list
	 */
	List<Integer> getAllEmployeeIds();
	
	/**
	 * Add union member id.
	 * @param memberId
	 * @param employee
	 */
	void addUnionMember(int memberId, Employee employee);
	
	/**
	 * delete union member id.
	 * @param memberId
	 */
	void deleteUnionMember(int memberId);
	
	/**
	 * get union member id.
	 * @param memberId
	 * @return member id
	 */
	Employee getUnionMember(int memberId);

}
