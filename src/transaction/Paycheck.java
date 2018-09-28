package transaction;

import java.util.Date;

public class Paycheck {
	
	private final Date payPeriodStartDate;
	private final Date payPeriodEndDate;
	
	public Paycheck(Date startDate, Date EndDate) {
		this.payPeriodStartDate = startDate;
		this.payPeriodEndDate = EndDate;
	}

	public Date getPayPeriodEndDate() {
		return this.payPeriodEndDate;
	}

	public Date getPayPeriodStartDate() {
		return this.payPeriodStartDate;
	}
	
}
