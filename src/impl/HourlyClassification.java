package impl;

import static java.math.BigDecimal.ROUND_HALF_UP;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import domain.Paycheck;
import domain.PaymentClassification;
/**
 * Payment in the rate of hourly
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class HourlyClassification extends PaymentClassification {
	
	//hourly rate
	private final BigDecimal hourlyRate;
	//time card in a Map collection.
	private final Map<Date, TimeCard> timeCards = new HashMap<Date, TimeCard>();
	
	/**
	 * constructor of the hourly Classification.
	 * @param hourlyRate
	 */
	public HourlyClassification(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	/**
	 * get the hourly rate.
	 * @return hourly rate.
	 */
	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}
	
	/**
	 * get the time card.
	 * @param date
	 * @return date of the time card.
	 */
	public TimeCard getTimeCard(Date date) {
		return timeCards.get(date);
	}
	
	/**
	 * put the date in the time card.
	 * @param timeCard
	 */
	public void addTimeCard(TimeCard timeCard) {
		timeCards.put(timeCard.getDate(), timeCard);
	}
	
	/**
	 * calculate the payment.
	 */
	@Override
	public BigDecimal calculatePay(Paycheck pc) {
		BigDecimal totalPay = BigDecimal.ZERO;
		for (TimeCard tc : timeCards.values()) {
			if (isInPayPeriod(tc.getDate(), pc)) {
				totalPay = totalPay.add(calculatePayForTimeCard(tc));
			}
		}
		return totalPay.setScale(2);
	}
	
	/**
	 * Calculate the payment of the time card. 
	 * @param tc : Time Card.
	 * @return value of the payment of the time card.
	 */
	@SuppressWarnings("deprecation")
	private BigDecimal calculatePayForTimeCard(TimeCard tc) {
		BigDecimal hours = tc.getHours();
		BigDecimal overtime = hours.subtract(BigDecimal.valueOf(8)).max(BigDecimal.ZERO);
		BigDecimal straightTime = hours.subtract(overtime);
		return straightTime.multiply(hourlyRate).add(overtime.multiply(hourlyRate).multiply(new BigDecimal("1.5"))).setScale(2, ROUND_HALF_UP);
	}

}
