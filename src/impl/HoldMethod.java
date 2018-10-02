package impl;

import domain.Paycheck;
import domain.PaymentMethod;
/**
 * Class that will put the paycheck on hold.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class HoldMethod implements PaymentMethod {
	
	//Hold the paycheck.
	@Override
	public void pay(Paycheck pc) {
		pc.setField("Disposition", "Hold");
	}

}
