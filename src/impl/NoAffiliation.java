package impl;

import java.math.BigDecimal;

import domain.Affiliation;
import domain.Paycheck;

public class NoAffiliation implements Affiliation {

	@Override
	public BigDecimal calculateDeductions(Paycheck pc) {
		return BigDecimal.valueOf(0.0);
	}

}
