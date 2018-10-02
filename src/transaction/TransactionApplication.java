package transaction;

import app.Application;
/**
 * This class will run the transaction application.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class TransactionApplication extends Application {

	private final TransactionSource source;

	public TransactionApplication(TransactionSource source) {
		this.source = source;
	}
	
	@Override
	public void run() {
		Transaction trans;
		while ((trans = source.getTransaction()) != null) {
			trans.execute();
		}
	}
	
}
