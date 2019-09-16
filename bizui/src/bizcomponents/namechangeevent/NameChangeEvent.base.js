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


const menuData = {menuName:"Name Change Event", menuFor: "nameChangeEvent",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  account: 'Account',
  changeRequest: 'Change Request',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'nameChangeEvent') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.account, dataIndex: 'account', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.changeRequest, dataIndex: 'changeRequest', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(nameChangeEvent,targetComponent)=>{

  const userContext = null
  return (
    <div key={nameChangeEvent.id}>
	
      <DescriptionList  key={nameChangeEvent.id} size="small" col="4">
        <Description term="Id">{nameChangeEvent.id}</Description> 
        <Description term="Name">{nameChangeEvent.name}</Description> 
        <Description term="Account"><div>{nameChangeEvent.account==null?appLocaleName(userContext,"NotAssigned"):`${nameChangeEvent.account.displayName}(${nameChangeEvent.account.id})`}
        </div></Description>
        <Description term="Change Request"><div>{nameChangeEvent.changeRequest==null?appLocaleName(userContext,"NotAssigned"):`${nameChangeEvent.changeRequest.displayName}(${nameChangeEvent.changeRequest.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const NameChangeEventBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default NameChangeEventBase



