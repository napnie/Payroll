package payroll.impl;

import payroll.domain.Paycheck;
import payroll.domain.PaymentMethod;

public class HoldMethod implements PaymentMethod {

	@Override
	public void pay(Paycheck pc) {
		pc.setField("Disposition", "Hold");
	}

}
