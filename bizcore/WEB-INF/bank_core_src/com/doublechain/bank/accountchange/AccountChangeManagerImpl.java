
package com.doublechain.bank.accountchange;

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







public class AccountChangeManagerImpl extends CustomBankCheckerManager implements AccountChangeManager {
	
	private static final String SERVICE_TYPE = "AccountChange";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AccountChangeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AccountChangeManagerException(message);

	}
	
	

 	protected AccountChange saveAccountChange(BankUserContext userContext, AccountChange accountChange, String [] tokensExpr) throws Exception{	
 		//return getAccountChangeDAO().save(accountChange, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountChange(userContext, accountChange, tokens);
 	}
 	
 	protected AccountChange saveAccountChangeDetail(BankUserContext userContext, AccountChange accountChange) throws Exception{	

 		
 		return saveAccountChange(userContext, accountChange, allTokens());
 	}
 	
 	public AccountChange loadAccountChange(BankUserContext userContext, String accountChangeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountChange(accountChangeId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountChangeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountChange accountChange = loadAccountChange( userContext, accountChangeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountChange, tokens);
 	}
 	
 	
 	 public AccountChange searchAccountChange(BankUserContext userContext, String accountChangeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountChange(accountChangeId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountChangeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountChange accountChange = loadAccountChange( userContext, accountChangeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountChange, tokens);
 	}
 	
 	

 	protected AccountChange present(BankUserContext userContext, AccountChange accountChange, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountChange,tokens);
		
		
		AccountChange  accountChangeToPresent = userContext.getDAOGroup().getAccountChangeDAO().present(accountChange, tokens);
		
		List<BaseEntity> entityListToNaming = accountChangeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountChangeDAO().alias(entityListToNaming);
		
		return  accountChangeToPresent;
		
		
	}
 
 	
 	
 	public AccountChange loadAccountChangeDetail(BankUserContext userContext, String accountChangeId) throws Exception{	
 		AccountChange accountChange = loadAccountChange( userContext, accountChangeId, allTokens());
 		return present(userContext,accountChange, allTokens());
		
 	}
 	
 	public Object view(BankUserContext userContext, String accountChangeId) throws Exception{	
 		AccountChange accountChange = loadAccountChange( userContext, accountChangeId, viewTokens());
 		return present(userContext,accountChange, allTokens());
		
 	}
 	protected AccountChange saveAccountChange(BankUserContext userContext, AccountChange accountChange, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAccountChangeDAO().save(accountChange, tokens);
 	}
 	protected AccountChange loadAccountChange(BankUserContext userContext, String accountChangeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountChange(accountChangeId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountChangeManagerException.class);

 
 		return userContext.getDAOGroup().getAccountChangeDAO().load(accountChangeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BankUserContext userContext, AccountChange accountChange, Map<String, Object> tokens){
		super.addActions(userContext, accountChange, tokens);
		
		addAction(userContext, accountChange, tokens,"@create","createAccountChange","createAccountChange/","main","primary");
		addAction(userContext, accountChange, tokens,"@update","updateAccountChange","updateAccountChange/"+accountChange.getId()+"/","main","primary");
		addAction(userContext, accountChange, tokens,"@copy","cloneAccountChange","cloneAccountChange/"+accountChange.getId()+"/","main","primary");
		
		addAction(userContext, accountChange, tokens,"account_change.transfer_to_account","transferToAnotherAccount","transferToAnotherAccount/"+accountChange.getId()+"/","main","primary");
		addAction(userContext, accountChange, tokens,"account_change.transfer_to_change_request","transferToAnotherChangeRequest","transferToAnotherChangeRequest/"+accountChange.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BankUserContext userContext, AccountChange accountChange, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountChange createAccountChange(BankUserContext userContext,String name, String accountId, BigDecimal previousBalance, String type, BigDecimal amount, BigDecimal currentBalance, String changeRequestId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfAccountChange(name);
		userContext.getChecker().checkPreviousBalanceOfAccountChange(previousBalance);
		userContext.getChecker().checkTypeOfAccountChange(type);
		userContext.getChecker().checkAmountOfAccountChange(amount);
		userContext.getChecker().checkCurrentBalanceOfAccountChange(currentBalance);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountChangeManagerException.class);


		AccountChange accountChange=createNewAccountChange();	

		accountChange.setName(name);
			
		Account account = loadAccount(userContext, accountId,emptyOptions());
		accountChange.setAccount(account);
		
		
		accountChange.setPreviousBalance(previousBalance);
		accountChange.setType(type);
		accountChange.setAmount(amount);
		accountChange.setCurrentBalance(currentBalance);
			
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId,emptyOptions());
		accountChange.setChangeRequest(changeRequest);
		
		

		accountChange = saveAccountChange(userContext, accountChange, emptyOptions());
		
		onNewInstanceCreated(userContext, accountChange);
		return accountChange;

		
	}
	protected AccountChange createNewAccountChange() 
	{
		
		return new AccountChange();		
	}
	
	protected void checkParamsForUpdatingAccountChange(BankUserContext userContext,String accountChangeId, int accountChangeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAccountChange(accountChangeId);
		userContext.getChecker().checkVersionOfAccountChange( accountChangeVersion);
		

		if(AccountChange.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountChange(parseString(newValueExpr));
		}		

		
		if(AccountChange.PREVIOUS_BALANCE_PROPERTY.equals(property)){
			userContext.getChecker().checkPreviousBalanceOfAccountChange(parseBigDecimal(newValueExpr));
		}
		if(AccountChange.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfAccountChange(parseString(newValueExpr));
		}
		if(AccountChange.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfAccountChange(parseBigDecimal(newValueExpr));
		}
		if(AccountChange.CURRENT_BALANCE_PROPERTY.equals(property)){
			userContext.getChecker().checkCurrentBalanceOfAccountChange(parseBigDecimal(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountChangeManagerException.class);
	
		
	}
	
	
	
	public AccountChange clone(BankUserContext userContext, String fromAccountChangeId) throws Exception{
		
		return userContext.getDAOGroup().getAccountChangeDAO().clone(fromAccountChangeId, this.allTokens());
	}
	
	public AccountChange internalSaveAccountChange(BankUserContext userContext, AccountChange accountChange) throws Exception 
	{
		return internalSaveAccountChange(userContext, accountChange, allTokens());

	}
	public AccountChange internalSaveAccountChange(BankUserContext userContext, AccountChange accountChange, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAccountChange(userContext, accountChangeId, accountChangeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(accountChange){ 
			//will be good when the accountChange loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountChange.
			if (accountChange.isChanged()){
			
			}
			accountChange = saveAccountChange(userContext, accountChange, options);
			return accountChange;
			
		}

	}
	
	public AccountChange updateAccountChange(BankUserContext userContext,String accountChangeId, int accountChangeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountChange(userContext, accountChangeId, accountChangeVersion, property, newValueExpr, tokensExpr);
		
		
		
		AccountChange accountChange = loadAccountChange(userContext, accountChangeId, allTokens());
		if(accountChange.getVersion() != accountChangeVersion){
			String message = "The target version("+accountChange.getVersion()+") is not equals to version("+accountChangeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountChange){ 
			//will be good when the accountChange loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountChange.
			
			accountChange.changeProperty(property, newValueExpr);
			accountChange = saveAccountChange(userContext, accountChange, tokens().done());
			return present(userContext,accountChange, mergedAllTokens(tokensExpr));
			//return saveAccountChange(userContext, accountChange, tokens().done());
		}

	}
	
	public AccountChange updateAccountChangeProperty(BankUserContext userContext,String accountChangeId, int accountChangeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountChange(userContext, accountChangeId, accountChangeVersion, property, newValueExpr, tokensExpr);
		
		AccountChange accountChange = loadAccountChange(userContext, accountChangeId, allTokens());
		if(accountChange.getVersion() != accountChangeVersion){
			String message = "The target version("+accountChange.getVersion()+") is not equals to version("+accountChangeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountChange){ 
			//will be good when the accountChange loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountChange.
			
			accountChange.changeProperty(property, newValueExpr);
			
			accountChange = saveAccountChange(userContext, accountChange, tokens().done());
			return present(userContext,accountChange, mergedAllTokens(tokensExpr));
			//return saveAccountChange(userContext, accountChange, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountChangeTokens tokens(){
		return AccountChangeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountChangeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountChangeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAccount(BankUserContext userContext, String accountChangeId, String anotherAccountId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountChange(accountChangeId);
 		userContext.getChecker().checkIdOfAccount(anotherAccountId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountChangeManagerException.class);
 		
 	}
 	public AccountChange transferToAnotherAccount(BankUserContext userContext, String accountChangeId, String anotherAccountId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccount(userContext, accountChangeId,anotherAccountId);
 
		AccountChange accountChange = loadAccountChange(userContext, accountChangeId, allTokens());	
		synchronized(accountChange){
			//will be good when the accountChange loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Account account = loadAccount(userContext, anotherAccountId, emptyOptions());		
			accountChange.updateAccount(account);		
			accountChange = saveAccountChange(userContext, accountChange, emptyOptions());
			
			return present(userContext,accountChange, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherAccountWithName(BankUserContext userContext, String accountChangeId, String anotherName) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountChange(accountChangeId);
 		userContext.getChecker().checkNameOfAccount( anotherName);
 		userContext.getChecker().throwExceptionIfHasErrors(AccountChangeManagerException.class);
 		
 	}

 	public AccountChange transferToAnotherAccountWithName(BankUserContext userContext, String accountChangeId, String anotherName) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountWithName(userContext, accountChangeId,anotherName);
 		AccountChange accountChange = loadAccountChange(userContext, accountChangeId, allTokens());	
		synchronized(accountChange){
			//will be good when the accountChange loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Account account = loadAccountWithName(userContext, anotherName, emptyOptions());		
			accountChange.updateAccount(account);		
			accountChange = saveAccountChange(userContext, accountChange, emptyOptions());
			
			return present(userContext,accountChange, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateAccount requestCandidateAccount(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<Account> candidateList = userContext.getDAOGroup().getAccountDAO().requestCandidateAccountForAccountChange(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherChangeRequest(BankUserContext userContext, String accountChangeId, String anotherChangeRequestId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountChange(accountChangeId);
 		userContext.getChecker().checkIdOfChangeRequest(anotherChangeRequestId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountChangeManagerException.class);
 		
 	}
 	public AccountChange transferToAnotherChangeRequest(BankUserContext userContext, String accountChangeId, String anotherChangeRequestId) throws Exception
 	{
 		checkParamsForTransferingAnotherChangeRequest(userContext, accountChangeId,anotherChangeRequestId);
 
		AccountChange accountChange = loadAccountChange(userContext, accountChangeId, allTokens());	
		synchronized(accountChange){
			//will be good when the accountChange loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequest changeRequest = loadChangeRequest(userContext, anotherChangeRequestId, emptyOptions());		
			accountChange.updateChangeRequest(changeRequest);		
			accountChange = saveAccountChange(userContext, accountChange, emptyOptions());
			
			return present(userContext,accountChange, allTokens());
			
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
		SmartList<ChangeRequest> candidateList = userContext.getDAOGroup().getChangeRequestDAO().requestCandidateChangeRequestForAccountChange(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected Account loadAccount(BankUserContext userContext, String newAccountId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountDAO().load(newAccountId, options);
 	}
 	
 	protected Account loadAccountWithName(BankUserContext userContext, String newName, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountDAO().loadByName(newName, options);
 	}
 	
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BankUserContext userContext, String accountChangeId, int accountChangeVersion) throws Exception {
		//deleteInternal(userContext, accountChangeId, accountChangeVersion);		
	}
	protected void deleteInternal(BankUserContext userContext,
			String accountChangeId, int accountChangeVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountChangeDAO().delete(accountChangeId, accountChangeVersion);
	}
	
	public AccountChange forgetByAll(BankUserContext userContext, String accountChangeId, int accountChangeVersion) throws Exception {
		return forgetByAllInternal(userContext, accountChangeId, accountChangeVersion);		
	}
	protected AccountChange forgetByAllInternal(BankUserContext userContext,
			String accountChangeId, int accountChangeVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountChangeDAO().disconnectFromAll(accountChangeId, accountChangeVersion);
	}
	

	
	public int deleteAll(BankUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountChangeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BankUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAccountChangeDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BankUserContext userContext, AccountChange newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


