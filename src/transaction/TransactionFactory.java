package transaction;

import java.math.BigDecimal;
import java.util.Date;

public interface TransactionFactory {
	/**
	 * Add the commissioned transaction.
	 * @param employeeId 
	 * @param name
	 * @param address
	 * @param salary
	 * @param commissionRate
	 * @return transaction
	 */
	Transaction makeAddCommissionedTransaction(int employeeId, String name, String address, BigDecimal salary, BigDecimal commissionRate);
	
	/**
	 * Add hourly transaction.
	 * @param employeeId
	 * @param name
	 * @param address
	 * @param hourlyRate
	 * @return transaction
	 */
	Transaction makeAddHourlyTransaction(int employeeId, String name, String address, BigDecimal hourlyRate);
	
	/**
	 * Add salaried transaction
	 * @param employeeId
	 * @param name
	 * @param address
	 * @param salary
	 * @return transaction
	 */
	Transaction makeAddSalariedTransaction(int employeeId, String name, String address, BigDecimal salary);
	
	/**
	 * Change commissioned transaction
	 * @param employeeId
	 * @param salary
	 * @param commissionRate
	 * @return transaction
	 */
	Transaction makeChangeCommissionedTransaction(int employeeId, BigDecimal salary, BigDecimal commissionRate);
	
	/**
	 * Change hourly transaction.
	 * @param employeeId
	 * @param hourlyRate
	 * @return transaction
	 */
	Transaction makeChangeHourlyTransaction(int employeeId, BigDecimal hourlyRate);
	
	/**
	 * Change member transaction.
	 * @param employeeId
	 * @param memberId
	 * @param weeklyDues
	 * @return transaction
	 */
	Transaction makeChangeMemberTransaction(int employeeId, int memberId, BigDecimal weeklyDues);
	
	/**
	 * Change name transaction.
	 * @param employeeId
	 * @param name
	 * @return
	 */
	Transaction makeChangeNameTransaction(int employeeId, String name);
	
	/**
	 * Change salaried transaction
	 * @param employeeId
	 * @param salary
	 * @return
	 */
	Transaction makeChangeSalariedTransaction(int employeeId, BigDecimal salary);
	
	/**
	 * Change unaffiliated trnsaction
	 * @param employeeId
	 * @return
	 */
	Transaction makeChangeUnaffiliatedTransaction(int employeeId);
	
	/**
	 * Delete employee transaction.
	 * @param employeeId
	 * @return
	 */
	Transaction makeDeleteEmployeeTransaction(int employeeId);
	
	/**
	 * Make payday transaction.
	 * @param payDate
	 * @return
	 */
	Transaction makePaydayTransaction(Date payDate);
	
	/**
	 * Make sales receipt transaction.
	 * @param date
	 * @param amount
	 * @param employeeId
	 * @return
	 */
	Transaction makeSalesReceiptTransaction(Date date, BigDecimal amount, int employeeId);
	
	/**
	 * Make service charge transaction.
	 * @param memberId
	 * @param date
	 * @param charge
	 * @return
	 */
	Transaction makeServiceChargeTransaction(int memberId, Date date, BigDecimal charge);
	
	/**
	 * Make time card transaction.
	 * @param date
	 * @param hours
	 * @param employeeId
	 * @return
	 */
	Transaction makeTimeCardTransaction(Date date, BigDecimal hours, int employeeId);
	
	/**
	 * Make the transaction null.
	 * @return
	 */
	Transaction makeNullTransaction();
	
}