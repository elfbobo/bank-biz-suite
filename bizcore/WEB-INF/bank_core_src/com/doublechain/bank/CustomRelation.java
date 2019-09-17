
package com.doublechain.bank;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("ChangeRequest"                         , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Transaction"                           , BaseRelation.TRUST_CHAIN_ALL, "fromAccount");
		//replaceGenericRelation("Transaction"                           , BaseRelation.TRUST_CHAIN_ALL, "toAccount");
		//replaceGenericRelation("Transaction"                           , BaseRelation.TRUST_CHAIN_ALL, "changeRequest");
		//replaceGenericRelation("NameChangeEvent"                       , BaseRelation.TRUST_CHAIN_ALL, "account");
		//replaceGenericRelation("NameChangeEvent"                       , BaseRelation.TRUST_CHAIN_ALL, "changeRequest");
		//replaceGenericRelation("Account"                               , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("AccountChange"                         , BaseRelation.TRUST_CHAIN_ALL, "account");
		//replaceGenericRelation("AccountChange"                         , BaseRelation.TRUST_CHAIN_ALL, "changeRequest");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("QuickLink"                             , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("CandidateElement"                      , BaseRelation.TRUST_CHAIN_ALL, "container");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] changeRequestRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("ChangeRequest",changeRequestRelatedObjectNames);

		//String [] transactionRelatedObjectNames = {"from_account:Account","to_account:Account","change_request:ChangeRequest"};
		//replaceRelationIndex("Transaction",transactionRelatedObjectNames);

		//String [] nameChangeEventRelatedObjectNames = {"account:Account","change_request:ChangeRequest"};
		//replaceRelationIndex("NameChangeEvent",nameChangeEventRelatedObjectNames);

		//String [] accountRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Account",accountRelatedObjectNames);

		//String [] accountChangeRelatedObjectNames = {"account:Account","change_request:ChangeRequest"};
		//replaceRelationIndex("AccountChange",accountChangeRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] quickLinkRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("QuickLink",quickLinkRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] formMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormMessage",formMessageRelatedObjectNames);

		//String [] formFieldMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormFieldMessage",formFieldMessageRelatedObjectNames);

		//String [] formFieldRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormField",formFieldRelatedObjectNames);

		//String [] formActionRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormAction",formActionRelatedObjectNames);

		//String [] candidateElementRelatedObjectNames = {"container:CandidateContainer"};
		//replaceRelationIndex("CandidateElement",candidateElementRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}










