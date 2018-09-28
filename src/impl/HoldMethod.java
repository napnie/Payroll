package impl;

import domain.Paycheck;
import domain.PaymentMethod;

public class HoldMethod implements PaymentMethod {

	@Override
	public void pay(Paycheck pc) {
		pc.setField("Disposition", "Hold");
	}

}
