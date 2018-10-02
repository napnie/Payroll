package util;

import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_WEEK;

import java.util.Calendar;
import java.util.Date;
/**
 * Help the transcation data
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class DateHelper {
	/**
	 * subtract the days
	 * @param date
	 * @param days
	 * @return times
	 */
	public static Date subtractDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(DATE, days * -1);
		return cal.getTime();
	}
	
	/**
	 * get day of the week.
	 * @param date
	 * @return day of the week.
	 */
	public static int dayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(DAY_OF_WEEK);
	}
	
	/**
	 * Check whether if it between start date and end date or not
	 * @param date
	 * @param startDate
	 * @param endDate
	 * @return true: if it yes
	 * 		   false: if it is not.
	 */
	public static boolean isBetween(Date date, Date startDate, Date endDate) {
		return !date.before(startDate) && !date.after(endDate);
	}
	
}
