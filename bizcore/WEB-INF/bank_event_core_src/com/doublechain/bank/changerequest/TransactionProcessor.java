package  com.doublechain.bank.changerequest;

import java.util.Arrays;
import com.doublechain.bank.changerequest.ChangeRequest;
import com.doublechain.bank.transaction.Transaction;
import com.doublechain.bank.BankUserContext;

public class TransactionProcessor extends ChangeRequestChainProcessor{
	
	
	protected void processInternal(BankUserContext userContext, ChangeRequest request, String beanName){
		request.getTransactionList().forEach(event->{
			
			handleSingleEvent(userContext,request,event);
		});
	}
	protected void handleSingleEvent(BankUserContext userContext, ChangeRequest request, Transaction event ){
		
		userContext.log("TransactionProcessor\t"+ event +" from processor");
		
		/*
		try {
				Account a1 = accountManagerOf(userContext)
						.loadAccount(userContext, event.getAccount().getId(), new String[] {});
				a1.updateName(event.getName());
				accountManagerOf(userContext).internalSaveAccount(userContext, a1);
		} catch (Exception e) {
				
				e.printStackTrace();
		}*/
	}
	
}


