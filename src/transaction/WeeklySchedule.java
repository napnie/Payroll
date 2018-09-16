package transaction;

import java.util.Date;

public class WeeklySchedule implements PaymentSchedule {

	@Override
	public boolean isPayDay(Date payDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Date getPayPeriodStartDate(Date payDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
