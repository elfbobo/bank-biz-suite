
/*
	本类暂时没有很复杂的代码，这个类用于保留以后智能化推断代码
*/

package  com.doublechain.bank.changerequest;


import com.doublechain.bank.changerequest.ChangeRequest;
import com.doublechain.bank.BankUserContext;

public class CreateAccountHandler extends ChangeRequestBaseHandler{
	@Override	
	protected void checkIfComplyWithSpec(BankUserContext userContext, ChangeRequest request){
		super.checkIfComplyWithSpec(userContext,request);
	}
}

