import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"Account Change", menuFor: "accountChange",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  account: 'Account',
  previousBalance: 'Previous Balance',
  type: 'Type',
  amount: 'Amount',
  currentBalance: 'Current Balance',
  changeRequest: 'Change Request',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountChange') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.account, dataIndex: 'account', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.previousBalance, dataIndex: 'previousBalance', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.currentBalance, dataIndex: 'currentBalance', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.changeRequest, dataIndex: 'changeRequest', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(accountChange,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountChange.id}>
	
      <DescriptionList  key={accountChange.id} size="small" col="4">
        <Description term="Id">{accountChange.id}</Description> 
        <Description term="Name">{accountChange.name}</Description> 
        <Description term="Account"><div>{accountChange.account==null?appLocaleName(userContext,"NotAssigned"):`${accountChange.account.displayName}(${accountChange.account.id})`}
        </div></Description>
        <Description term="Previous Balance"><div style={{"color":"red"}}>{accountChange.previousBalance}</div></Description> 
        <Description term="Type">{accountChange.type}</Description> 
        <Description term="Amount"><div style={{"color":"red"}}>{accountChange.amount}</div></Description> 
        <Description term="Current Balance"><div style={{"color":"red"}}>{accountChange.currentBalance}</div></Description> 
        <Description term="Change Request"><div>{accountChange.changeRequest==null?appLocaleName(userContext,"NotAssigned"):`${accountChange.changeRequest.displayName}(${accountChange.changeRequest.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const AccountChangeBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default AccountChangeBase



