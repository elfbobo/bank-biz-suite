
package com.doublechain.bank.changerequesttype;
//import com.doublechain.bank.EntityNotFoundException;
import com.doublechain.bank.BankException;
import com.doublechain.bank.Message;
import java.util.List;

public class ChangeRequestTypeManagerException extends BankException {
	private static final long serialVersionUID = 1L;
	public ChangeRequestTypeManagerException(String string) {
		super(string);
	}
	public ChangeRequestTypeManagerException(Message message) {
		super(message);
	}
	public ChangeRequestTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


