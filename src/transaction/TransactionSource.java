package transaction;
/**
 * Interface for get the transaction.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public interface TransactionSource {
	/**
	 * Get the transaction
	 * @return transaction
	 */
	Transaction getTransaction();
	
}
