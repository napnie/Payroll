package impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import domain.PaymentSchedule;
import util.DateHelper;
/**
 * This class is used for get pay date in the twice a week.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class BiweeklySchedule implements PaymentSchedule {
	
	//paydates
	private static final Set<Date> paydates = calculateBiWeeklyPayDates();
	
	/**
	 * check whether if it is a pay day or not.
	 */
	@Override
	public boolean isPayDay(Date payDate) {
		return paydates.contains(payDate);
	}
	
	/**
	 * Get the start date
	 */
	@Override
	public Date getPayPeriodStartDate(Date payDate) {
		return DateHelper.subtractDays(payDate, 13);
	}
	
	// this only works from 1950 - 2050, need to calculate more dates for a pay day outside that range
	private static Set<Date> calculateBiWeeklyPayDates() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(1950, 0, 6);
		
		Set<Date> paydates = new HashSet<Date>();
		for (int i = 0; i < 2610; i++) {
			paydates.add(cal.getTime());
			cal.add(Calendar.DATE, 14);
		}
		return paydates;
	}

}
