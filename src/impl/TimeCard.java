package impl;

import java.math.BigDecimal;
import java.util.Date;
/**
 * Encapsulation of the Time Card.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class TimeCard {
	//variables
	private final Date date;
	private final BigDecimal hours;
	
	//constructor
	public TimeCard(Date date, BigDecimal hours) {
		this.date = date;
		this.hours = hours;
	}
	
	/**
	 * get the date of the time card.
	 * @return date of the time card.
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * get the hours of the time card
	 * @return hours of the time card
	 */
	public BigDecimal getHours() {
		return hours;
	}

}
