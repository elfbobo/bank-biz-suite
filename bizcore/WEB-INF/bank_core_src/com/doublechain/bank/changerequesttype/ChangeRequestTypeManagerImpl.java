
package com.doublechain.bank.changerequesttype;

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
import com.doublechain.bank.platform.Platform;

import com.doublechain.bank.platform.CandidatePlatform;

import com.doublechain.bank.changerequesttype.ChangeRequestType;
import com.doublechain.bank.platform.Platform;






public class ChangeRequestTypeManagerImpl extends CustomBankCheckerManager implements ChangeRequestTypeManager {
	
	private static final String SERVICE_TYPE = "ChangeRequestType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ChangeRequestTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ChangeRequestTypeManagerException(message);

	}
	
	

 	protected ChangeRequestType saveChangeRequestType(BankUserContext userContext, ChangeRequestType changeRequestType, String [] tokensExpr) throws Exception{	
 		//return getChangeRequestTypeDAO().save(changeRequestType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveChangeRequestType(userContext, changeRequestType, tokens);
 	}
 	
 	protected ChangeRequestType saveChangeRequestTypeDetail(BankUserContext userContext, ChangeRequestType changeRequestType) throws Exception{	

 		
 		return saveChangeRequestType(userContext, changeRequestType, allTokens());
 	}
 	
 	public ChangeRequestType loadChangeRequestType(BankUserContext userContext, String changeRequestTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ChangeRequestTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ChangeRequestType changeRequestType = loadChangeRequestType( userContext, changeRequestTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,changeRequestType, tokens);
 	}
 	
 	
 	 public ChangeRequestType searchChangeRequestType(BankUserContext userContext, String changeRequestTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ChangeRequestTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ChangeRequestType changeRequestType = loadChangeRequestType( userContext, changeRequestTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,changeRequestType, tokens);
 	}
 	
 	

 	protected ChangeRequestType present(BankUserContext userContext, ChangeRequestType changeRequestType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,changeRequestType,tokens);
		
		
		ChangeRequestType  changeRequestTypeToPresent = userContext.getDAOGroup().getChangeRequestTypeDAO().present(changeRequestType, tokens);
		
		List<BaseEntity> entityListToNaming = changeRequestTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getChangeRequestTypeDAO().alias(entityListToNaming);
		
		return  changeRequestTypeToPresent;
		
		
	}
 
 	
 	
 	public ChangeRequestType loadChangeRequestTypeDetail(BankUserContext userContext, String changeRequestTypeId) throws Exception{	
 		ChangeRequestType changeRequestType = loadChangeRequestType( userContext, changeRequestTypeId, allTokens());
 		return present(userContext,changeRequestType, allTokens());
		
 	}
 	
 	public Object view(BankUserContext userContext, String changeRequestTypeId) throws Exception{	
 		ChangeRequestType changeRequestType = loadChangeRequestType( userContext, changeRequestTypeId, viewTokens());
 		return present(userContext,changeRequestType, allTokens());
		
 	}
 	protected ChangeRequestType saveChangeRequestType(BankUserContext userContext, ChangeRequestType changeRequestType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getChangeRequestTypeDAO().save(changeRequestType, tokens);
 	}
 	protected ChangeRequestType loadChangeRequestType(BankUserContext userContext, String changeRequestTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ChangeRequestTypeManagerException.class);

 
 		return userContext.getDAOGroup().getChangeRequestTypeDAO().load(changeRequestTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BankUserContext userContext, ChangeRequestType changeRequestType, Map<String, Object> tokens){
		super.addActions(userContext, changeRequestType, tokens);
		
		addAction(userContext, changeRequestType, tokens,"@create","createChangeRequestType","createChangeRequestType/","main","primary");
		addAction(userContext, changeRequestType, tokens,"@update","updateChangeRequestType","updateChangeRequestType/"+changeRequestType.getId()+"/","main","primary");
		addAction(userContext, changeRequestType, tokens,"@copy","cloneChangeRequestType","cloneChangeRequestType/"+changeRequestType.getId()+"/","main","primary");
		
		addAction(userContext, changeRequestType, tokens,"change_request_type.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+changeRequestType.getId()+"/","main","primary");
		addAction(userContext, changeRequestType, tokens,"change_request_type.addChangeRequest","addChangeRequest","addChangeRequest/"+changeRequestType.getId()+"/","changeRequestList","primary");
		addAction(userContext, changeRequestType, tokens,"change_request_type.removeChangeRequest","removeChangeRequest","removeChangeRequest/"+changeRequestType.getId()+"/","changeRequestList","primary");
		addAction(userContext, changeRequestType, tokens,"change_request_type.updateChangeRequest","updateChangeRequest","updateChangeRequest/"+changeRequestType.getId()+"/","changeRequestList","primary");
		addAction(userContext, changeRequestType, tokens,"change_request_type.copyChangeRequestFrom","copyChangeRequestFrom","copyChangeRequestFrom/"+changeRequestType.getId()+"/","changeRequestList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BankUserContext userContext, ChangeRequestType changeRequestType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ChangeRequestType createChangeRequestType(BankUserContext userContext,String name, String code, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfChangeRequestType(name);
		userContext.getChecker().checkCodeOfChangeRequestType(code);
	
		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);


		ChangeRequestType changeRequestType=createNewChangeRequestType();	

		changeRequestType.setName(name);
		changeRequestType.setCode(code);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		changeRequestType.setPlatform(platform);
		
		

		changeRequestType = saveChangeRequestType(userContext, changeRequestType, emptyOptions());
		
		onNewInstanceCreated(userContext, changeRequestType);
		return changeRequestType;

		
	}
	protected ChangeRequestType createNewChangeRequestType() 
	{
		
		return new ChangeRequestType();		
	}
	
	protected void checkParamsForUpdatingChangeRequestType(BankUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);
		userContext.getChecker().checkVersionOfChangeRequestType( changeRequestTypeVersion);
		

		if(ChangeRequestType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfChangeRequestType(parseString(newValueExpr));
		}
		if(ChangeRequestType.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfChangeRequestType(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
	
		
	}
	
	
	
	public ChangeRequestType clone(BankUserContext userContext, String fromChangeRequestTypeId) throws Exception{
		
		return userContext.getDAOGroup().getChangeRequestTypeDAO().clone(fromChangeRequestTypeId, this.allTokens());
	}
	
	public ChangeRequestType internalSaveChangeRequestType(BankUserContext userContext, ChangeRequestType changeRequestType) throws Exception 
	{
		return internalSaveChangeRequestType(userContext, changeRequestType, allTokens());

	}
	public ChangeRequestType internalSaveChangeRequestType(BankUserContext userContext, ChangeRequestType changeRequestType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingChangeRequestType(userContext, changeRequestTypeId, changeRequestTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(changeRequestType){ 
			//will be good when the changeRequestType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequestType.
			if (changeRequestType.isChanged()){
			
			}
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, options);
			return changeRequestType;
			
		}

	}
	
	public ChangeRequestType updateChangeRequestType(BankUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChangeRequestType(userContext, changeRequestTypeId, changeRequestTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		if(changeRequestType.getVersion() != changeRequestTypeVersion){
			String message = "The target version("+changeRequestType.getVersion()+") is not equals to version("+changeRequestTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(changeRequestType){ 
			//will be good when the changeRequestType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequestType.
			
			changeRequestType.changeProperty(property, newValueExpr);
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().done());
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
			//return saveChangeRequestType(userContext, changeRequestType, tokens().done());
		}

	}
	
	public ChangeRequestType updateChangeRequestTypeProperty(BankUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChangeRequestType(userContext, changeRequestTypeId, changeRequestTypeVersion, property, newValueExpr, tokensExpr);
		
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		if(changeRequestType.getVersion() != changeRequestTypeVersion){
			String message = "The target version("+changeRequestType.getVersion()+") is not equals to version("+changeRequestTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(changeRequestType){ 
			//will be good when the changeRequestType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequestType.
			
			changeRequestType.changeProperty(property, newValueExpr);
			
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().done());
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
			//return saveChangeRequestType(userContext, changeRequestType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ChangeRequestTypeTokens tokens(){
		return ChangeRequestTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ChangeRequestTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortChangeRequestListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ChangeRequestTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(BankUserContext userContext, String changeRequestTypeId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
 		
 	}
 	public ChangeRequestType transferToAnotherPlatform(BankUserContext userContext, String changeRequestTypeId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, changeRequestTypeId,anotherPlatformId);
 
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());	
		synchronized(changeRequestType){
			//will be good when the changeRequestType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			changeRequestType.updatePlatform(platform);		
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, emptyOptions());
			
			return present(userContext,changeRequestType, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForChangeRequestType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(BankUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BankUserContext userContext, String changeRequestTypeId, int changeRequestTypeVersion) throws Exception {
		//deleteInternal(userContext, changeRequestTypeId, changeRequestTypeVersion);		
	}
	protected void deleteInternal(BankUserContext userContext,
			String changeRequestTypeId, int changeRequestTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getChangeRequestTypeDAO().delete(changeRequestTypeId, changeRequestTypeVersion);
	}
	
	public ChangeRequestType forgetByAll(BankUserContext userContext, String changeRequestTypeId, int changeRequestTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, changeRequestTypeId, changeRequestTypeVersion);		
	}
	protected ChangeRequestType forgetByAllInternal(BankUserContext userContext,
			String changeRequestTypeId, int changeRequestTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getChangeRequestTypeDAO().disconnectFromAll(changeRequestTypeId, changeRequestTypeVersion);
	}
	

	
	public int deleteAll(BankUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ChangeRequestTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BankUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getChangeRequestTypeDAO().deleteAll();
	}


	//disconnect ChangeRequestType with platform in ChangeRequest
	protected ChangeRequestType breakWithChangeRequestByPlatform(BankUserContext userContext, String changeRequestTypeId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());

			synchronized(changeRequestType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getChangeRequestTypeDAO().planToRemoveChangeRequestListWithPlatform(changeRequestType, platformId, this.emptyOptions());

				changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
				return changeRequestType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingChangeRequest(BankUserContext userContext, String changeRequestTypeId, String name, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);

		
		userContext.getChecker().checkNameOfChangeRequest(name);
		
		userContext.getChecker().checkPlatformIdOfChangeRequest(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);

	
	}
	public  ChangeRequestType addChangeRequest(BankUserContext userContext, String changeRequestTypeId, String name, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChangeRequest(userContext,changeRequestTypeId,name, platformId,tokensExpr);
		
		ChangeRequest changeRequest = createChangeRequest(userContext,name, platformId);
		
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		synchronized(changeRequestType){ 
			//Will be good when the changeRequestType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequestType.addChangeRequest( changeRequest );		
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
			
			userContext.getManagerGroup().getChangeRequestManager().onNewInstanceCreated(userContext, changeRequest);
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChangeRequestProperties(BankUserContext userContext, String changeRequestTypeId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);
		userContext.getChecker().checkIdOfChangeRequest(id);
		
		userContext.getChecker().checkNameOfChangeRequest( name);

		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
		
	}
	public  ChangeRequestType updateChangeRequestProperties(BankUserContext userContext, String changeRequestTypeId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChangeRequestProperties(userContext,changeRequestTypeId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChangeRequestListList()
				.searchChangeRequestListWith(ChangeRequest.ID_PROPERTY, "is", id).done();
		
		ChangeRequestType changeRequestTypeToUpdate = loadChangeRequestType(userContext, changeRequestTypeId, options);
		
		if(changeRequestTypeToUpdate.getChangeRequestList().isEmpty()){
			throw new ChangeRequestTypeManagerException("ChangeRequest is NOT FOUND with id: '"+id+"'");
		}
		
		ChangeRequest item = changeRequestTypeToUpdate.getChangeRequestList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingChangeRequest(userContext,changeRequestTypeId,name, code, used,tokensExpr);
		ChangeRequestType changeRequestType = saveChangeRequestType(userContext, changeRequestTypeToUpdate, tokens().withChangeRequestList().done());
		synchronized(changeRequestType){ 
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChangeRequest createChangeRequest(BankUserContext userContext, String name, String platformId) throws Exception{

		ChangeRequest changeRequest = new ChangeRequest();
		
		
		changeRequest.setName(name);		
		changeRequest.setCreateTime(userContext.now());		
		changeRequest.setRemoteIp(userContext.getRemoteIP());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		changeRequest.setPlatform(platform);
	
		
		return changeRequest;
	
		
	}
	
	protected ChangeRequest createIndexedChangeRequest(String id, int version){

		ChangeRequest changeRequest = new ChangeRequest();
		changeRequest.setId(id);
		changeRequest.setVersion(version);
		return changeRequest;			
		
	}
	
	protected void checkParamsForRemovingChangeRequestList(BankUserContext userContext, String changeRequestTypeId, 
			String changeRequestIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);
		for(String changeRequestIdItem: changeRequestIds){
			userContext.getChecker().checkIdOfChangeRequest(changeRequestIdItem);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
		
	}
	public  ChangeRequestType removeChangeRequestList(BankUserContext userContext, String changeRequestTypeId, 
			String changeRequestIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChangeRequestList(userContext, changeRequestTypeId,  changeRequestIds, tokensExpr);
			
			
			ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
			synchronized(changeRequestType){ 
				//Will be good when the changeRequestType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getChangeRequestTypeDAO().planToRemoveChangeRequestList(changeRequestType, changeRequestIds, allTokens());
				changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
				deleteRelationListInGraph(userContext, changeRequestType.getChangeRequestList());
				return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChangeRequest(BankUserContext userContext, String changeRequestTypeId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfChangeRequestType( changeRequestTypeId);
		userContext.getChecker().checkIdOfChangeRequest(changeRequestId);
		userContext.getChecker().checkVersionOfChangeRequest(changeRequestVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
	
	}
	public  ChangeRequestType removeChangeRequest(BankUserContext userContext, String changeRequestTypeId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChangeRequest(userContext,changeRequestTypeId, changeRequestId, changeRequestVersion,tokensExpr);
		
		ChangeRequest changeRequest = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		synchronized(changeRequestType){ 
			//Will be good when the changeRequestType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequestType.removeChangeRequest( changeRequest );		
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
			deleteRelationInGraph(userContext, changeRequest);
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChangeRequest(BankUserContext userContext, String changeRequestTypeId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfChangeRequestType( changeRequestTypeId);
		userContext.getChecker().checkIdOfChangeRequest(changeRequestId);
		userContext.getChecker().checkVersionOfChangeRequest(changeRequestVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
	
	}
	public  ChangeRequestType copyChangeRequestFrom(BankUserContext userContext, String changeRequestTypeId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChangeRequest(userContext,changeRequestTypeId, changeRequestId, changeRequestVersion,tokensExpr);
		
		ChangeRequest changeRequest = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		synchronized(changeRequestType){ 
			//Will be good when the changeRequestType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			
			changeRequestType.copyChangeRequestFrom( changeRequest );		
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
			
			userContext.getManagerGroup().getChangeRequestManager().onNewInstanceCreated(userContext, (ChangeRequest)changeRequestType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChangeRequest(BankUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfChangeRequestType(changeRequestTypeId);
		userContext.getChecker().checkIdOfChangeRequest(changeRequestId);
		userContext.getChecker().checkVersionOfChangeRequest(changeRequestVersion);
		

		if(ChangeRequest.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfChangeRequest(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
	
	}
	
	public  ChangeRequestType updateChangeRequest(BankUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChangeRequest(userContext, changeRequestTypeId, changeRequestId, changeRequestVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChangeRequestList().searchChangeRequestListWith(ChangeRequest.ID_PROPERTY, "eq", changeRequestId).done();
		
		
		
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, loadTokens);
		
		synchronized(changeRequestType){ 
			//Will be good when the changeRequestType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//changeRequestType.removeChangeRequest( changeRequest );	
			//make changes to AcceleraterAccount.
			ChangeRequest changeRequestIndex = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		
			ChangeRequest changeRequest = changeRequestType.findTheChangeRequest(changeRequestIndex);
			if(changeRequest == null){
				throw new ChangeRequestTypeManagerException(changeRequest+" is NOT FOUND" );
			}
			
			changeRequest.changeProperty(property, newValueExpr);
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BankUserContext userContext, ChangeRequestType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


