
package com.doublechain.bank.transaction;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechain.bank.BaseEntity;


import com.doublechain.bank.Message;
import com.doublechain.bank.SmartList;
import com.doublechain.bank.MultipleAccessKey;

import com.doublechain.bank.BankUserContext;
//import com.doublechain.bank.BaseManagerImpl;
import com.doublechain.bank.BankCheckerManager;
import com.doublechain.bank.CustomBankCheckerManager;

import com.doublechain.bank.changerequest.ChangeRequest;
import com.doublechain.bank.account.Account;

import com.doublechain.bank.changerequest.CandidateChangeRequest;
import com.doublechain.bank.account.CandidateAccount;







public class TransactionManagerImpl extends CustomBankCheckerManager implements TransactionManager {
	
	private static final String SERVICE_TYPE = "Transaction";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransactionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransactionManagerException(message);

	}
	
	

 	protected Transaction saveTransaction(BankUserContext userContext, Transaction transaction, String [] tokensExpr) throws Exception{	
 		//return getTransactionDAO().save(transaction, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransaction(userContext, transaction, tokens);
 	}
 	
 	protected Transaction saveTransactionDetail(BankUserContext userContext, Transaction transaction) throws Exception{	

 		
 		return saveTransaction(userContext, transaction, allTokens());
 	}
 	
 	public Transaction loadTransaction(BankUserContext userContext, String transactionId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Transaction transaction = loadTransaction( userContext, transactionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transaction, tokens);
 	}
 	
 	
 	 public Transaction searchTransaction(BankUserContext userContext, String transactionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Transaction transaction = loadTransaction( userContext, transactionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transaction, tokens);
 	}
 	
 	

 	protected Transaction present(BankUserContext userContext, Transaction transaction, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transaction,tokens);
		
		
		Transaction  transactionToPresent = userContext.getDAOGroup().getTransactionDAO().present(transaction, tokens);
		
		List<BaseEntity> entityListToNaming = transactionToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransactionDAO().alias(entityListToNaming);
		
		return  transactionToPresent;
		
		
	}
 
 	
 	
 	public Transaction loadTransactionDetail(BankUserContext userContext, String transactionId) throws Exception{	
 		Transaction transaction = loadTransaction( userContext, transactionId, allTokens());
 		return present(userContext,transaction, allTokens());
		
 	}
 	
 	public Object view(BankUserContext userContext, String transactionId) throws Exception{	
 		Transaction transaction = loadTransaction( userContext, transactionId, viewTokens());
 		return present(userContext,transaction, allTokens());
		
 	}
 	protected Transaction saveTransaction(BankUserContext userContext, Transaction transaction, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransactionDAO().save(transaction, tokens);
 	}
 	protected Transaction loadTransaction(BankUserContext userContext, String transactionId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionManagerException.class);

 
 		return userContext.getDAOGroup().getTransactionDAO().load(transactionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BankUserContext userContext, Transaction transaction, Map<String, Object> tokens){
		super.addActions(userContext, transaction, tokens);
		
		addAction(userContext, transaction, tokens,"@create","createTransaction","createTransaction/","main","primary");
		addAction(userContext, transaction, tokens,"@update","updateTransaction","updateTransaction/"+transaction.getId()+"/","main","primary");
		addAction(userContext, transaction, tokens,"@copy","cloneTransaction","cloneTransaction/"+transaction.getId()+"/","main","primary");
		
		addAction(userContext, transaction, tokens,"transaction.transfer_to_from_account","transferToAnotherFromAccount","transferToAnotherFromAccount/"+transaction.getId()+"/","main","primary");
		addAction(userContext, transaction, tokens,"transaction.transfer_to_to_account","transferToAnotherToAccount","transferToAnotherToAccount/"+transaction.getId()+"/","main","primary");
		addAction(userContext, transaction, tokens,"transaction.transfer_to_change_request","transferToAnotherChangeRequest","transferToAnotherChangeRequest/"+transaction.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BankUserContext userContext, Transaction transaction, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Transaction createTransaction(BankUserContext userContext,String name, String fromAccountId, String toAccountId, BigDecimal amount, String type, String changeRequestId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransaction(name);
		userContext.getChecker().checkAmountOfTransaction(amount);
		userContext.getChecker().checkTypeOfTransaction(type);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);


		Transaction transaction=createNewTransaction();	

		transaction.setName(name);
			
		Account fromAccount = loadAccount(userContext, fromAccountId,emptyOptions());
		transaction.setFromAccount(fromAccount);
		
		
			
		Account toAccount = loadAccount(userContext, toAccountId,emptyOptions());
		transaction.setToAccount(toAccount);
		
		
		transaction.setAmount(amount);
		transaction.setType(type);
			
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId,emptyOptions());
		transaction.setChangeRequest(changeRequest);
		
		

		transaction = saveTransaction(userContext, transaction, emptyOptions());
		
		onNewInstanceCreated(userContext, transaction);
		return transaction;

		
	}
	protected Transaction createNewTransaction() 
	{
		
		return new Transaction();		
	}
	
	protected void checkParamsForUpdatingTransaction(BankUserContext userContext,String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().checkVersionOfTransaction( transactionVersion);
		

		if(Transaction.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransaction(parseString(newValueExpr));
		}		

				

		
		if(Transaction.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfTransaction(parseBigDecimal(newValueExpr));
		}
		if(Transaction.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfTransaction(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
	
		
	}
	
	
	
	public Transaction clone(BankUserContext userContext, String fromTransactionId) throws Exception{
		
		return userContext.getDAOGroup().getTransactionDAO().clone(fromTransactionId, this.allTokens());
	}
	
	public Transaction internalSaveTransaction(BankUserContext userContext, Transaction transaction) throws Exception 
	{
		return internalSaveTransaction(userContext, transaction, allTokens());

	}
	public Transaction internalSaveTransaction(BankUserContext userContext, Transaction transaction, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransaction(userContext, transactionId, transactionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transaction){ 
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Transaction.
			if (transaction.isChanged()){
			
			}
			transaction = saveTransaction(userContext, transaction, options);
			return transaction;
			
		}

	}
	
	public Transaction updateTransaction(BankUserContext userContext,String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransaction(userContext, transactionId, transactionVersion, property, newValueExpr, tokensExpr);
		
		
		
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());
		if(transaction.getVersion() != transactionVersion){
			String message = "The target version("+transaction.getVersion()+") is not equals to version("+transactionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transaction){ 
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Transaction.
			
			transaction.changeProperty(property, newValueExpr);
			transaction = saveTransaction(userContext, transaction, tokens().done());
			return present(userContext,transaction, mergedAllTokens(tokensExpr));
			//return saveTransaction(userContext, transaction, tokens().done());
		}

	}
	
	public Transaction updateTransactionProperty(BankUserContext userContext,String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransaction(userContext, transactionId, transactionVersion, property, newValueExpr, tokensExpr);
		
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());
		if(transaction.getVersion() != transactionVersion){
			String message = "The target version("+transaction.getVersion()+") is not equals to version("+transactionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transaction){ 
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Transaction.
			
			transaction.changeProperty(property, newValueExpr);
			
			transaction = saveTransaction(userContext, transaction, tokens().done());
			return present(userContext,transaction, mergedAllTokens(tokensExpr));
			//return saveTransaction(userContext, transaction, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransactionTokens tokens(){
		return TransactionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransactionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransactionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherFromAccount(BankUserContext userContext, String transactionId, String anotherFromAccountId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransaction(transactionId);
 		userContext.getChecker().checkIdOfAccount(anotherFromAccountId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
 		
 	}
 	public Transaction transferToAnotherFromAccount(BankUserContext userContext, String transactionId, String anotherFromAccountId) throws Exception
 	{
 		checkParamsForTransferingAnotherFromAccount(userContext, transactionId,anotherFromAccountId);
 
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());	
		synchronized(transaction){
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Account fromAccount = loadAccount(userContext, anotherFromAccountId, emptyOptions());		
			transaction.updateFromAccount(fromAccount);		
			transaction = saveTransaction(userContext, transaction, emptyOptions());
			
			return present(userContext,transaction, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherFromAccountWithName(BankUserContext userContext, String transactionId, String anotherName) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransaction(transactionId);
 		userContext.getChecker().checkNameOfAccount( anotherName);
 		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
 		
 	}

 	public Transaction transferToAnotherFromAccountWithName(BankUserContext userContext, String transactionId, String anotherName) throws Exception
 	{
 		checkParamsForTransferingAnotherFromAccountWithName(userContext, transactionId,anotherName);
 		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());	
		synchronized(transaction){
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Account fromAccount = loadAccountWithName(userContext, anotherName, emptyOptions());		
			transaction.updateFromAccount(fromAccount);		
			transaction = saveTransaction(userContext, transaction, emptyOptions());
			
			return present(userContext,transaction, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateAccount requestCandidateFromAccount(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccount result = new CandidateAccount();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Account> candidateList = userContext.getDAOGroup().getAccountDAO().requestCandidateAccountForTransactionAsFromAccount(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherToAccount(BankUserContext userContext, String transactionId, String anotherToAccountId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransaction(transactionId);
 		userContext.getChecker().checkIdOfAccount(anotherToAccountId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
 		
 	}
 	public Transaction transferToAnotherToAccount(BankUserContext userContext, String transactionId, String anotherToAccountId) throws Exception
 	{
 		checkParamsForTransferingAnotherToAccount(userContext, transactionId,anotherToAccountId);
 
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());	
		synchronized(transaction){
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Account toAccount = loadAccount(userContext, anotherToAccountId, emptyOptions());		
			transaction.updateToAccount(toAccount);		
			transaction = saveTransaction(userContext, transaction, emptyOptions());
			
			return present(userContext,transaction, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherToAccountWithName(BankUserContext userContext, String transactionId, String anotherName) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransaction(transactionId);
 		userContext.getChecker().checkNameOfAccount( anotherName);
 		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
 		
 	}

 	public Transaction transferToAnotherToAccountWithName(BankUserContext userContext, String transactionId, String anotherName) throws Exception
 	{
 		checkParamsForTransferingAnotherToAccountWithName(userContext, transactionId,anotherName);
 		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());	
		synchronized(transaction){
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Account toAccount = loadAccountWithName(userContext, anotherName, emptyOptions());		
			transaction.updateToAccount(toAccount);		
			transaction = saveTransaction(userContext, transaction, emptyOptions());
			
			return present(userContext,transaction, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateAccount requestCandidateToAccount(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccount result = new CandidateAccount();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Account> candidateList = userContext.getDAOGroup().getAccountDAO().requestCandidateAccountForTransactionAsToAccount(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherChangeRequest(BankUserContext userContext, String transactionId, String anotherChangeRequestId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransaction(transactionId);
 		userContext.getChecker().checkIdOfChangeRequest(anotherChangeRequestId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
 		
 	}
 	public Transaction transferToAnotherChangeRequest(BankUserContext userContext, String transactionId, String anotherChangeRequestId) throws Exception
 	{
 		checkParamsForTransferingAnotherChangeRequest(userContext, transactionId,anotherChangeRequestId);
 
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());	
		synchronized(transaction){
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequest changeRequest = loadChangeRequest(userContext, anotherChangeRequestId, emptyOptions());		
			transaction.updateChangeRequest(changeRequest);		
			transaction = saveTransaction(userContext, transaction, emptyOptions());
			
			return present(userContext,transaction, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateChangeRequest requestCandidateChangeRequest(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateChangeRequest result = new CandidateChangeRequest();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ChangeRequest> candidateList = userContext.getDAOGroup().getChangeRequestDAO().requestCandidateChangeRequestForTransaction(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected ChangeRequest loadChangeRequest(BankUserContext userContext, String newChangeRequestId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getChangeRequestDAO().load(newChangeRequestId, options);
 	}
 	
 	
 	
	
	 	
 	protected Account loadAccount(BankUserContext userContext, String newFromAccountId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountDAO().load(newFromAccountId, options);
 	}
 	
 	protected Account loadAccountWithName(BankUserContext userContext, String newName, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountDAO().loadByName(newName, options);
 	}
 	
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BankUserContext userContext, String transactionId, int transactionVersion) throws Exception {
		//deleteInternal(userContext, transactionId, transactionVersion);		
	}
	protected void deleteInternal(BankUserContext userContext,
			String transactionId, int transactionVersion) throws Exception{
			
		userContext.getDAOGroup().getTransactionDAO().delete(transactionId, transactionVersion);
	}
	
	public Transaction forgetByAll(BankUserContext userContext, String transactionId, int transactionVersion) throws Exception {
		return forgetByAllInternal(userContext, transactionId, transactionVersion);		
	}
	protected Transaction forgetByAllInternal(BankUserContext userContext,
			String transactionId, int transactionVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransactionDAO().disconnectFromAll(transactionId, transactionVersion);
	}
	

	
	public int deleteAll(BankUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransactionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BankUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransactionDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BankUserContext userContext, Transaction newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


