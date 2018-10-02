package transaction.impl;

import java.math.BigDecimal;
import java.util.Date;

import transaction.Transaction;
import transaction.TransactionFactory;

public class TransactionFactoryImpl implements TransactionFactory {
	/**
	 * Add commissioned transaction.
	 * @return add commissioned employee
	 */
	@Override
	public Transaction makeAddCommissionedTransaction(int employeeId, String name, String address, BigDecimal salary, BigDecimal commissionRate) {
		return new AddCommissionedEmployee(employeeId, name, address, salary, commissionRate);
	}
	
	/**
	 * Add hourly transaction.
	 * @return add hourly employee
	 */
	@Override
	public Transaction makeAddHourlyTransaction(int employeeId, String name, String address, BigDecimal hourlyRate) {
		return new AddHourlyEmployee(employeeId, name, address, hourlyRate);
	}
	
	/**
	 * Add salaried transaction.
	 * @return add salaried emplyoee
	 */
	@Override
	public Transaction makeAddSalariedTransaction(int employeeId, String name, String address, BigDecimal salary) {
		return new AddSalariedEmployee(employeeId, name, address, salary);
	}
	
	/**
	 * Change commissioned Transaction.
	 * @return change commissioned transaction
	 */
	@Override
	public Transaction makeChangeCommissionedTransaction(int employeeId, BigDecimal salary, BigDecimal commissionRate) {
		return new ChangeCommissionedTransaction(employeeId, salary, commissionRate);
	}

	/**
	 * Change hourly transaction.
	 * @return change hourly transaction.
	 */
	@Override
	public Transaction makeChangeHourlyTransaction(int employeeId, BigDecimal hourlyRate) {
		return new ChangeHourlyTransaction(employeeId, hourlyRate);
	}
	
	/**
	 * Change member transaction.
	 * @return change member transaction.
	 */
	@Override
	public Transaction makeChangeMemberTransaction(int employeeId, int memberId, BigDecimal weeklyDues) {
		return new ChangeMemberTransaction(employeeId, memberId, weeklyDues);
	}
	
	/**
	 * Change name transaction.
	 * @return  change name transaction.
	 */
	@Override
	public Transaction makeChangeNameTransaction(int employeeId, String name) {
		return new ChangeNameTransaction(employeeId, name);
	}
	
	/**
	 * Change salaried transaction
	 * @return  change salaried transaction.
	 */
	@Override
	public Transaction makeChangeSalariedTransaction(int employeeId, BigDecimal salary) {
		return new ChangeSalariedTransaction(employeeId, salary);
	}
	
	/**
	 * Change un-affiliated transaction
	 * @return change salaried transaction.
	 */
	@Override
	public Transaction makeChangeUnaffiliatedTransaction(int employeeId) {
		return new ChangeUnaffiliatedTransaction(employeeId);
	}
	
	/**
	 * Delete employee transaction.
	 * @return delete employee transaction
	 */
	@Override
	public Transaction makeDeleteEmployeeTransaction(int employeeId) {
		return new DeleteEmployeeTransaction(employeeId);
	}
	
	/**
	 * Make pay day transaction
	 * @return pay day transaction
	 */
	@Override
	public Transaction makePaydayTransaction(Date payDate) {
		return new PaydayTransaction(payDate);
	}
	
	/**
	 * Make sale receipt transaction
	 * @return sale receipt transaction
	 */
	@Override
	public Transaction makeSalesReceiptTransaction(Date date, BigDecimal amount, int employeeId) {
		return new SalesReceiptTransaction(date, amount, employeeId);
	}	
	
	/**
	 * Make serverice charge transaction.
	 * @reutnr service charge transaction.
	 */
	@Override
	public Transaction makeServiceChargeTransaction(int memberId, Date date, BigDecimal charge) {
		return new ServiceChargeTransaction(memberId, date, charge);
	}
	
	/**
	 * Make time card transaction.
	 * @return timecard transaction.
	 */
	@Override
	public Transaction makeTimeCardTransaction(Date date, BigDecimal hours, int employeeId) {
		return new TimeCardTransaction(date, hours, employeeId);
	}
	
	/**
	 * Make null transaction.
	 * @return null transaction.
	 */
	@Override
	public Transaction makeNullTransaction() {
		return new NullTransaction();
	}
}
