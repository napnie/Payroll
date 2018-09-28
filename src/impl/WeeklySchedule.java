package impl;

import static java.util.Calendar.FRIDAY;

import java.util.Date;

import domain.PaymentSchedule;
import util.DateHelper;

public class WeeklySchedule implements PaymentSchedule {

	@Override
	public boolean isPayDay(Date payDate) {
		return DateHelper.dayOfWeek(payDate) == FRIDAY;
	}
	
	@Override
	public Date getPayPeriodStartDate(Date payDate) {
		return DateHelper.subtractDays(payDate, 6);
	}

}
