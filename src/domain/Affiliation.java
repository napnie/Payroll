package domain;

import java.math.BigDecimal;
/**
 * 
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 */
public interface Affiliation {

	BigDecimal calculateDeductions(Paycheck pc);

}
