package domain;

import java.math.BigDecimal;
import java.util.Date;

import util.DateHelper;
/**
 * This abstract class is used to split the different method of the payment.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public abstract class PaymentClassification {

	public abstract BigDecimal calculatePay(Paycheck pc);
	
	/**
	 * check whether if it's the time to pay or not
	 * @param date : Payment Date
	 * @param pc : Payment Classification
	 * @return true: if it is time to pay
	 * 		   false: not that time yet.
	 */
	protected boolean isInPayPeriod(Date date, Paycheck pc) {
		return DateHelper.isBetween(date, pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate());
	}

}
