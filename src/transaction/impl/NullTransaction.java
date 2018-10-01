package transaction.impl;

import transaction.Transaction;

public class NullTransaction implements Transaction {

	@Override
	public void execute() {
		// doing nothing
	}

}
