
package com.doublechain.bank.secuser;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.bank.BaseEntity;
import com.doublechain.bank.SmartList;
import com.doublechain.bank.MultipleAccessKey;
import com.doublechain.bank.BankUserContext;

import com.doublechain.bank.loginhistory.LoginHistory;
import com.doublechain.bank.userdomain.UserDomain;
import com.doublechain.bank.secuserblocking.SecUserBlocking;
import com.doublechain.bank.userapp.UserApp;

import com.doublechain.bank.userapp.UserAppDAO;
import com.doublechain.bank.userdomain.UserDomainDAO;
import com.doublechain.bank.loginhistory.LoginHistoryDAO;
import com.doublechain.bank.secuserblocking.SecUserBlockingDAO;


public interface SecUserDAO{

	
	public SecUser load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SecUser> secUserList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SecUser loadByLogin(String login,Map<String,Object> options) throws Exception;
	
	
	public SecUser loadByEmail(String email,Map<String,Object> options) throws Exception;
	
	
	public SecUser loadByMobile(String mobile,Map<String,Object> options) throws Exception;
	
	
	public SecUser present(SecUser secUser,Map<String,Object> options) throws Exception;
	public SecUser clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SecUser cloneByLogin(String login,Map<String,Object> options) throws Exception;
	
	
	public SecUser cloneByEmail(String email,Map<String,Object> options) throws Exception;
	
	
	public SecUser cloneByMobile(String mobile,Map<String,Object> options) throws Exception;
	
	
	public SecUser save(SecUser secUser,Map<String,Object> options);
	public SmartList<SecUser> saveSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options);
	public SmartList<SecUser> removeSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options);
	public SmartList<SecUser> findSecUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSecUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSecUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String secUserId, int version) throws Exception;
	public SecUser disconnectFromAll(String secUserId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public UserAppDAO getUserAppDAO();
		
	public LoginHistoryDAO getLoginHistoryDAO();
		
	
 	public SmartList<SecUser> requestCandidateSecUserForUserApp(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForLoginHistory(BankUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SecUser planToRemoveUserAppList(SecUser secUser, String userAppIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with object_id in UserApp
	public SecUser planToRemoveUserAppListWithObjectId(SecUser secUser, String objectIdId, Map<String,Object> options)throws Exception;
	public int countUserAppListWithObjectId(String secUserId, String objectIdId, Map<String,Object> options)throws Exception;
	
	public SecUser planToRemoveLoginHistoryList(SecUser secUser, String loginHistoryIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<SecUser> queryList(String sql, Object ... parmeters);
 
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, Map<String,Object> options);
 	public int countSecUserByDomain(String userDomainId, Map<String,Object> options);
 	public Map<String, Integer> countSecUserByDomainIds(String[] ids, Map<String,Object> options);
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, int start, int count, Map<String,Object> options);
 	public void analyzeSecUserByDomain(SmartList<SecUser> resultList, String userDomainId, Map<String,Object> options);

 
  
 	public SmartList<SecUser> findSecUserByBlocking(String secUserBlockingId, Map<String,Object> options);
 	public int countSecUserByBlocking(String secUserBlockingId, Map<String,Object> options);
 	public Map<String, Integer> countSecUserByBlockingIds(String[] ids, Map<String,Object> options);
 	public SmartList<SecUser> findSecUserByBlocking(String secUserBlockingId, int start, int count, Map<String,Object> options);
 	public void analyzeSecUserByBlocking(SmartList<SecUser> resultList, String secUserBlockingId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:UserApp的secUser的UserAppList
	public SmartList<UserApp> loadOurUserAppList(BankUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:LoginHistory的secUser的LoginHistoryList
	public SmartList<LoginHistory> loadOurLoginHistoryList(BankUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
}


