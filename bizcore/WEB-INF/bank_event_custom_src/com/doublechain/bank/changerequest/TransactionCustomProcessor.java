package  com.doublechain.bank.changerequest;

import java.util.Arrays;
import com.doublechain.bank.changerequest.ChangeRequest;
import com.doublechain.bank.transaction.Transaction;
import com.doublechain.bank.BankUserContext;

public class TransactionCustomProcessor extends TransactionProcessor{
	
	
	
	protected void handleSingleEvent(BankUserContext userContext, ChangeRequest request, Transaction event ){
		
		userContext.log("TransactionCustomProcessor\t"+ event +" from processor");
		
		
	}
	
}





