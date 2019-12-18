/*
	ChangeRequestBaseHandler 最基础的Handler，如果这些ChangeRequest都按照Event规则来处理，
	那么有这个ChangeRequestBaseHandler对于大多数系统就足够了。
*/
package  com.doublechain.bank.changerequest;
import java.util.Arrays;
import com.doublechain.bank.changerequest.ChangeRequest;
import com.doublechain.bank.BankUserContext;
import com.doublechain.bank.CustomBankCheckerManager;
public class ChangeRequestChainProcessor extends CustomBankCheckerManager{
	
	protected void preProcess(BankUserContext userContext, ChangeRequest request, String beanName){
		
	}
	public void process(BankUserContext userContext, ChangeRequest request, String beanName){
		preProcess(userContext, request, beanName);
		processInternal(userContext, request, beanName);
		postProcess(userContext, request, beanName);
	}
	protected void postProcess(BankUserContext userContext, ChangeRequest request, String beanName){
		
	}
	protected void processInternal(BankUserContext userContext, ChangeRequest request, String beanName){
		
	}
	
}




