package domain;
/**
 * An interface for individual payment method.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public interface PaymentMethod {
	/**
	 * Pay the money via paycheck.
	 * @param pc
	 */
	void pay(Paycheck pc);

}
