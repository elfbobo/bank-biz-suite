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
		field.setLabel("ID");
		field.setLocaleKey("platform.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("platform.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField foundedFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("platform.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("change_request.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("change_request.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField createTimeFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("change_request.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField remoteIpFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??Ip");
		field.setLocaleKey("change_request.remote_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????Ip");
		return field;
	}

	protected FormField platformIdFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("change_request.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("transaction.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("transaction.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField fromAccountIdFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("transaction.from_account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("Account");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField toAccountIdFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("transaction.to_account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("Account");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField amountFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("transaction.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField typeFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("transaction.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField changeRequestIdFromTransaction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("transaction.change_request");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("ChangeRequest");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField idFromNameChangeEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("name_change_event.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromNameChangeEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("name_change_event.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField accountIdFromNameChangeEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("name_change_event.account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("Account");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField changeRequestIdFromNameChangeEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("name_change_event.change_request");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("ChangeRequest");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField idFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("account.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("account.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField balanceFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("account.balance");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField createTimeFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("account.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField updateTimeFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("account.update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField platformIdFromAccount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("account.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("account_change.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("account_change.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField accountIdFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("account_change.account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("Account");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField previousBalanceFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("account_change.previous_balance");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField typeFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("account_change.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField amountFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("account_change.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField currentBalanceFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("account_change.current_balance");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField changeRequestIdFromAccountChange(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("account_change.change_request");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("ChangeRequest");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField idFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("user_domain.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("user_domain.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("user_white_list.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField userIdentityFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("user_white_list.user_identity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField userSpecialFunctionsFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??????");
		field.setLocaleKey("user_white_list.user_special_functions");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????????");
		return field;
	}

	protected FormField domainIdFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("?");
		field.setLocaleKey("user_white_list.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("????");
		return field;
	}

	protected FormField idFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("sec_user.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField loginFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("sec_user.login");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField mobileFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("sec_user.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField emailFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("sec_user.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField pwdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("sec_user.pwd");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("password");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField weixinOpenidFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??openid");
		field.setLocaleKey("sec_user.weixin_openid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????openid");
		return field;
	}

	protected FormField weixinAppidFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??Appid");
		field.setLocaleKey("sec_user.weixin_appid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????Appid");
		return field;
	}

	protected FormField accessTokenFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("sec_user.access_token");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField verificationCodeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("sec_user.verification_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField verificationCodeExpireFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("?????");
		field.setLocaleKey("sec_user.verification_code_expire");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("????????");
		return field;
	}

	protected FormField lastLoginTimeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??????");
		field.setLocaleKey("sec_user.last_login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("?????????");
		return field;
	}

	protected FormField domainIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("?");
		field.setLocaleKey("sec_user.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("????");
		return field;
	}

	protected FormField blockingIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("sec_user.blocking");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("SecUserBlocking");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField currentStatusFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("sec_user.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField idFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("sec_user_blocking.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField whoFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("?");
		field.setLocaleKey("sec_user_blocking.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("????");
		return field;
	}

	protected FormField blockTimeFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("sec_user_blocking.block_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField commentsFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("sec_user_blocking.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("user_app.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField titleFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("user_app.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField secUserIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("user_app.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField appIconFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??????");
		field.setLocaleKey("user_app.app_icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????????");
		return field;
	}

	protected FormField fullAccessFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("user_app.full_access");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField permissionFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("user_app.permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField objectTypeFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??????");
		field.setLocaleKey("user_app.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????????");
		return field;
	}

	protected FormField objectIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??ID");
		field.setLocaleKey("user_app.object_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????ID");
		return field;
	}

	protected FormField locationFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("user_app.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("quick_link.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("quick_link.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField iconFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("quick_link.icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField imagePathFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("quick_link.image_path");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField linkTargetFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("?????");
		field.setLocaleKey("quick_link.link_target");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("????????");
		return field;
	}

	protected FormField createTimeFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("quick_link.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField appIdFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("quick_link.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField idFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("list_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("list_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField internalNameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("list_access.internal_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField readPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("list_access.read_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField createPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("list_access.create_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField deletePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("list_access.delete_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField updatePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("list_access.update_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField executionPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("list_access.execution_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField appIdFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("list_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField idFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("object_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("object_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField objectTypeFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??????");
		field.setLocaleKey("object_access.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????????");
		return field;
	}

	protected FormField list1FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??1");
		field.setLocaleKey("object_access.list1");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????1");
		return field;
	}

	protected FormField list2FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??2");
		field.setLocaleKey("object_access.list2");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????2");
		return field;
	}

	protected FormField list3FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??3");
		field.setLocaleKey("object_access.list3");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????3");
		return field;
	}

	protected FormField list4FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??4");
		field.setLocaleKey("object_access.list4");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????4");
		return field;
	}

	protected FormField list5FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??5");
		field.setLocaleKey("object_access.list5");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????5");
		return field;
	}

	protected FormField list6FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??6");
		field.setLocaleKey("object_access.list6");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????6");
		return field;
	}

	protected FormField list7FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??7");
		field.setLocaleKey("object_access.list7");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????7");
		return field;
	}

	protected FormField list8FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??8");
		field.setLocaleKey("object_access.list8");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????8");
		return field;
	}

	protected FormField list9FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??9");
		field.setLocaleKey("object_access.list9");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????9");
		return field;
	}

	protected FormField appIdFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("object_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField idFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("login_history.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField loginTimeFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("login_history.login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField fromIpFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??IP");
		field.setLocaleKey("login_history.from_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????IP");
		return field;
	}

	protected FormField descriptionFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("login_history.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField secUserIdFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("login_history.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField idFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("generic_form.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField titleFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("generic_form.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField descriptionFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("generic_form.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("form_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField titleFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField formIdFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField levelFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("form_field_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField titleFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField parameterNameFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("form_field_message.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField formIdFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField levelFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("form_field.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField labelFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField localeKeyFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???????");
		field.setLocaleKey("form_field.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????????");
		return field;
	}

	protected FormField parameterNameFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("????");
		field.setLocaleKey("form_field.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???????");
		return field;
	}

	protected FormField typeFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField formIdFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField placeholderFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("form_field.placeholder");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField defaultValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("form_field.default_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField descriptionFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField fieldGroupFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("form_field.field_group");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField minimumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("form_field.minimum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField maximumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("form_field.maximum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField requiredFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field.required");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField disabledFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_field.disabled");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField customRenderingFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("?????");
		field.setLocaleKey("form_field.custom_rendering");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("????????");
		return field;
	}

	protected FormField candidateValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???????");
		field.setLocaleKey("form_field.candidate_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????????");
		return field;
	}

	protected FormField suggestValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???");
		field.setLocaleKey("form_field.suggest_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????");
		return field;
	}

	protected FormField idFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("form_action.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField labelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_action.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField localeKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("???????");
		field.setLocaleKey("form_action.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("??????????");
		return field;
	}

	protected FormField actionKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("?????");
		field.setLocaleKey("form_action.action_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("????????");
		return field;
	}

	protected FormField levelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_action.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField urlFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("url");
		field.setLocaleKey("form_action.url");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???url");
		return field;
	}

	protected FormField formIdFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("form_action.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromCandidateContainer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("candidate_container.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromCandidateContainer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("candidate_container.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField idFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("candidate_element.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("???ID");
		return field;
	}

	protected FormField nameFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("candidate_element.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField typeFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("candidate_element.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField imageFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("candidate_element.image");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

	protected FormField containerIdFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("??");
		field.setLocaleKey("candidate_element.container");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("????");
		field.setType("CandidateContainer");
		field.setRequired(true);
		field.setPlaceholder("?????");
		return field;
	}

}









