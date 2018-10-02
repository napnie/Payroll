package domain;

import java.util.Date;
/**
 * 
 * An interface for describing the payment schedule.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public interface PaymentSchedule {
	//Check the pay date
	boolean isPayDay(Date payDate);
	//Get the pay date.
	Date getPayPeriodStartDate(Date payDate);

}
