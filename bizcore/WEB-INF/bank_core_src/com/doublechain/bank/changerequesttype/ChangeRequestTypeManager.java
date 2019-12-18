
package com.doublechain.bank.changerequesttype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechain.bank.BankUserContext;
import com.doublechain.bank.BaseEntity;
import com.doublechain.bank.SmartList;

public interface ChangeRequestTypeManager{

		

	public ChangeRequestType createChangeRequestType(BankUserContext userContext, String name, String code, String platformId) throws Exception;	
	public ChangeRequestType updateChangeRequestType(BankUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ChangeRequestType loadChangeRequestType(BankUserContext userContext, String changeRequestTypeId, String [] tokensExpr) throws Exception;
	public ChangeRequestType internalSaveChangeRequestType(BankUserContext userContext, ChangeRequestType changeRequestType) throws Exception;
	public ChangeRequestType internalSaveChangeRequestType(BankUserContext userContext, ChangeRequestType changeRequestType,Map<String,Object>option) throws Exception;
	
	public ChangeRequestType transferToAnotherPlatform(BankUserContext userContext, String changeRequestTypeId, String anotherPlatformId)  throws Exception;
 

	public void delete(BankUserContext userContext, String changeRequestTypeId, int version) throws Exception;
	public int deleteAll(BankUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BankUserContext userContext, ChangeRequestType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ChangeRequestManager getChangeRequestManager(BankUserContext userContext, String changeRequestTypeId, String name, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  ChangeRequestType addChangeRequest(BankUserContext userContext, String changeRequestTypeId, String name, String platformId , String [] tokensExpr)  throws Exception;
	public  ChangeRequestType removeChangeRequest(BankUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion,String [] tokensExpr)  throws Exception;
	public  ChangeRequestType updateChangeRequest(BankUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


