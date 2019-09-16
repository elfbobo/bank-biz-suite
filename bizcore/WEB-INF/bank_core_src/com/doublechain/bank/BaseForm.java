package com.doublechain.bank;

import com.doublechain.bank.genericform.GenericForm;
import com.doublechain.bank.formfield.FormField;
import com.doublechain.bank.formaction.FormAction;
import com.doublechain.bank.formmessage.FormMessage;
import com.doublechain.bank.formfieldmessage.FormFieldMessage;




public class BaseForm extends GenericForm{

	public FormField getFieldByParamterName(String parameterName){
        
        for(FormField field: this.getFormFieldList()){
            if(parameterName.equals(field.getParameterName())){
                return field;
            }
            
        }
        return null;
    }
	public BaseForm hideByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setType("hidden");
				break;
			}
			
		}
		return this;
	}
	public BaseForm disableByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setDisabled(true);
				break;
			}
			
		}
		return this;
	}
	public BaseForm setAllGroupNameTo(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			field.setFieldGroup(groupName);
		}
		return this;
		
	}
	
	public BaseForm disableByGroup(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(groupName.equals(field.getFieldGroup())){
				field.setDisabled(true);
				continue;
			}
			
		}
		return this;
		
	}
	
	public BaseForm setGroupNameByParamterName(String parameterName, String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setFieldGroup(groupName);
				break;
			}
			
		}
		return this;
		
	}


	protected FormField idFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("platform.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("platform.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField foundedFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Founded");
		field.setLocaleKey("platform.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Founded");
		return field;
	}

	protected FormField idFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("change_request.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("change_request.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField createTimeFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Create Time");
		field.setLocaleKey("change_request.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Create Time");
		return field;
	}

	protected FormField remoteIpFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Remote Ip");
		field.setLocaleKey("change_request.remote_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Remote Ip");
		return field;
	}

	protected FormField remoteIpFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("远程Ip");
		field.setLocaleKey("change_request.remote_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写远程Ip");
		return field;
	}

	protected FormField platformIdFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("change_request.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("transaction.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("transaction.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField fromAccountIdFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("From Account");
		field.setLocaleKey("transaction.from_account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Account");
		field.setRequired(true);
		field.setPlaceholder("请填写From Account");
		return field;
	}

	protected FormField toAccountIdFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("To Account");
		field.setLocaleKey("transaction.to_account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Account");
		field.setRequired(true);
		field.setPlaceholder("请填写To Account");
		return field;
	}

	protected FormField amountFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Amount");
		field.setLocaleKey("transaction.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写Amount");
		return field;
	}

	protected FormField typeFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Type");
		field.setLocaleKey("transaction.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Type");
		return field;
	}

	protected FormField changeRequestIdFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Change Request");
		field.setLocaleKey("transaction.change_request");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ChangeRequest");
		field.setRequired(true);
		field.setPlaceholder("请填写Change Request");
		return field;
	}

	protected FormField idFromNameChangeEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("name_change_event.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromNameChangeEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("name_change_event.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField accountIdFromNameChangeEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Account");
		field.setLocaleKey("name_change_event.account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Account");
		field.setRequired(true);
		field.setPlaceholder("请填写Account");
		return field;
	}

	protected FormField changeRequestIdFromNameChangeEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Change Request");
		field.setLocaleKey("name_change_event.change_request");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ChangeRequest");
		field.setRequired(true);
		field.setPlaceholder("请填写Change Request");
		return field;
	}

	protected FormField idFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("account.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("account.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField balanceFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Balance");
		field.setLocaleKey("account.balance");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写Balance");
		return field;
	}

	protected FormField createTimeFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Create Time");
		field.setLocaleKey("account.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Create Time");
		return field;
	}

	protected FormField updateTimeFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Update Time");
		field.setLocaleKey("account.update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Update Time");
		return field;
	}

	protected FormField platformIdFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("account.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("account_change.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("account_change.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField accountIdFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Account");
		field.setLocaleKey("account_change.account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Account");
		field.setRequired(true);
		field.setPlaceholder("请填写Account");
		return field;
	}

	protected FormField previousBalanceFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Previous Balance");
		field.setLocaleKey("account_change.previous_balance");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写Previous Balance");
		return field;
	}

	protected FormField typeFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Type");
		field.setLocaleKey("account_change.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Type");
		return field;
	}

	protected FormField amountFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Amount");
		field.setLocaleKey("account_change.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写Amount");
		return field;
	}

	protected FormField currentBalanceFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Current Balance");
		field.setLocaleKey("account_change.current_balance");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写Current Balance");
		return field;
	}

	protected FormField changeRequestIdFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Change Request");
		field.setLocaleKey("account_change.change_request");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ChangeRequest");
		field.setRequired(true);
		field.setPlaceholder("请填写Change Request");
		return field;
	}

	protected FormField idFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_domain.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("user_domain.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField idFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_white_list.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField userIdentityFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("User Identity");
		field.setLocaleKey("user_white_list.user_identity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写User Identity");
		return field;
	}

	protected FormField userSpecialFunctionsFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("User Special Functions");
		field.setLocaleKey("user_white_list.user_special_functions");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写User Special Functions");
		return field;
	}

	protected FormField domainIdFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Domain");
		field.setLocaleKey("user_white_list.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写Domain");
		return field;
	}

	protected FormField idFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("sec_user.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField loginFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Login");
		field.setLocaleKey("sec_user.login");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Login");
		return field;
	}

	protected FormField mobileFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Mobile");
		field.setLocaleKey("sec_user.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写Mobile");
		return field;
	}

	protected FormField emailFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Email");
		field.setLocaleKey("sec_user.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Email");
		return field;
	}

	protected FormField pwdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Pwd");
		field.setLocaleKey("sec_user.pwd");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("password");
		field.setRequired(true);
		field.setPlaceholder("请填写Pwd");
		return field;
	}

	protected FormField weixinOpenidFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Weixin Openid");
		field.setLocaleKey("sec_user.weixin_openid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Weixin Openid");
		return field;
	}

	protected FormField weixinAppidFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Weixin Appid");
		field.setLocaleKey("sec_user.weixin_appid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Weixin Appid");
		return field;
	}

	protected FormField accessTokenFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Access Token");
		field.setLocaleKey("sec_user.access_token");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Access Token");
		return field;
	}

	protected FormField verificationCodeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Verification Code");
		field.setLocaleKey("sec_user.verification_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Verification Code");
		return field;
	}

	protected FormField verificationCodeExpireFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Verification Code Expire");
		field.setLocaleKey("sec_user.verification_code_expire");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Verification Code Expire");
		return field;
	}

	protected FormField lastLoginTimeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Login Time");
		field.setLocaleKey("sec_user.last_login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Login Time");
		return field;
	}

	protected FormField domainIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Domain");
		field.setLocaleKey("sec_user.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写Domain");
		return field;
	}

	protected FormField blockingIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Blocking");
		field.setLocaleKey("sec_user.blocking");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUserBlocking");
		field.setRequired(true);
		field.setPlaceholder("请填写Blocking");
		return field;
	}

	protected FormField currentStatusFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Current Status");
		field.setLocaleKey("sec_user.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Current Status");
		return field;
	}

	protected FormField idFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("sec_user_blocking.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField whoFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Who");
		field.setLocaleKey("sec_user_blocking.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Who");
		return field;
	}

	protected FormField blockTimeFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Block Time");
		field.setLocaleKey("sec_user_blocking.block_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Block Time");
		return field;
	}

	protected FormField commentsFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Comments");
		field.setLocaleKey("sec_user_blocking.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Comments");
		return field;
	}

	protected FormField idFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_app.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("user_app.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField secUserIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Sec User");
		field.setLocaleKey("user_app.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写Sec User");
		return field;
	}

	protected FormField appIconFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App Icon");
		field.setLocaleKey("user_app.app_icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写App Icon");
		return field;
	}

	protected FormField fullAccessFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Full Access");
		field.setLocaleKey("user_app.full_access");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Full Access");
		return field;
	}

	protected FormField permissionFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Permission");
		field.setLocaleKey("user_app.permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Permission");
		return field;
	}

	protected FormField objectTypeFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Type");
		field.setLocaleKey("user_app.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Type");
		return field;
	}

	protected FormField objectIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Id");
		field.setLocaleKey("user_app.object_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Id");
		return field;
	}

	protected FormField locationFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Location");
		field.setLocaleKey("user_app.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Location");
		return field;
	}

	protected FormField idFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("quick_link.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("quick_link.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField iconFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Icon");
		field.setLocaleKey("quick_link.icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Icon");
		return field;
	}

	protected FormField imagePathFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Image Path");
		field.setLocaleKey("quick_link.image_path");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写Image Path");
		return field;
	}

	protected FormField linkTargetFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Link Target");
		field.setLocaleKey("quick_link.link_target");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Link Target");
		return field;
	}

	protected FormField createTimeFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Create Time");
		field.setLocaleKey("quick_link.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Create Time");
		return field;
	}

	protected FormField appIdFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App");
		field.setLocaleKey("quick_link.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写App");
		return field;
	}

	protected FormField idFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("list_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("list_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField internalNameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Internal Name");
		field.setLocaleKey("list_access.internal_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Internal Name");
		return field;
	}

	protected FormField readPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Read Permission");
		field.setLocaleKey("list_access.read_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Read Permission");
		return field;
	}

	protected FormField createPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Create Permission");
		field.setLocaleKey("list_access.create_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Create Permission");
		return field;
	}

	protected FormField deletePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Delete Permission");
		field.setLocaleKey("list_access.delete_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Delete Permission");
		return field;
	}

	protected FormField updatePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Update Permission");
		field.setLocaleKey("list_access.update_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Update Permission");
		return field;
	}

	protected FormField executionPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Execution Permission");
		field.setLocaleKey("list_access.execution_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Execution Permission");
		return field;
	}

	protected FormField appIdFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App");
		field.setLocaleKey("list_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写App");
		return field;
	}

	protected FormField idFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("object_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("object_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField objectTypeFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Type");
		field.setLocaleKey("object_access.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Type");
		return field;
	}

	protected FormField list1FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List1");
		field.setLocaleKey("object_access.list1");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List1");
		return field;
	}

	protected FormField list2FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List2");
		field.setLocaleKey("object_access.list2");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List2");
		return field;
	}

	protected FormField list3FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List3");
		field.setLocaleKey("object_access.list3");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List3");
		return field;
	}

	protected FormField list4FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List4");
		field.setLocaleKey("object_access.list4");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List4");
		return field;
	}

	protected FormField list5FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List5");
		field.setLocaleKey("object_access.list5");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List5");
		return field;
	}

	protected FormField list6FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List6");
		field.setLocaleKey("object_access.list6");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List6");
		return field;
	}

	protected FormField list7FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List7");
		field.setLocaleKey("object_access.list7");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List7");
		return field;
	}

	protected FormField list8FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List8");
		field.setLocaleKey("object_access.list8");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List8");
		return field;
	}

	protected FormField list9FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List9");
		field.setLocaleKey("object_access.list9");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List9");
		return field;
	}

	protected FormField appIdFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App");
		field.setLocaleKey("object_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写App");
		return field;
	}

	protected FormField idFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("login_history.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField loginTimeFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Login Time");
		field.setLocaleKey("login_history.login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Login Time");
		return field;
	}

	protected FormField fromIpFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("From Ip");
		field.setLocaleKey("login_history.from_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写From Ip");
		return field;
	}

	protected FormField descriptionFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("login_history.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField secUserIdFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Sec User");
		field.setLocaleKey("login_history.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写Sec User");
		return field;
	}

	protected FormField idFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("generic_form.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("generic_form.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField descriptionFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("generic_form.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField idFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("form_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField formIdFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField levelFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField idFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_field_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("form_field_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField parameterNameFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parameter Name");
		field.setLocaleKey("form_field_message.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Parameter Name");
		return field;
	}

	protected FormField formIdFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_field_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField levelFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_field_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField idFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_field.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField labelFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Label");
		field.setLocaleKey("form_field.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Label");
		return field;
	}

	protected FormField localeKeyFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Locale Key");
		field.setLocaleKey("form_field.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Locale Key");
		return field;
	}

	protected FormField parameterNameFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parameter Name");
		field.setLocaleKey("form_field.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Parameter Name");
		return field;
	}

	protected FormField typeFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Type");
		field.setLocaleKey("form_field.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Type");
		return field;
	}

	protected FormField formIdFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_field.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField placeholderFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Placeholder");
		field.setLocaleKey("form_field.placeholder");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Placeholder");
		return field;
	}

	protected FormField defaultValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Default Value");
		field.setLocaleKey("form_field.default_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Default Value");
		return field;
	}

	protected FormField descriptionFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("form_field.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField fieldGroupFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Field Group");
		field.setLocaleKey("form_field.field_group");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Field Group");
		return field;
	}

	protected FormField minimumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Minimum Value");
		field.setLocaleKey("form_field.minimum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Minimum Value");
		return field;
	}

	protected FormField maximumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Maximum Value");
		field.setLocaleKey("form_field.maximum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Maximum Value");
		return field;
	}

	protected FormField requiredFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Required");
		field.setLocaleKey("form_field.required");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Required");
		return field;
	}

	protected FormField disabledFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Disabled");
		field.setLocaleKey("form_field.disabled");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Disabled");
		return field;
	}

	protected FormField customRenderingFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Custom Rendering");
		field.setLocaleKey("form_field.custom_rendering");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Custom Rendering");
		return field;
	}

	protected FormField candidateValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Candidate Values");
		field.setLocaleKey("form_field.candidate_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Candidate Values");
		return field;
	}

	protected FormField suggestValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Suggest Values");
		field.setLocaleKey("form_field.suggest_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Suggest Values");
		return field;
	}

	protected FormField idFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_action.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField labelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Label");
		field.setLocaleKey("form_action.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Label");
		return field;
	}

	protected FormField localeKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Locale Key");
		field.setLocaleKey("form_action.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Locale Key");
		return field;
	}

	protected FormField actionKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Action Key");
		field.setLocaleKey("form_action.action_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Action Key");
		return field;
	}

	protected FormField levelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_action.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField urlFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Url");
		field.setLocaleKey("form_action.url");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Url");
		return field;
	}

	protected FormField formIdFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_action.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField idFromCandidateContainer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("candidate_container.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromCandidateContainer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("candidate_container.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField idFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("candidate_element.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("candidate_element.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField typeFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Type");
		field.setLocaleKey("candidate_element.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Type");
		return field;
	}

	protected FormField imageFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Image");
		field.setLocaleKey("candidate_element.image");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写Image");
		return field;
	}

	protected FormField containerIdFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Container");
		field.setLocaleKey("candidate_element.container");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("CandidateContainer");
		field.setRequired(true);
		field.setPlaceholder("请填写Container");
		return field;
	}

	protected FormField idFromCandidateContainer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("candidate_container.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromCandidateContainer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("candidate_container.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField idFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("candidate_element.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("candidate_element.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField typeFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("candidate_element.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField imageFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("图片");
		field.setLocaleKey("candidate_element.image");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写图片");
		return field;
	}

	protected FormField containerIdFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("容器");
		field.setLocaleKey("candidate_element.container");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("CandidateContainer");
		field.setRequired(true);
		field.setPlaceholder("请填写容器");
		return field;
	}

}









