package impl;

import static java.util.Calendar.DAY_OF_MONTH;

import java.util.Calendar;
import java.util.Date;

import domain.PaymentSchedule;
/**
 * A payment in monthly.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class MonthlySchedule implements PaymentSchedule {
	/**]
	 * Check whether if it's a payment or not.
	 * true: if it is.
	 * false: if it is not.
	 */
	@Override
	public boolean isPayDay(Date payDate) {
		return isLastDayOfMonth(payDate);
	}
	
	/**
	 * Check whether if it's the last day of the month
	 * @param payDate
	 * @return true: if it is.
	 * 		   false: if it isn't.
	 */
	private boolean isLastDayOfMonth(Date payDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(payDate);
		return cal.get(DAY_OF_MONTH) == cal.getActualMaximum(DAY_OF_MONTH);
	}
	
	/**
	 * Get the start date of the pay period.
	 */
	@Override
	public Date getPayPeriodStartDate(Date payDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(payDate);
		cal.set(DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
}
