
package com.doublechain.bank.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechain.bank.BankUserContext;
import com.doublechain.bank.BaseEntity;
import com.doublechain.bank.SmartList;

public interface QuickLinkManager{

		

	public QuickLink createQuickLink(BankUserContext userContext, String name, String icon, String imagePath, String linkTarget, String appId) throws Exception;	
	public QuickLink updateQuickLink(BankUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(BankUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(BankUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(BankUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;
	
	public QuickLink transferToAnotherApp(BankUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(BankUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(BankUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BankUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


