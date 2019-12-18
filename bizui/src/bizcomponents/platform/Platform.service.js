import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addChangeRequestType = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addChangeRequestType/platformId/name/code/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateChangeRequestType = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateChangeRequestTypeProperties/platformId/id/name/code/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeChangeRequestTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeChangeRequestTypeList/platformId/changeRequestTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addChangeRequest = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addChangeRequest/platformId/name/requestTypeId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateChangeRequest = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateChangeRequestProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeChangeRequestList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeChangeRequestList/platformId/changeRequestIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addAccount = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addAccount/platformId/name/balance/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccount = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateAccountProperties/platformId/id/name/balance/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeAccountList/platformId/accountIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PlatformService = { view,
  load,
  addChangeRequestType,
  addChangeRequest,
  addAccount,
  updateChangeRequestType,
  updateChangeRequest,
  updateAccount,
  removeChangeRequestTypeList,
  removeChangeRequestList,
  removeAccountList }
export default PlatformService

