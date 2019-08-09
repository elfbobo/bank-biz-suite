<%@ page import='java.util.*,com.doublechain.bank.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty accountChangeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['account_change']}! 
		 <a href="./${ownerBeanName}Manager/addAccountChange/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty accountChangeList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("accountChangeList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['account_change']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAccountChange/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'accountChangeList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${accountChangeListName};${accountChangeListName}CurrentPage=${page.pageNumber};${accountChangeListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='accountChangeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['account_change.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['account_change.name']}</th>
</c:if>
<c:if test="${param.referName ne 'account'}">
	<th>${userContext.localeMap['account_change.account']}</th>
</c:if>
<c:if test="${param.referName ne 'previousBalance'}">
	<th>${userContext.localeMap['account_change.previous_balance']}</th>
</c:if>
<c:if test="${param.referName ne 'type'}">
	<th>${userContext.localeMap['account_change.type']}</th>
</c:if>
<c:if test="${param.referName ne 'amount'}">
	<th>${userContext.localeMap['account_change.amount']}</th>
</c:if>
<c:if test="${param.referName ne 'currentBalance'}">
	<th>${userContext.localeMap['account_change.current_balance']}</th>
</c:if>
<c:if test="${param.referName ne 'changeRequest'}">
	<th>${userContext.localeMap['account_change.change_request']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${accountChangeList}">
				<tr currentVersion='${item.version}' id="accountChange-${item.id}" ><td><a class="link-action-removed" href="./accountChangeManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateAccountChange/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'account'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountChangeManager/requestCandidateAccount/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountChangeManager/transferToAnotherAccount/${item.id}/"
			data-link-template="./accountManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.account}">
			<a href='./accountManager/view/${item.account.id}/'>${item.account.displayName}</a>
			</c:if>
			<c:if test="${empty  item.account}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'previousBalance'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='previousBalance' storedCellValue='${item.previousBalance}' prefix='${ownerBeanName}Manager/updateAccountChange/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.previousBalance}" /></td>
</c:if><c:if test="${param.referName ne 'type'}">	<td contenteditable='true' class='edit-value'  propertyToChange='type' storedCellValue='${item.type}' prefix='${ownerBeanName}Manager/updateAccountChange/${result.id}/${item.id}/'>${item.type}</td>
</c:if><c:if test="${param.referName ne 'amount'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='amount' storedCellValue='${item.amount}' prefix='${ownerBeanName}Manager/updateAccountChange/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.amount}" /></td>
</c:if><c:if test="${param.referName ne 'currentBalance'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='currentBalance' storedCellValue='${item.currentBalance}' prefix='${ownerBeanName}Manager/updateAccountChange/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.currentBalance}" /></td>
</c:if><c:if test="${param.referName ne 'changeRequest'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountChangeManager/requestCandidateChangeRequest/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountChangeManager/transferToAnotherChangeRequest/${item.id}/"
			data-link-template="./changeRequestManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.changeRequest}">
			<a href='./changeRequestManager/view/${item.changeRequest.id}/'>${item.changeRequest.displayName}</a>
			</c:if>
			<c:if test="${empty  item.changeRequest}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>

				<td>

				<a href='#${ownerBeanName}Manager/removeAccountChange/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAccountChangeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


