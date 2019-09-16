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


<<<<<<< HEAD
const menuData = {menuName:"候选人容器", menuFor: "candidateContainer",
  		subItems: [
  {name: 'candidateElementList', displayName:'候选人元素', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======
const menuData = {menuName:"Candidate Container", menuFor: "candidateContainer",
  		subItems: [
  {name: 'candidateElementList', displayName:'Candidate Element', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: 'ID',
  name: '名称',
=======
  id: 'Id',
  name: 'Name',
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'candidateContainer') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(candidateContainer,targetComponent)=>{

  const userContext = null
  return (
    <div key={candidateContainer.id}>
	
      <DescriptionList  key={candidateContainer.id} size="small" col="4">
<<<<<<< HEAD
        <Description term="ID">{candidateContainer.id}</Description> 
        <Description term="名称">{candidateContainer.name}</Description> 
=======
        <Description term="Id">{candidateContainer.id}</Description> 
        <Description term="Name">{candidateContainer.name}</Description> 
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const CandidateContainerBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default CandidateContainerBase



