
package com.doublechain.bank.candidateelement;

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

import com.doublechain.bank.candidatecontainer.CandidateContainer;

import com.doublechain.bank.candidatecontainer.CandidateCandidateContainer;







public class CandidateElementManagerImpl extends CustomBankCheckerManager implements CandidateElementManager {
	
	private static final String SERVICE_TYPE = "CandidateElement";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CandidateElementManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CandidateElementManagerException(message);

	}
	
	

 	protected CandidateElement saveCandidateElement(BankUserContext userContext, CandidateElement candidateElement, String [] tokensExpr) throws Exception{	
 		//return getCandidateElementDAO().save(candidateElement, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCandidateElement(userContext, candidateElement, tokens);
 	}
 	
 	protected CandidateElement saveCandidateElementDetail(BankUserContext userContext, CandidateElement candidateElement) throws Exception{	

 		
 		return saveCandidateElement(userContext, candidateElement, allTokens());
 	}
 	
 	public CandidateElement loadCandidateElement(BankUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCandidateElement(candidateElementId);
		userContext.getChecker().throwExceptionIfHasErrors( CandidateElementManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateElement, tokens);
 	}
 	
 	
 	 public CandidateElement searchCandidateElement(BankUserContext userContext, String candidateElementId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCandidateElement(candidateElementId);
		userContext.getChecker().throwExceptionIfHasErrors( CandidateElementManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateElement, tokens);
 	}
 	
 	

 	protected CandidateElement present(BankUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,candidateElement,tokens);
		
		
		CandidateElement  candidateElementToPresent = userContext.getDAOGroup().getCandidateElementDAO().present(candidateElement, tokens);
		
		List<BaseEntity> entityListToNaming = candidateElementToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getCandidateElementDAO().alias(entityListToNaming);
		
		return  candidateElementToPresent;
		
		
	}
 
 	
 	
 	public CandidateElement loadCandidateElementDetail(BankUserContext userContext, String candidateElementId) throws Exception{	
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, allTokens());
 		return present(userContext,candidateElement, allTokens());
		
 	}
 	
 	public Object view(BankUserContext userContext, String candidateElementId) throws Exception{	
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, viewTokens());
 		return present(userContext,candidateElement, allTokens());
		
 	}
 	protected CandidateElement saveCandidateElement(BankUserContext userContext, CandidateElement candidateElement, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getCandidateElementDAO().save(candidateElement, tokens);
 	}
 	protected CandidateElement loadCandidateElement(BankUserContext userContext, String candidateElementId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfCandidateElement(candidateElementId);
		userContext.getChecker().throwExceptionIfHasErrors( CandidateElementManagerException.class);

 
 		return userContext.getDAOGroup().getCandidateElementDAO().load(candidateElementId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BankUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens){
		super.addActions(userContext, candidateElement, tokens);
		
		addAction(userContext, candidateElement, tokens,"@create","createCandidateElement","createCandidateElement/","main","primary");
		addAction(userContext, candidateElement, tokens,"@update","updateCandidateElement","updateCandidateElement/"+candidateElement.getId()+"/","main","primary");
		addAction(userContext, candidateElement, tokens,"@copy","cloneCandidateElement","cloneCandidateElement/"+candidateElement.getId()+"/","main","primary");
		
		addAction(userContext, candidateElement, tokens,"candidate_element.transfer_to_container","transferToAnotherContainer","transferToAnotherContainer/"+candidateElement.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BankUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CandidateElement createCandidateElement(BankUserContext userContext,String name, String type, String image, String containerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfCandidateElement(name);
		userContext.getChecker().checkTypeOfCandidateElement(type);
		userContext.getChecker().checkImageOfCandidateElement(image);
	
		userContext.getChecker().throwExceptionIfHasErrors(CandidateElementManagerException.class);


		CandidateElement candidateElement=createNewCandidateElement();	

		candidateElement.setName(name);
		candidateElement.setType(type);
		candidateElement.setImage(image);
			
		CandidateContainer container = loadCandidateContainer(userContext, containerId,emptyOptions());
		candidateElement.setContainer(container);
		
		

		candidateElement = saveCandidateElement(userContext, candidateElement, emptyOptions());
		
		onNewInstanceCreated(userContext, candidateElement);
		return candidateElement;

		
	}
	protected CandidateElement createNewCandidateElement() 
	{
		
		return new CandidateElement();		
	}
	
	protected void checkParamsForUpdatingCandidateElement(BankUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfCandidateElement(candidateElementId);
		userContext.getChecker().checkVersionOfCandidateElement( candidateElementVersion);
		

		if(CandidateElement.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCandidateElement(parseString(newValueExpr));
		}
		if(CandidateElement.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfCandidateElement(parseString(newValueExpr));
		}
		if(CandidateElement.IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkImageOfCandidateElement(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(CandidateElementManagerException.class);
	
		
	}
	
	
	
	public CandidateElement clone(BankUserContext userContext, String fromCandidateElementId) throws Exception{
		
		return userContext.getDAOGroup().getCandidateElementDAO().clone(fromCandidateElementId, this.allTokens());
	}
	
	public CandidateElement internalSaveCandidateElement(BankUserContext userContext, CandidateElement candidateElement) throws Exception 
	{
		return internalSaveCandidateElement(userContext, candidateElement, allTokens());

	}
	public CandidateElement internalSaveCandidateElement(BankUserContext userContext, CandidateElement candidateElement, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(candidateElement){ 
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.
			if (candidateElement.isChanged()){
			
			}
			candidateElement = saveCandidateElement(userContext, candidateElement, options);
			return candidateElement;
			
		}

	}
	
	public CandidateElement updateCandidateElement(BankUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);
		
		
		
		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());
		if(candidateElement.getVersion() != candidateElementVersion){
			String message = "The target version("+candidateElement.getVersion()+") is not equals to version("+candidateElementVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateElement){ 
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.
			
			candidateElement.changeProperty(property, newValueExpr);
			candidateElement = saveCandidateElement(userContext, candidateElement, tokens().done());
			return present(userContext,candidateElement, mergedAllTokens(tokensExpr));
			//return saveCandidateElement(userContext, candidateElement, tokens().done());
		}

	}
	
	public CandidateElement updateCandidateElementProperty(BankUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);
		
		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());
		if(candidateElement.getVersion() != candidateElementVersion){
			String message = "The target version("+candidateElement.getVersion()+") is not equals to version("+candidateElementVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateElement){ 
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.
			
			candidateElement.changeProperty(property, newValueExpr);
			
			candidateElement = saveCandidateElement(userContext, candidateElement, tokens().done());
			return present(userContext,candidateElement, mergedAllTokens(tokensExpr));
			//return saveCandidateElement(userContext, candidateElement, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CandidateElementTokens tokens(){
		return CandidateElementTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CandidateElementTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CandidateElementTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherContainer(BankUserContext userContext, String candidateElementId, String anotherContainerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCandidateElement(candidateElementId);
 		userContext.getChecker().checkIdOfCandidateContainer(anotherContainerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CandidateElementManagerException.class);
 		
 	}
 	public CandidateElement transferToAnotherContainer(BankUserContext userContext, String candidateElementId, String anotherContainerId) throws Exception
 	{
 		checkParamsForTransferingAnotherContainer(userContext, candidateElementId,anotherContainerId);
 
		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());	
		synchronized(candidateElement){
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CandidateContainer container = loadCandidateContainer(userContext, anotherContainerId, emptyOptions());		
			candidateElement.updateContainer(container);		
			candidateElement = saveCandidateElement(userContext, candidateElement, emptyOptions());
			
			return present(userContext,candidateElement, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateCandidateContainer requestCandidateContainer(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCandidateContainer result = new CandidateCandidateContainer();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<CandidateContainer> candidateList = userContext.getDAOGroup().getCandidateContainerDAO().requestCandidateCandidateContainerForCandidateElement(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected CandidateContainer loadCandidateContainer(BankUserContext userContext, String newContainerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getCandidateContainerDAO().load(newContainerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BankUserContext userContext, String candidateElementId, int candidateElementVersion) throws Exception {
		//deleteInternal(userContext, candidateElementId, candidateElementVersion);		
	}
	protected void deleteInternal(BankUserContext userContext,
			String candidateElementId, int candidateElementVersion) throws Exception{
			
		userContext.getDAOGroup().getCandidateElementDAO().delete(candidateElementId, candidateElementVersion);
	}
	
	public CandidateElement forgetByAll(BankUserContext userContext, String candidateElementId, int candidateElementVersion) throws Exception {
		return forgetByAllInternal(userContext, candidateElementId, candidateElementVersion);		
	}
	protected CandidateElement forgetByAllInternal(BankUserContext userContext,
			String candidateElementId, int candidateElementVersion) throws Exception{
			
		return userContext.getDAOGroup().getCandidateElementDAO().disconnectFromAll(candidateElementId, candidateElementVersion);
	}
	

	
	public int deleteAll(BankUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CandidateElementManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BankUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getCandidateElementDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BankUserContext userContext, CandidateElement newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}







