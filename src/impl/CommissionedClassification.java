package impl;

import static java.math.BigDecimal.ROUND_HALF_UP;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import domain.Paycheck;
import domain.PaymentClassification;
/**
 * This class will create the type of the payment that is commissioned Classification.
 * 
 * @author Theeruth Borisuth
 * @author NItith   Chayakuyl
 */
public class CommissionedClassification extends PaymentClassification {
	//check months/year
	private static final BigDecimal MONTHS_PER_YEAR = BigDecimal.valueOf(12);
	//Check paychecks/year
	private static final BigDecimal PAYCHECKS_PER_YEAR = BigDecimal.valueOf(26);
	
	//Sale receipt as a Map.
	private final Map<Date, SalesReceipt> salesReceipts = new HashMap<Date, SalesReceipt>();
	//Salary of the employee
	private final BigDecimal salary;
	// Rate of the commission of the employee
	private final BigDecimal commissionRate;
	
	//Constructor
	public CommissionedClassification(BigDecimal salary, BigDecimal commissionRate) {
		this.salary = salary.setScale(2);
		this.commissionRate = commissionRate;
	}
	
	/**
	 * get the salary
	 * @return salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}
	
	/**
	 * Get the commission rate
	 * @return commission rate
	 */
	public BigDecimal getCommissionRate() {
		return commissionRate;
	}
	
	/**
	 * return sale receipt's date.
	 * @param date
	 * @return date of the sale receipt
	 */
	public SalesReceipt getSalesReceipt(Date date) {
		return salesReceipts.get(date);
	}
	
	/**
	 * Add sale receipt.
	 * @param salesReceipt
	 */
	public void addSalesReceipt(SalesReceipt salesReceipt) {
		salesReceipts.put(salesReceipt.getDate(), salesReceipt);
	}
	
	/**
	 * Calculate the payment method.
	 */
	@Override
	public BigDecimal calculatePay(Paycheck pc) {
		@SuppressWarnings("deprecation")
		BigDecimal basePay = salary.multiply(MONTHS_PER_YEAR).divide(PAYCHECKS_PER_YEAR, ROUND_HALF_UP);
		BigDecimal sales = calculateSales(pc);
		@SuppressWarnings("deprecation")
		BigDecimal commissionPay = commissionRate.movePointLeft(2).multiply(sales).setScale(2, ROUND_HALF_UP);
		return basePay.add(commissionPay);
	}
	
	/**
	 * Calculate the sale
	 * @param pc: Paycheck
	 * @return sale prices.
	 */
	private BigDecimal calculateSales(Paycheck pc) {
		BigDecimal sales = BigDecimal.ZERO;
		for (SalesReceipt receipt : salesReceipts.values()) {
			if (isInPayPeriod(receipt.getDate(), pc)) {
				sales = sales.add(receipt.getAmount());
			}
		}
		return sales;
	}

}
