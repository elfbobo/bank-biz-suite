package com.doublechain.bank.changerequesttype;
import com.doublechain.bank.BaseForm;
import com.doublechain.bank.genericform.GenericForm;
import com.doublechain.bank.formfield.FormField;
import com.doublechain.bank.formaction.FormAction;
import com.doublechain.bank.formmessage.FormMessage;
import com.doublechain.bank.formfieldmessage.FormFieldMessage;



public class ChangeRequestTypeForm extends BaseForm {
	
	
	public ChangeRequestTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ChangeRequestTypeForm changeRequestTypeIdField(String parameterName, String initValue){
		FormField field = idFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm changeRequestTypeIdField(String initValue){
		return changeRequestTypeIdField("changeRequestTypeId",initValue);
	}
	public ChangeRequestTypeForm changeRequestTypeIdField(){
		return changeRequestTypeIdField("changeRequestTypeId","");
	}


	public ChangeRequestTypeForm nameField(String parameterName, String initValue){
		FormField field = nameFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ChangeRequestTypeForm nameField(){
		return nameField("name","");
	}


	public ChangeRequestTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public ChangeRequestTypeForm codeField(){
		return codeField("code","");
	}


	public ChangeRequestTypeForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ChangeRequestTypeForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ChangeRequestTypeForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestTypeForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ChangeRequestTypeForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ChangeRequestTypeForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestTypeForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ChangeRequestTypeForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ChangeRequestTypeForm foundedFieldOfPlatform(String parameterName, String initValue){
		FormField field =  foundedFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestTypeForm foundedFieldOfPlatform(String initValue){
		return foundedFieldOfPlatform("founded",initValue);
	}
	public ChangeRequestTypeForm foundedFieldOfPlatform(){
		return foundedFieldOfPlatform("founded","");
	}

	



	public ChangeRequestTypeForm changeRequestIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm changeRequestIdFieldForChangeRequest(String initValue){
		return changeRequestIdFieldForChangeRequest("changeRequestId",initValue);
	}
	public ChangeRequestTypeForm changeRequestIdFieldForChangeRequest(){
		return changeRequestIdFieldForChangeRequest("changeRequestId","");
	}


	public ChangeRequestTypeForm nameFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm nameFieldForChangeRequest(String initValue){
		return nameFieldForChangeRequest("name",initValue);
	}
	public ChangeRequestTypeForm nameFieldForChangeRequest(){
		return nameFieldForChangeRequest("name","");
	}


	public ChangeRequestTypeForm createTimeFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm createTimeFieldForChangeRequest(String initValue){
		return createTimeFieldForChangeRequest("createTime",initValue);
	}
	public ChangeRequestTypeForm createTimeFieldForChangeRequest(){
		return createTimeFieldForChangeRequest("createTime","");
	}


	public ChangeRequestTypeForm remoteIpFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm remoteIpFieldForChangeRequest(String initValue){
		return remoteIpFieldForChangeRequest("remoteIp",initValue);
	}
	public ChangeRequestTypeForm remoteIpFieldForChangeRequest(){
		return remoteIpFieldForChangeRequest("remoteIp","");
	}


	public ChangeRequestTypeForm requestTypeIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm requestTypeIdFieldForChangeRequest(String initValue){
		return requestTypeIdFieldForChangeRequest("requestTypeId",initValue);
	}
	public ChangeRequestTypeForm requestTypeIdFieldForChangeRequest(){
		return requestTypeIdFieldForChangeRequest("requestTypeId","");
	}


	public ChangeRequestTypeForm platformIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm platformIdFieldForChangeRequest(String initValue){
		return platformIdFieldForChangeRequest("platformId",initValue);
	}
	public ChangeRequestTypeForm platformIdFieldForChangeRequest(){
		return platformIdFieldForChangeRequest("platformId","");
	}

	

	
 	public ChangeRequestTypeForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/changeRequestTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public ChangeRequestTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


