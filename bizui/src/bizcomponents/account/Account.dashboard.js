

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Account.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(account)=>{return [
	 ]}

const internalImageListOf = (account) =>defaultImageListOf(account,imageList)

const optionList =(account)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (account) =>defaultSettingListOf(account, optionList)
const internalLargeTextOf = (account) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (account,targetComponent) =>{
	
	
	const {AccountService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{account.id}</Description> 
<Description term="Name">{account.name}</Description> 
<Description term="Balance">{account.balance}</Description> 
<Description term="Create Time">{ moment(account.createTime).format('YYYY-MM-DD HH:mm')}</Description> 
<Description term="Update Time">{ moment(account.updateTime).format('YYYY-MM-DD HH:mm')}</Description> 
	
        {buildTransferModal(account,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class AccountDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'account'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, transactionListAsFromAccountMetaInfo, transactionListAsToAccountMetaInfo, nameChangeEventListMetaInfo, accountChangeListMetaInfo, transactionAsFromAccountCount, transactionAsToAccountCount, nameChangeEventCount, accountChangeCount } = this.props.account
    if(!this.props.account.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Account",cardsFor: "account",
    	cardsSource: this.props.account,returnURL,displayName,
  		subItems: [
{name: 'transactionListAsFromAccount', displayName:'Transaction(Transaction List As From Account)',type:'transaction',count:transactionAsFromAccountCount,addFunction: true, role: 'transactionAsFromAccount', metaInfo: transactionListAsFromAccountMetaInfo, renderItem: GlobalComponents.TransactionBase.renderItemOfList},
{name: 'transactionListAsToAccount', displayName:'Transaction(Transaction List As To Account)',type:'transaction',count:transactionAsToAccountCount,addFunction: true, role: 'transactionAsToAccount', metaInfo: transactionListAsToAccountMetaInfo, renderItem: GlobalComponents.TransactionBase.renderItemOfList},
{name: 'nameChangeEventList', displayName:'Name Change Event',type:'nameChangeEvent',count:nameChangeEventCount,addFunction: true, role: 'nameChangeEvent', metaInfo: nameChangeEventListMetaInfo, renderItem: GlobalComponents.NameChangeEventBase.renderItemOfList},
{name: 'accountChangeList', displayName:'Account Change',type:'accountChange',count:accountChangeCount,addFunction: true, role: 'accountChange', metaInfo: accountChangeListMetaInfo, renderItem: GlobalComponents.AccountChangeBase.renderItemOfList},
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
       
        {renderExtraHeader(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
    )
  }
}

export default connect(state => ({
  account: state._account,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(AccountDashboard))

