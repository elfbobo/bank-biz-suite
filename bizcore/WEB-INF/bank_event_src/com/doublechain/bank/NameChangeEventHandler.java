package com.doublechain.bank;

import com.doublechain.bank.account.Account;
import com.doublechain.bank.changerequest.ChangeRequest;
import com.doublechain.bank.namechangeevent.NameChangeEvent;
import com.doublechain.bank.transaction.Transaction;

public class NameChangeEventHandler extends RequestHandler {
	/*
	public void apply(BankUserContext userContext, ChangeRequest newReq, NameChangeEvent event) throws Exception {
		Account a1 = accountManagerOf(userContext)
				.loadAccount(userContext, event.getAccount().getId(), new String[] {});
		a1.updateName(event.getName());
		accountManagerOf(userContext).internalSaveAccount(userContext, a1);
		
	}*/
	
	public void applyEventList(BankUserContext userContext, ChangeRequest newReq) throws Exception {
		
		newReq.getNameChangeEventList().forEach(event->{
			
			try {
				Account a1 = accountManagerOf(userContext)
						.loadAccount(userContext, event.getAccount().getId(), new String[] {});
				a1.updateName(event.getName());
				accountManagerOf(userContext).internalSaveAccount(userContext, a1);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		});
		
		
		
	}
}
