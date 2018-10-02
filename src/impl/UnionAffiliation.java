package impl;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.FRIDAY;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import domain.Affiliation;
import domain.Paycheck;
import util.DateHelper;
/**
 * This class will do the encapsulation, calculation and many more in the union affiliation.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */

public class UnionAffiliation implements Affiliation {
	
	//variables
	private final Map<Date, ServiceCharge> serviceCharges = new HashMap<Date, ServiceCharge>();
	private final int memberId;
	private final BigDecimal weeklyDues;
	
	
	//constructors
	public UnionAffiliation(int memberId, BigDecimal weeklyDues) {
		this.memberId = memberId;
		this.weeklyDues = weeklyDues;
	}
	
	/**
	 * Get the service charge date.
	 * @param date
	 * @return date of the service charge.
	 */
	public ServiceCharge getServiceCharge(Date date) {
		return serviceCharges.get(date);
	}
	
	/**
	 * Add the service charge date.
	 * @param charge
	 */
	public void addServiceCharge(ServiceCharge charge) {
		serviceCharges.put(charge.getDate(), charge);
	}
	
	/**
	 * Get member system.
	 * @return member id.
	 */
	public int getMemberId() {
		return memberId;
	}
	
	/**
	 * Get the weekly dues value.
	 * @return value of the weekly dues
	 */
	public BigDecimal getWeeklyDues() {
		return weeklyDues;
	}
	
	/**
	 * Return the calculated deductions.
	 */
	@Override
	public BigDecimal calculateDeductions(Paycheck pc) {
		return calculateUnionDues(pc).add(calculateServiceCharges(pc));
	}
	
	/**
	 * Calculate the union dues.
	 * @param pc
	 * @return values of the dues.
	 */
	@SuppressWarnings("deprecation")
	private BigDecimal calculateUnionDues(Paycheck pc) {
		int fridays = numberOfFridaysInPayPeriod(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate());
		return weeklyDues.multiply(BigDecimal.valueOf(fridays)).setScale(2, ROUND_HALF_UP);
	}
	
	/**
	 * Calculating the service charge of the paycheck.
	 * @param pc
	 * @return calculated service charges.
	 */
	private BigDecimal calculateServiceCharges(Paycheck pc) {
		BigDecimal charges = BigDecimal.ZERO;
		for (ServiceCharge charge : serviceCharges.values()) {
			if (DateHelper.isBetween(charge.getDate(), pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())) {
				charges = charges.add(charge.getAmount());
			}
		}
		return charges;
	}
	
	/**
	 * Calculate how many Friday in the pay period.
	 * @param payPeriodStartDate: start date
	 * @param payPeriodEndDate: end date.
	 * @return numbers of the Friday.
	 */
	private int numberOfFridaysInPayPeriod(Date payPeriodStartDate, Date payPeriodEndDate) {
		int fridays = 0;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(payPeriodStartDate);
		while (!cal.getTime().after(payPeriodEndDate)) {
			if (cal.get(DAY_OF_WEEK) == FRIDAY) {
				fridays++;
			}
			cal.add(DATE, 1);
		}
		
		return fridays;
	}

}
