package  com.doublechain.bank.changerequest;

import java.util.Arrays;
import com.doublechain.bank.changerequest.ChangeRequest;
import com.doublechain.bank.namechangeevent.NameChangeEvent;
import com.doublechain.bank.BankUserContext;

public class NameChangeEventCustomProcessor extends NameChangeEventProcessor{
	
	
	
	protected void handleSingleEvent(BankUserContext userContext, ChangeRequest request, NameChangeEvent event ){
		
		userContext.log("NameChangeEventCustomProcessor\t"+ event +" from processor");
		
		
	}
	
}











