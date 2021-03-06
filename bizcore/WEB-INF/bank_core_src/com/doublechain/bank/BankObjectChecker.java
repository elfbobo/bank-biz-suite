package com.doublechain.bank;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class BankObjectChecker extends BankChecker{

	Set<BaseEntity> checkedObjectSet;
	
	protected void markAsChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			checkedObjectSet =  new HashSet<BaseEntity>();
		}
		checkedObjectSet.add(baseEntity);
		
		
	}
	
	protected boolean isChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			return false;
			
		}
		return checkedObjectSet.contains(baseEntity);
	}
	@FunctionalInterface
	public interface CheckerParameterFunction<P1> {
		BankChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		BankObjectChecker apply(BaseEntity targetEntity);
	}
	
	protected boolean isReferenceObject(BaseEntity target) {
		
		if(target.getId()==null) {
			return false;
		}
		if(target.getId().isEmpty()) {
			return false;
		}
		if(target.getVersion() > 0) {
			return false;
		}
		
		return true;
		
	}
	protected boolean isObjectForCreate(BaseEntity target) {
		if(target.getVersion() > 0) {
			return false;
		}
		if(target.getId()==null) {
			return true;
		}
		if(!target.getId().isEmpty()) {
			return false;
		}
		
		
		return true;
		
	}
	protected void setEntityProperty(BaseEntity targetEntity, String property, Object value) {
		if(!targetEntity.isChanged()) {
			return;
		}
		try {
			targetEntity.setPropertyOf(property, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(concat("set property <",property,"> with value ",value.toString()," of ",targetEntity.toString()," failed"));
		}
		
	}
	
	public <T> BankObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> BankObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {
		
		
		if(!target.isChanged()) {
			return this;
		}
		
		if(isReferenceObject(target)&&!propertyName.equals("id")) {
			//this is an object reference, so all other properties except id check will be ignored
			//id will be checked in this case
			return this; //with an Id, but version is 0 regard as refencer
		}
		if(isObjectForCreate(target)&&propertyName.equals("id")) {
			// ignore check id for new object to create
			return this;
		}
		pushPosition(propertyName);
		T valueToCheck=(T)target.propertyOf(propertyName);
		checkerFunction.apply(valueToCheck);
		popPosition();
		
		return this;
	}
	public  BankChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {
		
		pushPosition(propertyName);
		checkerFunction.apply(target);
		popPosition();
		return this;
	}
	protected String wrapArrayIndex(int andIncrement) {
		return "["+andIncrement+"]";
	}
	protected String concat(String ...args) {
		
		return Arrays.asList(args).stream().collect(Collectors.joining(""));
		
	}
	// use like commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);

	public BankObjectChecker checkAndFixPlatform(BaseEntity platformAsBaseEntity){

		if( isChecked(platformAsBaseEntity) ){
			return this;
		}
		markAsChecked(platformAsBaseEntity);
		commonObjectPropertyCheck(platformAsBaseEntity,"id",this::checkIdOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"name",this::checkNameOfPlatform);
		commonObjectPropertyAssign(platformAsBaseEntity,"founded",this::assignFoundedOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"version",this::checkVersionOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"changeRequestTypeList",this::checkChangeRequestTypeListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"changeRequestList",this::checkChangeRequestListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"accountList",this::checkAccountListOfPlatform);
		return this;

	}

	public BankObjectChecker checkAndFixChangeRequestType(BaseEntity changeRequestTypeAsBaseEntity){

		if( isChecked(changeRequestTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(changeRequestTypeAsBaseEntity);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"id",this::checkIdOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"name",this::checkNameOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"code",this::checkCodeOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"platform",this::checkPlatformOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"version",this::checkVersionOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"changeRequestList",this::checkChangeRequestListOfChangeRequestType);
		return this;

	}

	public BankObjectChecker checkAndFixChangeRequest(BaseEntity changeRequestAsBaseEntity){

		if( isChecked(changeRequestAsBaseEntity) ){
			return this;
		}
		markAsChecked(changeRequestAsBaseEntity);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"id",this::checkIdOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);
		commonObjectPropertyAssign(changeRequestAsBaseEntity,"createTime",this::assignCreateTimeOfChangeRequest);
		commonObjectPropertyAssign(changeRequestAsBaseEntity,"remoteIp",this::assignRemoteIpOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"requestType",this::checkRequestTypeOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"platform",this::checkPlatformOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"version",this::checkVersionOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"transactionList",this::checkTransactionListOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"nameChangeEventList",this::checkNameChangeEventListOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"accountChangeList",this::checkAccountChangeListOfChangeRequest);
		return this;

	}

	public BankObjectChecker checkAndFixTransaction(BaseEntity transactionAsBaseEntity){

		if( isChecked(transactionAsBaseEntity) ){
			return this;
		}
		markAsChecked(transactionAsBaseEntity);
		commonObjectPropertyCheck(transactionAsBaseEntity,"id",this::checkIdOfTransaction);
		commonObjectPropertyCheck(transactionAsBaseEntity,"name",this::checkNameOfTransaction);
		commonObjectPropertyCheck(transactionAsBaseEntity,"fromAccount",this::checkFromAccountOfTransaction);
		commonObjectPropertyCheck(transactionAsBaseEntity,"toAccount",this::checkToAccountOfTransaction);
		commonObjectPropertyCheck(transactionAsBaseEntity,"amount",this::checkAmountOfTransaction);
		commonObjectPropertyCheck(transactionAsBaseEntity,"type",this::checkTypeOfTransaction);
		commonObjectPropertyCheck(transactionAsBaseEntity,"changeRequest",this::checkChangeRequestOfTransaction);
		commonObjectPropertyCheck(transactionAsBaseEntity,"version",this::checkVersionOfTransaction);
		return this;

	}

	public BankObjectChecker checkAndFixNameChangeEvent(BaseEntity nameChangeEventAsBaseEntity){

		if( isChecked(nameChangeEventAsBaseEntity) ){
			return this;
		}
		markAsChecked(nameChangeEventAsBaseEntity);
		commonObjectPropertyCheck(nameChangeEventAsBaseEntity,"id",this::checkIdOfNameChangeEvent);
		commonObjectPropertyCheck(nameChangeEventAsBaseEntity,"name",this::checkNameOfNameChangeEvent);
		commonObjectPropertyCheck(nameChangeEventAsBaseEntity,"account",this::checkAccountOfNameChangeEvent);
		commonObjectPropertyCheck(nameChangeEventAsBaseEntity,"changeRequest",this::checkChangeRequestOfNameChangeEvent);
		commonObjectPropertyCheck(nameChangeEventAsBaseEntity,"version",this::checkVersionOfNameChangeEvent);
		return this;

	}

	public BankObjectChecker checkAndFixAccount(BaseEntity accountAsBaseEntity){

		if( isChecked(accountAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountAsBaseEntity);
		commonObjectPropertyCheck(accountAsBaseEntity,"id",this::checkIdOfAccount);
		commonObjectPropertyCheck(accountAsBaseEntity,"name",this::checkNameOfAccount);
		commonObjectPropertyCheck(accountAsBaseEntity,"balance",this::checkBalanceOfAccount);
		commonObjectPropertyAssign(accountAsBaseEntity,"createTime",this::assignCreateTimeOfAccount);
		commonObjectPropertyAssign(accountAsBaseEntity,"updateTime",this::assignUpdateTimeOfAccount);
		commonObjectPropertyCheck(accountAsBaseEntity,"platform",this::checkPlatformOfAccount);
		commonObjectPropertyCheck(accountAsBaseEntity,"version",this::checkVersionOfAccount);
		commonObjectPropertyCheck(accountAsBaseEntity,"transactionListAsFromAccount",this::checkTransactionListAsFromAccountOfAccount);
		commonObjectPropertyCheck(accountAsBaseEntity,"transactionListAsToAccount",this::checkTransactionListAsToAccountOfAccount);
		commonObjectPropertyCheck(accountAsBaseEntity,"nameChangeEventList",this::checkNameChangeEventListOfAccount);
		commonObjectPropertyCheck(accountAsBaseEntity,"accountChangeList",this::checkAccountChangeListOfAccount);
		return this;

	}

	public BankObjectChecker checkAndFixAccountChange(BaseEntity accountChangeAsBaseEntity){

		if( isChecked(accountChangeAsBaseEntity) ){
			return this;
		}
		markAsChecked(accountChangeAsBaseEntity);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"id",this::checkIdOfAccountChange);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"name",this::checkNameOfAccountChange);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"account",this::checkAccountOfAccountChange);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"previousBalance",this::checkPreviousBalanceOfAccountChange);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"type",this::checkTypeOfAccountChange);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"amount",this::checkAmountOfAccountChange);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"currentBalance",this::checkCurrentBalanceOfAccountChange);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"changeRequest",this::checkChangeRequestOfAccountChange);
		commonObjectPropertyCheck(accountChangeAsBaseEntity,"version",this::checkVersionOfAccountChange);
		return this;

	}

	public BankObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

		if( isChecked(userDomainAsBaseEntity) ){
			return this;
		}
		markAsChecked(userDomainAsBaseEntity);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"id",this::checkIdOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"name",this::checkNameOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"version",this::checkVersionOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"userWhiteListList",this::checkUserWhiteListListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"secUserList",this::checkSecUserListOfUserDomain);
		return this;

	}

	public BankObjectChecker checkAndFixUserWhiteList(BaseEntity userWhiteListAsBaseEntity){

		if( isChecked(userWhiteListAsBaseEntity) ){
			return this;
		}
		markAsChecked(userWhiteListAsBaseEntity);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"id",this::checkIdOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userIdentity",this::checkUserIdentityOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userSpecialFunctions",this::checkUserSpecialFunctionsOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"domain",this::checkDomainOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"version",this::checkVersionOfUserWhiteList);
		return this;

	}

	public BankObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

		if( isChecked(secUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserAsBaseEntity);
		commonObjectPropertyCheck(secUserAsBaseEntity,"id",this::checkIdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"login",this::checkLoginOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"mobile",this::checkMobileOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"email",this::checkEmailOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"pwd",this::checkPwdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinOpenid",this::checkWeixinOpenidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinAppid",this::checkWeixinAppidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"accessToken",this::checkAccessTokenOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCode",this::checkVerificationCodeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCodeExpire",this::checkVerificationCodeExpireOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"domain",this::checkDomainOfSecUser);
		commonObjectPropertyAssign(secUserAsBaseEntity,"currentStatus",this::assignCurrentStatusOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"version",this::checkVersionOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"userAppList",this::checkUserAppListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"loginHistoryList",this::checkLoginHistoryListOfSecUser);
		return this;

	}

	public BankObjectChecker checkAndFixSecUserBlocking(BaseEntity secUserBlockingAsBaseEntity){

		if( isChecked(secUserBlockingAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserBlockingAsBaseEntity);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"id",this::checkIdOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"who",this::checkWhoOfSecUserBlocking);
		commonObjectPropertyAssign(secUserBlockingAsBaseEntity,"blockTime",this::assignBlockTimeOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"comments",this::checkCommentsOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"version",this::checkVersionOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"secUserList",this::checkSecUserListOfSecUserBlocking);
		return this;

	}

	public BankObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

		if( isChecked(userAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAppAsBaseEntity);
		commonObjectPropertyCheck(userAppAsBaseEntity,"id",this::checkIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"title",this::checkTitleOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"secUser",this::checkSecUserOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appIcon",this::checkAppIconOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"fullAccess",this::checkFullAccessOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"permission",this::checkPermissionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectType",this::checkObjectTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectId",this::checkObjectIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"location",this::checkLocationOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"version",this::checkVersionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"quickLinkList",this::checkQuickLinkListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"listAccessList",this::checkListAccessListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectAccessList",this::checkObjectAccessListOfUserApp);
		return this;

	}

	public BankObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

		if( isChecked(quickLinkAsBaseEntity) ){
			return this;
		}
		markAsChecked(quickLinkAsBaseEntity);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"id",this::checkIdOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"name",this::checkNameOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"icon",this::checkIconOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"imagePath",this::checkImagePathOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"linkTarget",this::checkLinkTargetOfQuickLink);
		commonObjectPropertyAssign(quickLinkAsBaseEntity,"createTime",this::assignCreateTimeOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"app",this::checkAppOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"version",this::checkVersionOfQuickLink);
		return this;

	}

	public BankObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

		if( isChecked(listAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(listAccessAsBaseEntity);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"id",this::checkIdOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"name",this::checkNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"internalName",this::checkInternalNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"readPermission",this::checkReadPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"createPermission",this::checkCreatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"deletePermission",this::checkDeletePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"updatePermission",this::checkUpdatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"executionPermission",this::checkExecutionPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"app",this::checkAppOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"version",this::checkVersionOfListAccess);
		return this;

	}

	public BankObjectChecker checkAndFixObjectAccess(BaseEntity objectAccessAsBaseEntity){

		if( isChecked(objectAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(objectAccessAsBaseEntity);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"id",this::checkIdOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"name",this::checkNameOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"objectType",this::checkObjectTypeOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list1",this::checkList1OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list2",this::checkList2OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list3",this::checkList3OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list4",this::checkList4OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list5",this::checkList5OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list6",this::checkList6OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list7",this::checkList7OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list8",this::checkList8OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list9",this::checkList9OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"app",this::checkAppOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"version",this::checkVersionOfObjectAccess);
		return this;

	}

	public BankObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

		if( isChecked(loginHistoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(loginHistoryAsBaseEntity);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"id",this::checkIdOfLoginHistory);
		commonObjectPropertyAssign(loginHistoryAsBaseEntity,"loginTime",this::assignLoginTimeOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"fromIp",this::checkFromIpOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"description",this::checkDescriptionOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"secUser",this::checkSecUserOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"version",this::checkVersionOfLoginHistory);
		return this;

	}

	public BankObjectChecker checkAndFixGenericForm(BaseEntity genericFormAsBaseEntity){

		if( isChecked(genericFormAsBaseEntity) ){
			return this;
		}
		markAsChecked(genericFormAsBaseEntity);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"id",this::checkIdOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"title",this::checkTitleOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"description",this::checkDescriptionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"version",this::checkVersionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formMessageList",this::checkFormMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldMessageList",this::checkFormFieldMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldList",this::checkFormFieldListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formActionList",this::checkFormActionListOfGenericForm);
		return this;

	}

	public BankObjectChecker checkAndFixFormMessage(BaseEntity formMessageAsBaseEntity){

		if( isChecked(formMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formMessageAsBaseEntity);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"id",this::checkIdOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"title",this::checkTitleOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"form",this::checkFormOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"level",this::checkLevelOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"version",this::checkVersionOfFormMessage);
		return this;

	}

	public BankObjectChecker checkAndFixFormFieldMessage(BaseEntity formFieldMessageAsBaseEntity){

		if( isChecked(formFieldMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldMessageAsBaseEntity);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"id",this::checkIdOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"title",this::checkTitleOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"parameterName",this::checkParameterNameOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"form",this::checkFormOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"level",this::checkLevelOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"version",this::checkVersionOfFormFieldMessage);
		return this;

	}

	public BankObjectChecker checkAndFixFormField(BaseEntity formFieldAsBaseEntity){

		if( isChecked(formFieldAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldAsBaseEntity);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"id",this::checkIdOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"label",this::checkLabelOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"parameterName",this::checkParameterNameOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"type",this::checkTypeOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"form",this::checkFormOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"placeholder",this::checkPlaceholderOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"defaultValue",this::checkDefaultValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"description",this::checkDescriptionOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"fieldGroup",this::checkFieldGroupOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"minimumValue",this::checkMinimumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"maximumValue",this::checkMaximumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"required",this::checkRequiredOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"disabled",this::checkDisabledOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"customRendering",this::checkCustomRenderingOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"candidateValues",this::checkCandidateValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"suggestValues",this::checkSuggestValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"version",this::checkVersionOfFormField);
		return this;

	}

	public BankObjectChecker checkAndFixFormAction(BaseEntity formActionAsBaseEntity){

		if( isChecked(formActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(formActionAsBaseEntity);
		commonObjectPropertyCheck(formActionAsBaseEntity,"id",this::checkIdOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"label",this::checkLabelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"actionKey",this::checkActionKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"level",this::checkLevelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"url",this::checkUrlOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"form",this::checkFormOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"version",this::checkVersionOfFormAction);
		return this;

	}

	public BankObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

		if( isChecked(candidateContainerAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateContainerAsBaseEntity);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"id",this::checkIdOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"name",this::checkNameOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"version",this::checkVersionOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"candidateElementList",this::checkCandidateElementListOfCandidateContainer);
		return this;

	}

	public BankObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

		if( isChecked(candidateElementAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateElementAsBaseEntity);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"id",this::checkIdOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"name",this::checkNameOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"type",this::checkTypeOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"image",this::checkImageOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"container",this::checkContainerOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"version",this::checkVersionOfCandidateElement);
		return this;

	}


	public BankObjectChecker checkChangeRequestTypeListOfPlatform(List<BaseEntity> changeRequestTypeList){
		AtomicInteger index = new AtomicInteger();
		changeRequestTypeList.stream().forEach(changeRequestType->
			commonObjectElementCheck(changeRequestType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequestType));
		return this;
	}

	public BankObjectChecker checkChangeRequestListOfPlatform(List<BaseEntity> changeRequestList){
		AtomicInteger index = new AtomicInteger();
		changeRequestList.stream().forEach(changeRequest->
			commonObjectElementCheck(changeRequest,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequest));
		return this;
	}

	public BankObjectChecker checkAccountListOfPlatform(List<BaseEntity> accountList){
		AtomicInteger index = new AtomicInteger();
		accountList.stream().forEach(account->
			commonObjectElementCheck(account,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccount));
		return this;
	}

	public BankObjectChecker checkChangeRequestListOfChangeRequestType(List<BaseEntity> changeRequestList){
		AtomicInteger index = new AtomicInteger();
		changeRequestList.stream().forEach(changeRequest->
			commonObjectElementCheck(changeRequest,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequest));
		return this;
	}

	public static final String PLATFORM_OF_CHANGE_REQUEST_TYPE = "change_request_type.platform";


	public BankObjectChecker checkPlatformOfChangeRequestType(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_CHANGE_REQUEST_TYPE);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public BankObjectChecker checkTransactionListOfChangeRequest(List<BaseEntity> transactionList){
		AtomicInteger index = new AtomicInteger();
		transactionList.stream().forEach(transaction->
			commonObjectElementCheck(transaction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransaction));
		return this;
	}

	public BankObjectChecker checkNameChangeEventListOfChangeRequest(List<BaseEntity> nameChangeEventList){
		AtomicInteger index = new AtomicInteger();
		nameChangeEventList.stream().forEach(nameChangeEvent->
			commonObjectElementCheck(nameChangeEvent,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixNameChangeEvent));
		return this;
	}

	public BankObjectChecker checkAccountChangeListOfChangeRequest(List<BaseEntity> accountChangeList){
		AtomicInteger index = new AtomicInteger();
		accountChangeList.stream().forEach(accountChange->
			commonObjectElementCheck(accountChange,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountChange));
		return this;
	}

	public static final String REQUEST_TYPE_OF_CHANGE_REQUEST = "change_request.request_type";


	public BankObjectChecker checkRequestTypeOfChangeRequest(BaseEntity requestTypeAsBaseEntity){

		if(requestTypeAsBaseEntity == null){
			checkBaseEntityReference(requestTypeAsBaseEntity,true,REQUEST_TYPE_OF_CHANGE_REQUEST);
			return this;
		}
		checkAndFixChangeRequestType(requestTypeAsBaseEntity);
		return this;
	}


	public static final String PLATFORM_OF_CHANGE_REQUEST = "change_request.platform";


	public BankObjectChecker checkPlatformOfChangeRequest(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_CHANGE_REQUEST);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public static final String FROM_ACCOUNT_OF_TRANSACTION = "transaction.from_account";


	public BankObjectChecker checkFromAccountOfTransaction(BaseEntity fromAccountAsBaseEntity){

		if(fromAccountAsBaseEntity == null){
			checkBaseEntityReference(fromAccountAsBaseEntity,true,FROM_ACCOUNT_OF_TRANSACTION);
			return this;
		}
		checkAndFixAccount(fromAccountAsBaseEntity);
		return this;
	}


	public static final String TO_ACCOUNT_OF_TRANSACTION = "transaction.to_account";


	public BankObjectChecker checkToAccountOfTransaction(BaseEntity toAccountAsBaseEntity){

		if(toAccountAsBaseEntity == null){
			checkBaseEntityReference(toAccountAsBaseEntity,true,TO_ACCOUNT_OF_TRANSACTION);
			return this;
		}
		checkAndFixAccount(toAccountAsBaseEntity);
		return this;
	}


	public static final String CHANGE_REQUEST_OF_TRANSACTION = "transaction.change_request";


	public BankObjectChecker checkChangeRequestOfTransaction(BaseEntity changeRequestAsBaseEntity){

		if(changeRequestAsBaseEntity == null){
			checkBaseEntityReference(changeRequestAsBaseEntity,true,CHANGE_REQUEST_OF_TRANSACTION);
			return this;
		}
		checkAndFixChangeRequest(changeRequestAsBaseEntity);
		return this;
	}


	public static final String ACCOUNT_OF_NAME_CHANGE_EVENT = "name_change_event.account";


	public BankObjectChecker checkAccountOfNameChangeEvent(BaseEntity accountAsBaseEntity){

		if(accountAsBaseEntity == null){
			checkBaseEntityReference(accountAsBaseEntity,true,ACCOUNT_OF_NAME_CHANGE_EVENT);
			return this;
		}
		checkAndFixAccount(accountAsBaseEntity);
		return this;
	}


	public static final String CHANGE_REQUEST_OF_NAME_CHANGE_EVENT = "name_change_event.change_request";


	public BankObjectChecker checkChangeRequestOfNameChangeEvent(BaseEntity changeRequestAsBaseEntity){

		if(changeRequestAsBaseEntity == null){
			checkBaseEntityReference(changeRequestAsBaseEntity,true,CHANGE_REQUEST_OF_NAME_CHANGE_EVENT);
			return this;
		}
		checkAndFixChangeRequest(changeRequestAsBaseEntity);
		return this;
	}


	public BankObjectChecker checkTransactionListAsFromAccountOfAccount(List<BaseEntity> transactionListAsFromAccount){
		AtomicInteger index = new AtomicInteger();
		transactionListAsFromAccount.stream().forEach(transaction->
			commonObjectElementCheck(transaction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransaction));
		return this;
	}

	public BankObjectChecker checkTransactionListAsToAccountOfAccount(List<BaseEntity> transactionListAsToAccount){
		AtomicInteger index = new AtomicInteger();
		transactionListAsToAccount.stream().forEach(transaction->
			commonObjectElementCheck(transaction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixTransaction));
		return this;
	}

	public BankObjectChecker checkNameChangeEventListOfAccount(List<BaseEntity> nameChangeEventList){
		AtomicInteger index = new AtomicInteger();
		nameChangeEventList.stream().forEach(nameChangeEvent->
			commonObjectElementCheck(nameChangeEvent,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixNameChangeEvent));
		return this;
	}

	public BankObjectChecker checkAccountChangeListOfAccount(List<BaseEntity> accountChangeList){
		AtomicInteger index = new AtomicInteger();
		accountChangeList.stream().forEach(accountChange->
			commonObjectElementCheck(accountChange,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAccountChange));
		return this;
	}

	public static final String PLATFORM_OF_ACCOUNT = "account.platform";


	public BankObjectChecker checkPlatformOfAccount(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_ACCOUNT);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public static final String ACCOUNT_OF_ACCOUNT_CHANGE = "account_change.account";


	public BankObjectChecker checkAccountOfAccountChange(BaseEntity accountAsBaseEntity){

		if(accountAsBaseEntity == null){
			checkBaseEntityReference(accountAsBaseEntity,true,ACCOUNT_OF_ACCOUNT_CHANGE);
			return this;
		}
		checkAndFixAccount(accountAsBaseEntity);
		return this;
	}


	public static final String CHANGE_REQUEST_OF_ACCOUNT_CHANGE = "account_change.change_request";


	public BankObjectChecker checkChangeRequestOfAccountChange(BaseEntity changeRequestAsBaseEntity){

		if(changeRequestAsBaseEntity == null){
			checkBaseEntityReference(changeRequestAsBaseEntity,true,CHANGE_REQUEST_OF_ACCOUNT_CHANGE);
			return this;
		}
		checkAndFixChangeRequest(changeRequestAsBaseEntity);
		return this;
	}


	public BankObjectChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		AtomicInteger index = new AtomicInteger();
		userWhiteListList.stream().forEach(userWhiteList->
			commonObjectElementCheck(userWhiteList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserWhiteList));
		return this;
	}

	public BankObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public BankObjectChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public BankObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public BankObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public BankObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public static final String BLOCKING_OF_SEC_USER = "sec_user.blocking";


	public BankObjectChecker checkBlockingOfSecUser(BaseEntity blockingAsBaseEntity){

		if(blockingAsBaseEntity == null){
			checkBaseEntityReference(blockingAsBaseEntity,true,BLOCKING_OF_SEC_USER);
			return this;
		}
		checkAndFixSecUserBlocking(blockingAsBaseEntity);
		return this;
	}


	public BankObjectChecker checkSecUserListOfSecUserBlocking(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public BankObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public BankObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public BankObjectChecker checkObjectAccessListOfUserApp(List<BaseEntity> objectAccessList){
		AtomicInteger index = new AtomicInteger();
		objectAccessList.stream().forEach(objectAccess->
			commonObjectElementCheck(objectAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixObjectAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public BankObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public BankObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public BankObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_OBJECT_ACCESS = "object_access.app";


	public BankObjectChecker checkAppOfObjectAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_OBJECT_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public BankObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public BankObjectChecker checkFormMessageListOfGenericForm(List<BaseEntity> formMessageList){
		AtomicInteger index = new AtomicInteger();
		formMessageList.stream().forEach(formMessage->
			commonObjectElementCheck(formMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormMessage));
		return this;
	}

	public BankObjectChecker checkFormFieldMessageListOfGenericForm(List<BaseEntity> formFieldMessageList){
		AtomicInteger index = new AtomicInteger();
		formFieldMessageList.stream().forEach(formFieldMessage->
			commonObjectElementCheck(formFieldMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormFieldMessage));
		return this;
	}

	public BankObjectChecker checkFormFieldListOfGenericForm(List<BaseEntity> formFieldList){
		AtomicInteger index = new AtomicInteger();
		formFieldList.stream().forEach(formField->
			commonObjectElementCheck(formField,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormField));
		return this;
	}

	public BankObjectChecker checkFormActionListOfGenericForm(List<BaseEntity> formActionList){
		AtomicInteger index = new AtomicInteger();
		formActionList.stream().forEach(formAction->
			commonObjectElementCheck(formAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormAction));
		return this;
	}

	public static final String FORM_OF_FORM_MESSAGE = "form_message.form";


	public BankObjectChecker checkFormOfFormMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD_MESSAGE = "form_field_message.form";


	public BankObjectChecker checkFormOfFormFieldMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD = "form_field.form";


	public BankObjectChecker checkFormOfFormField(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_ACTION = "form_action.form";


	public BankObjectChecker checkFormOfFormAction(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_ACTION);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public BankObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public BankObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}

	public BankObjectChecker assignFoundedOfPlatform(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"founded",userContext.now());
		return this;
	}
	public BankObjectChecker assignCreateTimeOfChangeRequest(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public BankObjectChecker assignRemoteIpOfChangeRequest(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"remoteIp",userContext.getRemoteIP());
		return this;
	}
	public BankObjectChecker assignCreateTimeOfAccount(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public BankObjectChecker assignUpdateTimeOfAccount(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"updateTime",userContext.now());
		return this;
	}
	public BankObjectChecker assignBlockingOfSecUser(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		return this;
	}
	public BankObjectChecker assignCurrentStatusOfSecUser(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"currentStatus","INIT");
		return this;
	}
	public BankObjectChecker assignBlockTimeOfSecUserBlocking(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"blockTime",userContext.now());
		return this;
	}
	public BankObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public BankObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}

}

