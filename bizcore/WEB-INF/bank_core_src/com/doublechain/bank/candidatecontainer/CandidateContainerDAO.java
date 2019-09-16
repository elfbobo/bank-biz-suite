
package com.doublechain.bank.candidatecontainer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.bank.BaseEntity;
import com.doublechain.bank.SmartList;
import com.doublechain.bank.MultipleAccessKey;
import com.doublechain.bank.BankUserContext;

import com.doublechain.bank.candidateelement.CandidateElement;

import com.doublechain.bank.candidateelement.CandidateElementDAO;


public interface CandidateContainerDAO{

	
	public CandidateContainer load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CandidateContainer> candidateContainerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CandidateContainer present(CandidateContainer candidateContainer,Map<String,Object> options) throws Exception;
	public CandidateContainer clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CandidateContainer save(CandidateContainer candidateContainer,Map<String,Object> options);
	public SmartList<CandidateContainer> saveCandidateContainerList(SmartList<CandidateContainer> candidateContainerList,Map<String,Object> options);
	public SmartList<CandidateContainer> removeCandidateContainerList(SmartList<CandidateContainer> candidateContainerList,Map<String,Object> options);
	public SmartList<CandidateContainer> findCandidateContainerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCandidateContainerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCandidateContainerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String candidateContainerId, int version) throws Exception;
	public CandidateContainer disconnectFromAll(String candidateContainerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CandidateElementDAO getCandidateElementDAO();
		
	
 	public SmartList<CandidateContainer> requestCandidateCandidateContainerForCandidateElement(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public CandidateContainer planToRemoveCandidateElementList(CandidateContainer candidateContainer, String candidateElementIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<CandidateContainer> queryList(String sql, Object ... parmeters);

	// ?????????????enhance??:CandidateElement?container?CandidateElementList
	public SmartList<CandidateElement> loadOurCandidateElementList(BankUserContext userContext, List<CandidateContainer> us, Map<String,Object> options) throws Exception;
	
}


