

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ChangeRequest.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (changeRequest,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{changeRequest.id}</Description> 
<Description term="Name">{changeRequest.name}</Description> 
<Description term="Create Time">{ moment(changeRequest.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="Remote Ip">{changeRequest.remoteIp}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = changeRequest => {
  const {ChangeRequestBase} = GlobalComponents
  return <PermissionSetting targetObject={changeRequest}  targetObjectMeta={ChangeRequestBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ChangeRequestPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  changeRequest = this.props.changeRequest;
    const { id,displayName, transactionCount, nameChangeEventCount, accountChangeCount } = changeRequest
    const cardsData = {cardsName:"Change Request",cardsFor: "changeRequest",cardsSource: changeRequest,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  changeRequest: state._changeRequest,
}))(Form.create()(ChangeRequestPermission))

