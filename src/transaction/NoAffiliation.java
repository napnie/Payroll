package transaction;

import java.math.BigDecimal;

public class NoAffiliation implements Affiliation {

	@Override
	public BigDecimal calculateDeductions(Paycheck pc) {
		return BigDecimal.valueOf(0.0);
	}

}
