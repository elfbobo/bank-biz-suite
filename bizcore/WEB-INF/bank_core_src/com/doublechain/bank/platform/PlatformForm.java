package com.doublechain.bank.platform;
import com.doublechain.bank.BaseForm;
import com.doublechain.bank.genericform.GenericForm;
import com.doublechain.bank.formfield.FormField;
import com.doublechain.bank.formaction.FormAction;
import com.doublechain.bank.formmessage.FormMessage;
import com.doublechain.bank.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public PlatformForm foundedField(){
		return foundedField("founded","");
	}

	
	

	



	public PlatformForm changeRequestTypeIdFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  idFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm changeRequestTypeIdFieldForChangeRequestType(String initValue){
		return changeRequestTypeIdFieldForChangeRequestType("changeRequestTypeId",initValue);
	}
	public PlatformForm changeRequestTypeIdFieldForChangeRequestType(){
		return changeRequestTypeIdFieldForChangeRequestType("changeRequestTypeId","");
	}


	public PlatformForm nameFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  nameFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForChangeRequestType(String initValue){
		return nameFieldForChangeRequestType("name",initValue);
	}
	public PlatformForm nameFieldForChangeRequestType(){
		return nameFieldForChangeRequestType("name","");
	}


	public PlatformForm codeFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  codeFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm codeFieldForChangeRequestType(String initValue){
		return codeFieldForChangeRequestType("code",initValue);
	}
	public PlatformForm codeFieldForChangeRequestType(){
		return codeFieldForChangeRequestType("code","");
	}


	public PlatformForm platformIdFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForChangeRequestType(String initValue){
		return platformIdFieldForChangeRequestType("platformId",initValue);
	}
	public PlatformForm platformIdFieldForChangeRequestType(){
		return platformIdFieldForChangeRequestType("platformId","");
	}


	public PlatformForm changeRequestIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm changeRequestIdFieldForChangeRequest(String initValue){
		return changeRequestIdFieldForChangeRequest("changeRequestId",initValue);
	}
	public PlatformForm changeRequestIdFieldForChangeRequest(){
		return changeRequestIdFieldForChangeRequest("changeRequestId","");
	}


	public PlatformForm nameFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForChangeRequest(String initValue){
		return nameFieldForChangeRequest("name",initValue);
	}
	public PlatformForm nameFieldForChangeRequest(){
		return nameFieldForChangeRequest("name","");
	}


	public PlatformForm createTimeFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForChangeRequest(String initValue){
		return createTimeFieldForChangeRequest("createTime",initValue);
	}
	public PlatformForm createTimeFieldForChangeRequest(){
		return createTimeFieldForChangeRequest("createTime","");
	}


	public PlatformForm remoteIpFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remoteIpFieldForChangeRequest(String initValue){
		return remoteIpFieldForChangeRequest("remoteIp",initValue);
	}
	public PlatformForm remoteIpFieldForChangeRequest(){
		return remoteIpFieldForChangeRequest("remoteIp","");
	}


	public PlatformForm requestTypeIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm requestTypeIdFieldForChangeRequest(String initValue){
		return requestTypeIdFieldForChangeRequest("requestTypeId",initValue);
	}
	public PlatformForm requestTypeIdFieldForChangeRequest(){
		return requestTypeIdFieldForChangeRequest("requestTypeId","");
	}


	public PlatformForm platformIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForChangeRequest(String initValue){
		return platformIdFieldForChangeRequest("platformId",initValue);
	}
	public PlatformForm platformIdFieldForChangeRequest(){
		return platformIdFieldForChangeRequest("platformId","");
	}


	public PlatformForm accountIdFieldForAccount(String parameterName, String initValue){
		FormField field =  idFromAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm accountIdFieldForAccount(String initValue){
		return accountIdFieldForAccount("accountId",initValue);
	}
	public PlatformForm accountIdFieldForAccount(){
		return accountIdFieldForAccount("accountId","");
	}


	public PlatformForm nameFieldForAccount(String parameterName, String initValue){
		FormField field =  nameFromAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForAccount(String initValue){
		return nameFieldForAccount("name",initValue);
	}
	public PlatformForm nameFieldForAccount(){
		return nameFieldForAccount("name","");
	}


	public PlatformForm balanceFieldForAccount(String parameterName, String initValue){
		FormField field =  balanceFromAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm balanceFieldForAccount(String initValue){
		return balanceFieldForAccount("balance",initValue);
	}
	public PlatformForm balanceFieldForAccount(){
		return balanceFieldForAccount("balance","");
	}


	public PlatformForm createTimeFieldForAccount(String parameterName, String initValue){
		FormField field =  createTimeFromAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForAccount(String initValue){
		return createTimeFieldForAccount("createTime",initValue);
	}
	public PlatformForm createTimeFieldForAccount(){
		return createTimeFieldForAccount("createTime","");
	}


	public PlatformForm updateTimeFieldForAccount(String parameterName, String initValue){
		FormField field =  updateTimeFromAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm updateTimeFieldForAccount(String initValue){
		return updateTimeFieldForAccount("updateTime",initValue);
	}
	public PlatformForm updateTimeFieldForAccount(){
		return updateTimeFieldForAccount("updateTime","");
	}


	public PlatformForm platformIdFieldForAccount(String parameterName, String initValue){
		FormField field =  platformIdFromAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForAccount(String initValue){
		return platformIdFieldForAccount("platformId",initValue);
	}
	public PlatformForm platformIdFieldForAccount(){
		return platformIdFieldForAccount("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


