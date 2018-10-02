package transaction.impl;

import static db.PayrollDatabase.GlobalInstance.GpayrollDatabase;

import java.math.BigDecimal;
import java.util.Date;

import domain.Affiliation;
import domain.Employee;
import impl.ServiceCharge;
import impl.UnionAffiliation;
import transaction.Transaction;
/**
 * This class will do the transaction of the service charge.
 * @author Theeruth Borisuth
 * @author Nitith   Chayakul
 */
public class ServiceChargeTransaction implements Transaction {
	//variables.
	private final int memberId;
	private final Date date;
	private final BigDecimal charge;
	
	//constructors.
	public ServiceChargeTransaction(int memberId, Date date, BigDecimal charge) {
		this.memberId = memberId;
		this.date = date;
		this.charge = charge;
	}
	
	/**
	 * Execute the transaction.
	 */
	@Override
	public void execute() {
		Employee e = GpayrollDatabase.getUnionMember(memberId);
		Affiliation af = e.getAffiliation();
		if (af instanceof UnionAffiliation) {
			UnionAffiliation uaf = (UnionAffiliation) af;
			uaf.addServiceCharge(new ServiceCharge(date, charge));
		}
	}

}
