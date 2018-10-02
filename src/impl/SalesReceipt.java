package impl;

import java.math.BigDecimal;
import java.util.Date;
/**
 * This class Encapsulate the Salereceipt.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class SalesReceipt {
	//date and amount variable.
	private final Date date;
	private final BigDecimal amount;
	
	//Constructor
	public SalesReceipt(Date date, BigDecimal amount) {
		this.date = date;
		this.amount = amount;
	}
	
	//Get the date of the sale receipt.
	public Date getDate() {
		return date;
	}
	
	//Get the amount of the payment.
	public BigDecimal getAmount() {
		return amount;
	}

}
