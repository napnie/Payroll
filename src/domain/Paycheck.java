package domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Paycheck {
	
	//all the variable that are about paycheck.
	private final Map<String, String> fields = new HashMap<String, String>();
	private final Date payPeriodStartDate;
	private final Date payPeriodEndDate;
	private BigDecimal grossPay;
	private BigDecimal deductions;
	private BigDecimal netPay;

	//constructor
	public Paycheck(Date payPeriodStartDate, Date payPeriodEndDate) {
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
	}

	/**
	 * get Pay period start date.
	 * @return start date.
	 */
	public Date getPayPeriodStartDate() {
		return payPeriodStartDate;
	}
	
	/**
	 * get Pay period end date.
	 * @return end date.
	 */
	public Date getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	
	/**
	 * get the gross pay
	 * @return
	 */
	public BigDecimal getGrossPay() {
		return grossPay;
	}
	
	/**
	 * set the gross pay
	 * @param grossPay
	 */
	public void setGrossPay(BigDecimal grossPay) {
		this.grossPay = grossPay;
	}
	
	/**
	 * Get the deductions.
	 * @return deductions
	 */
	public BigDecimal getDeductions() {
		return deductions;
	}
	
	/**
	 * Set the deductions.
	 * @param deductions
	 */
	public void setDeductions(BigDecimal deductions) {
		this.deductions = deductions;
	}
	
	/**
	 * Return the net payment.
	 * @return netPay.
	 */
	public BigDecimal getNetPay() {
		return netPay;
	}
	
	/**
	 * Set the net payment.
	 * @param netPay
	 */
	public void setNetPay(BigDecimal netPay) {
		this.netPay = netPay;
	}
	
	/**
	 * 
	 * @param name
	 * @return name in the fields.
	 */
	public String getField(String name) {
		return fields.get(name);
	}
	
	/**
	 * 
	 * @param name : name of the employee.
	 * @param value : value of them.
	 */
	public void setField(String name, String value) {
		fields.put(name, value);
	}

}
