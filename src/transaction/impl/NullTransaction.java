package transaction.impl;

import transaction.Transaction;
/**
 * This class handle the case that if the transaction is null.
 * 
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 *
 */
public class NullTransaction implements Transaction {

	@Override
	public void execute() {
		// doing nothing
	}

}
