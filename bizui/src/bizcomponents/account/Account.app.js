import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,Row, Col,
  Input,Button
} from 'antd'
import TopMenu from '../../launcher/TopMenu'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Account.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
import BizAppTool from '../../common/BizApp.tool'

const { Header, Sider, Content } = Layout
const { SubMenu } = Menu
const {
  defaultFilteredNoGroupMenuItems,
  defaultFilteredMenuItemsGroup,
  defaultRenderMenuItem,

} = BizAppTool


const filteredNoGroupMenuItems = defaultFilteredNoGroupMenuItems
const filteredMenuItemsGroup = defaultFilteredMenuItemsGroup
const renderMenuItem=defaultRenderMenuItem



const userBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const searchBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 12,
  xl: 12,
  
};


const naviBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class AccountBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/account/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
	  <Menu
        theme="dark"
        mode="inline"
        
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        style={{ width: '256px' }}
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/account/${this.props.account.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
           </Menu>
    )
  }
  



  getTransactionAsFromAccountSearch = () => {
    const {TransactionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "事务(付款)",
      role: "transactionAsFromAccount",
      data: state._account.transactionListAsFromAccount,
      metaInfo: state._account.transactionListAsFromAccountMetaInfo,
      count: state._account.transactionAsFromAccountCount,
      returnURL: `/account/${state._account.id}/dashboard`,
      currentPage: state._account.transactionAsFromAccountCurrentPageNumber,
      searchFormParameters: state._account.transactionAsFromAccountSearchFormParameters,
      searchParameters: {...state._account.searchParameters},
      expandForm: state._account.expandForm,
      loading: state._account.loading,
      partialList: state._account.partialList,
      owner: { type: '_account', id: state._account.id, 
      referenceName: 'fromAccount', 
      listName: 'transactionListAsFromAccount', ref:state._account, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransactionSearch)
  }
  getTransactionAsFromAccountCreateForm = () => {
   	const {TransactionCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "transactionAsFromAccount",
      data: state._account.transactionListAsFromAccount,
      metaInfo: state._account.transactionListAsFromAccountMetaInfo,
      count: state._account.transactionAsFromAccountCount,
      returnURL: `/account/${state._account.id}/list`,
      currentPage: state._account.transactionAsFromAccountCurrentPageNumber,
      searchFormParameters: state._account.transactionAsFromAccountSearchFormParameters,
      loading: state._account.loading,
      owner: { type: '_account', id: state._account.id, referenceName: 'fromAccount', listName: 'transactionListAsFromAccount', ref:state._account, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TransactionCreateForm)
  }
  
  getTransactionAsFromAccountUpdateForm = () => {
    const userContext = null
  	const {TransactionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._account.selectedRows,
      role: "transactionAsFromAccount",
      currentUpdateIndex: state._account.currentUpdateIndex,
      owner: { type: '_account', id: state._account.id, listName: 'transactionListAsFromAccount', ref:state._account, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransactionUpdateForm)
  }

  getTransactionAsToAccountSearch = () => {
    const {TransactionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "事务(收款)",
      role: "transactionAsToAccount",
      data: state._account.transactionListAsToAccount,
      metaInfo: state._account.transactionListAsToAccountMetaInfo,
      count: state._account.transactionAsToAccountCount,
      returnURL: `/account/${state._account.id}/dashboard`,
      currentPage: state._account.transactionAsToAccountCurrentPageNumber,
      searchFormParameters: state._account.transactionAsToAccountSearchFormParameters,
      searchParameters: {...state._account.searchParameters},
      expandForm: state._account.expandForm,
      loading: state._account.loading,
      partialList: state._account.partialList,
      owner: { type: '_account', id: state._account.id, 
      referenceName: 'toAccount', 
      listName: 'transactionListAsToAccount', ref:state._account, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransactionSearch)
  }
  getTransactionAsToAccountCreateForm = () => {
   	const {TransactionCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "transactionAsToAccount",
      data: state._account.transactionListAsToAccount,
      metaInfo: state._account.transactionListAsToAccountMetaInfo,
      count: state._account.transactionAsToAccountCount,
      returnURL: `/account/${state._account.id}/list`,
      currentPage: state._account.transactionAsToAccountCurrentPageNumber,
      searchFormParameters: state._account.transactionAsToAccountSearchFormParameters,
      loading: state._account.loading,
      owner: { type: '_account', id: state._account.id, referenceName: 'toAccount', listName: 'transactionListAsToAccount', ref:state._account, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TransactionCreateForm)
  }
  
  getTransactionAsToAccountUpdateForm = () => {
    const userContext = null
  	const {TransactionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._account.selectedRows,
      role: "transactionAsToAccount",
      currentUpdateIndex: state._account.currentUpdateIndex,
      owner: { type: '_account', id: state._account.id, listName: 'transactionListAsToAccount', ref:state._account, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransactionUpdateForm)
  }

  getNameChangeEventSearch = () => {
    const {NameChangeEventSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "名字更改事件",
      role: "nameChangeEvent",
      data: state._account.nameChangeEventList,
      metaInfo: state._account.nameChangeEventListMetaInfo,
      count: state._account.nameChangeEventCount,
      returnURL: `/account/${state._account.id}/dashboard`,
      currentPage: state._account.nameChangeEventCurrentPageNumber,
      searchFormParameters: state._account.nameChangeEventSearchFormParameters,
      searchParameters: {...state._account.searchParameters},
      expandForm: state._account.expandForm,
      loading: state._account.loading,
      partialList: state._account.partialList,
      owner: { type: '_account', id: state._account.id, 
      referenceName: 'account', 
      listName: 'nameChangeEventList', ref:state._account, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NameChangeEventSearch)
  }
  getNameChangeEventCreateForm = () => {
   	const {NameChangeEventCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "nameChangeEvent",
      data: state._account.nameChangeEventList,
      metaInfo: state._account.nameChangeEventListMetaInfo,
      count: state._account.nameChangeEventCount,
      returnURL: `/account/${state._account.id}/list`,
      currentPage: state._account.nameChangeEventCurrentPageNumber,
      searchFormParameters: state._account.nameChangeEventSearchFormParameters,
      loading: state._account.loading,
      owner: { type: '_account', id: state._account.id, referenceName: 'account', listName: 'nameChangeEventList', ref:state._account, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(NameChangeEventCreateForm)
  }
  
  getNameChangeEventUpdateForm = () => {
    const userContext = null
  	const {NameChangeEventUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._account.selectedRows,
      role: "nameChangeEvent",
      currentUpdateIndex: state._account.currentUpdateIndex,
      owner: { type: '_account', id: state._account.id, listName: 'nameChangeEventList', ref:state._account, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NameChangeEventUpdateForm)
  }

  getAccountChangeSearch = () => {
    const {AccountChangeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "账户变更",
      role: "accountChange",
      data: state._account.accountChangeList,
      metaInfo: state._account.accountChangeListMetaInfo,
      count: state._account.accountChangeCount,
      returnURL: `/account/${state._account.id}/dashboard`,
      currentPage: state._account.accountChangeCurrentPageNumber,
      searchFormParameters: state._account.accountChangeSearchFormParameters,
      searchParameters: {...state._account.searchParameters},
      expandForm: state._account.expandForm,
      loading: state._account.loading,
      partialList: state._account.partialList,
      owner: { type: '_account', id: state._account.id, 
      referenceName: 'account', 
      listName: 'accountChangeList', ref:state._account, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountChangeSearch)
  }
  getAccountChangeCreateForm = () => {
   	const {AccountChangeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "accountChange",
      data: state._account.accountChangeList,
      metaInfo: state._account.accountChangeListMetaInfo,
      count: state._account.accountChangeCount,
      returnURL: `/account/${state._account.id}/list`,
      currentPage: state._account.accountChangeCurrentPageNumber,
      searchFormParameters: state._account.accountChangeSearchFormParameters,
      loading: state._account.loading,
      owner: { type: '_account', id: state._account.id, referenceName: 'account', listName: 'accountChangeList', ref:state._account, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountChangeCreateForm)
  }
  
  getAccountChangeUpdateForm = () => {
    const userContext = null
  	const {AccountChangeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._account.selectedRows,
      role: "accountChange",
      currentUpdateIndex: state._account.currentUpdateIndex,
      owner: { type: '_account', id: state._account.id, listName: 'accountChangeList', ref:state._account, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountChangeUpdateForm)
  }


  
  buildRouters = () =>{
  	const {AccountDashboard} = GlobalComponents
  	const {AccountPermission} = GlobalComponents
  	const {AccountProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/account/:id/dashboard", component: AccountDashboard},
  	{path:"/account/:id/profile", component: AccountProfile},
  	{path:"/account/:id/permission", component: AccountPermission},
  	
  	
  	
  	{path:"/account/:id/list/transactionListAsFromAccount", component: this.getTransactionAsFromAccountSearch()},
  	{path:"/account/:id/list/transactionAsFromAccountCreateForm", component: this.getTransactionAsFromAccountCreateForm()},
  	{path:"/account/:id/list/transactionAsFromAccountUpdateForm", component: this.getTransactionAsFromAccountUpdateForm()},
   	
  	{path:"/account/:id/list/transactionListAsToAccount", component: this.getTransactionAsToAccountSearch()},
  	{path:"/account/:id/list/transactionAsToAccountCreateForm", component: this.getTransactionAsToAccountCreateForm()},
  	{path:"/account/:id/list/transactionAsToAccountUpdateForm", component: this.getTransactionAsToAccountUpdateForm()},
   	
  	{path:"/account/:id/list/nameChangeEventList", component: this.getNameChangeEventSearch()},
  	{path:"/account/:id/list/nameChangeEventCreateForm", component: this.getNameChangeEventCreateForm()},
  	{path:"/account/:id/list/nameChangeEventUpdateForm", component: this.getNameChangeEventUpdateForm()},
   	
  	{path:"/account/:id/list/accountChangeList", component: this.getAccountChangeSearch()},
  	{path:"/account/:id/list/accountChangeCreateForm", component: this.getAccountChangeCreateForm()},
  	{path:"/account/:id/list/accountChangeUpdateForm", component: this.getAccountChangeUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '银行模拟平台'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
     const userContext = null
     const renderBreadcrumbText=(value)=>{
     	if(value==null){
     		return "..."
     	}
     	if(value.length < 10){
     		return value
     	}
     
     	return value.substring(0,10)+"..."
     	
     	
     }
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const renderBreadcrumbMenuItem=(breadcrumbMenuItem)=>{

      return (
      <Menu.Item key={breadcrumbMenuItem.link}>
      <Link key={breadcrumbMenuItem.link} to={`${breadcrumbMenuItem.link}`} className={styles.breadcrumbLink}>
        <Icon type="heart" style={{marginRight:"10px",color:"red"}} />
        {renderBreadcrumbText(breadcrumbMenuItem.name)}
      </Link></Menu.Item>)

     }
     const breadcrumbMenu=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <Menu mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbMenuItem(item))}
      </Menu>)
  

     }
     const { Search } = Input;
     const layout = (
     <Layout>
 <Header>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
            <Dropdown overlay= {this.getNavMenuItems(this.props.account)}>
              <a  className={styles.menuLink}>
                <Icon type="unordered-list" style={{fontSize:"20px", marginRight:"10px"}}/> 菜单
              </a>
            </Dropdown>            
            <Dropdown overlay={breadcrumbMenu()}>
              <a  className={styles.menuLink}>
                <Icon type="down" style={{fontSize:"20px", marginRight:"10px"}}/> 快速转到
              </a>
            </Dropdown>
        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  > 
          
          <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释,暂未实现" enterButton 
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />
          </Col>
          <Col  {...userBarResponsiveStyle}  > 
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                  <Icon type="user" style={{fontSize:"20px",marginRight:"10px"}}/> 账户
                </a>
            </Dropdown>
            
           </Col>  
         
         </Row>
        </Header>
       <Layout>
       
         
         <Layout>
         
            
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  account: state._account,
  ...state,
}))(AccountBizApp)



