
package com.doublechain.bank.candidatecontainer;
//import com.doublechain.bank.EntityNotFoundException;
import com.doublechain.bank.BankException;
import com.doublechain.bank.Message;
import java.util.List;

public class CandidateContainerManagerException extends BankException {
	private static final long serialVersionUID = 1L;
	public CandidateContainerManagerException(String string) {
		super(string);
	}
	public CandidateContainerManagerException(Message message) {
		super(message);
	}
	public CandidateContainerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


