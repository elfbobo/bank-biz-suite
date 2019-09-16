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


const menuData = {menuName:"??", menuFor: "transaction",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '??',
  fromAccount: '???',
  toAccount: '????',
  amount: '??',
  type: '??',
  changeRequest: '????',

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
        <Description term="ID">{transaction.id}</Description> 
        <Description term="??">{transaction.name}</Description> 
        <Description term="???"><div>{transaction.fromAccount==null?appLocaleName(userContext,"NotAssigned"):`${transaction.fromAccount.displayName}(${transaction.fromAccount.id})`}
        </div></Description>
        <Description term="????"><div>{transaction.toAccount==null?appLocaleName(userContext,"NotAssigned"):`${transaction.toAccount.displayName}(${transaction.toAccount.id})`}
        </div></Description>
        <Description term="??"><div style={{"color":"red"}}>{transaction.amount}</div></Description> 
        <Description term="??">{transaction.type}</Description> 
        <Description term="????"><div>{transaction.changeRequest==null?appLocaleName(userContext,"NotAssigned"):`${transaction.changeRequest.displayName}(${transaction.changeRequest.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const TransactionBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TransactionBase



