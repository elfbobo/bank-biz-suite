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


const menuData = {menuName:"Transaction", menuFor: "transaction",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  fromAccount: 'From Account',
  toAccount: 'To Account',
  amount: 'Amount',
  type: 'Type',
  changeRequest: 'Change Request',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transaction') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.fromAccount, dataIndex: 'fromAccount', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.toAccount, dataIndex: 'toAccount', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.changeRequest, dataIndex: 'changeRequest', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(transaction,targetComponent)=>{

  const userContext = null
  return (
    <div key={transaction.id}>
	
      <DescriptionList  key={transaction.id} size="small" col="4">
        <Description term="Id">{transaction.id}</Description> 
        <Description term="Name">{transaction.name}</Description> 
        <Description term="From Account"><div>{transaction.fromAccount==null?appLocaleName(userContext,"NotAssigned"):`${transaction.fromAccount.displayName}(${transaction.fromAccount.id})`}
        </div></Description>
        <Description term="To Account"><div>{transaction.toAccount==null?appLocaleName(userContext,"NotAssigned"):`${transaction.toAccount.displayName}(${transaction.toAccount.id})`}
        </div></Description>
        <Description term="Amount"><div style={{"color":"red"}}>{transaction.amount}</div></Description> 
        <Description term="Type">{transaction.type}</Description> 
        <Description term="Change Request"><div>{transaction.changeRequest==null?appLocaleName(userContext,"NotAssigned"):`${transaction.changeRequest.displayName}(${transaction.changeRequest.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const TransactionBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TransactionBase



