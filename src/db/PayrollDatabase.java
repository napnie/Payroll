package db;
import java.util.List;
import model.Employee;

public interface PayrollDatabase {
		
	public static class GlobalInstance {
		public static PayrollDatabase GpayrollDatabase;
	}
	
	public Employee getEmployee(int empid);
	public void addEmployee(int empid, Employee employee);
	public void deleteEmployee(int empid);
	List<Integer> getAllEmployeeIds();
	void clear();

}
