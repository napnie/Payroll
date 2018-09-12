package transaction;

import java.math.BigDecimal;

public interface Affiliation {
	
	BigDecimal calculateDeductions(Paycheck pc);
	
}
