package impl;

import java.math.BigDecimal;
import java.util.Date;
/**
 * This class Encapsulate the Service Charge value.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class ServiceCharge {
	
	//variables
	private final Date date;
	private final BigDecimal amount;
	
	//constructor
	public ServiceCharge(Date date, BigDecimal amount) {
		this.date = date;
		this.amount = amount;
	}
	
	/**
	 * Get the date of the service charge.
	 * @return date of the service charge.
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Get the amount of the service charge.
	 * @return amount of the service charge.
	 */
	public BigDecimal getAmount() {
		return amount;
	}

}
