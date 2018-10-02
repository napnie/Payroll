package impl;

import static java.util.Calendar.FRIDAY;

import java.util.Date;

import domain.PaymentSchedule;
import util.DateHelper;
/**
 * This class has a role in checking the pa ydate and get the start date of the pay period.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */

public class WeeklySchedule implements PaymentSchedule {
	
	/**
	 * Check the paydate, return in boolean
	 */
	@Override
	public boolean isPayDay(Date payDate) {
		return DateHelper.dayOfWeek(payDate) == FRIDAY;
	}
	
	/**
	 * Get the start date.
	 */
	@Override
	public Date getPayPeriodStartDate(Date payDate) {
		return DateHelper.subtractDays(payDate, 6);
	}

}
