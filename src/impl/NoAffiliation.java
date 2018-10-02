package impl;

import java.math.BigDecimal;

import domain.Affiliation;
import domain.Paycheck;
/**
 * This class will handle the case that if there are no affiliation.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class NoAffiliation implements Affiliation {
	
	/**
	 * return 0 in the paycheck.
	 */
	@Override
	public BigDecimal calculateDeductions(Paycheck pc) {
		return BigDecimal.valueOf(0.0);
	}

}
