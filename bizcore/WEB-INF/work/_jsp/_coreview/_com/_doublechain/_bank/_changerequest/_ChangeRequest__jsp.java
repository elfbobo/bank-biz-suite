/*
 * JSP generated by Resin-resin-3.1.15 (built Mon, 13 Oct 2014 03:54:20 PDT)
 */

package _jsp._coreview._com._doublechain._bank._changerequest;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.util.*;
import com.doublechain.bank.*;
import com.doublechain.bank.changerequest.ChangeRequest;

public class _ChangeRequest__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.PageContext _jsp_parentContext = pageContext;
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/plain; charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    com.caucho.jstl.rt.SetLocaleTag _jsp_SetLocaleTag_0 = null;
    com.caucho.jsp.IteratorLoopSupportTag _jsp_loop_0 = null;
    _jsp._tags._include__tag _jsp__include__tag_1 = null;
    _jsp._tags._include__tag _jsp__include__tag_2 = null;
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      if (_jsp_SetLocaleTag_0 == null) {
        _jsp_SetLocaleTag_0 = new com.caucho.jstl.rt.SetLocaleTag();
        _jsp_SetLocaleTag_0.setPageContext(pageContext);
        _jsp_SetLocaleTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_SetLocaleTag_0.setValue("zh_CN");
      }

      _jsp_SetLocaleTag_0.doStartTag();
      out.write('\n');
      pageContext.defaultSetOrRemove("ignoreListAccessControl", java.lang.Boolean.TRUE);
      out.write(_jsp_string1, 0, _jsp_string1.length);
      _caucho_expr_0.print(out, _jsp_env, false);
      out.write(_jsp_string2, 0, _jsp_string2.length);
      _caucho_expr_1.print(out, _jsp_env, false);
      out.write(_jsp_string3, 0, _jsp_string3.length);
      pageContext.requestSetOrRemove("ownerBeanName", "changeRequest");
      out.write('\n');
      pageContext.requestSetOrRemove("ownerClassName", "ChangeRequest");
      out.write(_jsp_string4, 0, _jsp_string4.length);
      if (_caucho_expr_2.evalBoolean(_jsp_env)) {
        out.write(_jsp_string5, 0, _jsp_string5.length);
        if (_jsp_loop_0 == null)
          _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
        java.lang.Object _jsp_items_5 = _caucho_expr_3.evalObject(_jsp_env);
        java.util.Iterator _jsp_iter_5 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_5);
        _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
        Object _jsp_oldVar_5 = pageContext.getAttribute("item");
        while (_jsp_iter_5.hasNext()) {
          Object _jsp_i_5 = _jsp_iter_5.next();
          pageContext.setAttribute("item", _jsp_i_5);
          _jsp_loop_0.setCurrent(_jsp_i_5, _jsp_iter_5.hasNext());
          out.write(_jsp_string6, 0, _jsp_string6.length);
          _caucho_expr_4.print(out, _jsp_env, false);
          out.write(' ');
          _caucho_expr_5.print(out, _jsp_env, false);
          out.write(_jsp_string7, 0, _jsp_string7.length);
        }
        pageContext.pageSetOrRemove("item", _jsp_oldVar_5);
        out.write(_jsp_string8, 0, _jsp_string8.length);
      }
      out.write(_jsp_string9, 0, _jsp_string9.length);
      _caucho_expr_6.print(out, _jsp_env, false);
      out.write(_jsp_string10, 0, _jsp_string10.length);
       ChangeRequest result = (ChangeRequest)request.getAttribute("result");  
      out.write(_jsp_string11, 0, _jsp_string11.length);
      _caucho_expr_7.print(out, _jsp_env, false);
      out.write(_jsp_string12, 0, _jsp_string12.length);
      _caucho_expr_8.print(out, _jsp_env, false);
      out.write(_jsp_string13, 0, _jsp_string13.length);
      _caucho_expr_9.print(out, _jsp_env, false);
      out.write(_jsp_string14, 0, _jsp_string14.length);
      pageContext.requestSetOrRemove("changeRequest", _caucho_expr_10.evalObject(_jsp_env));
      out.write('\n');
      _jsp__include__tag_1 = new _jsp._tags._include__tag();
      _jsp__include__tag_1.setJspContext(pageContext);
      _jsp__include__tag_1.setPage("com/doublechain/bank/changerequest/ChangeRequest$Summary.jsp");
      _jsp__include__tag_1.doTag();
      out.write(_jsp_string15, 0, _jsp_string15.length);
      pageContext.requestSetOrRemove("platform", _caucho_expr_11.evalObject(_jsp_env));
      out.write('\n');
      pageContext.requestSetOrRemove("referName", "");
      out.write('\n');
      _jsp__include__tag_1 = new _jsp._tags._include__tag();
      _jsp__include__tag_1.setJspContext(pageContext);
      _jsp__include__tag_1.setPage("com/doublechain/bank/platform/Platform$Info.jsp");
      _jsp__include__tag_1.doTag();
      out.write(_jsp_string16, 0, _jsp_string16.length);
      if (_caucho_expr_12.evalBoolean(_jsp_env)) {
        out.write(_jsp_string17, 0, _jsp_string17.length);
        pageContext.requestSetOrRemove("transactionList", _caucho_expr_13.evalObject(_jsp_env));
        out.write(_jsp_string17, 0, _jsp_string17.length);
        pageContext.requestSetOrRemove("transactionListName", "transactionList");
        out.write(_jsp_string18, 0, _jsp_string18.length);
        _jsp__include__tag_2 = new _jsp._tags._include__tag();
        _jsp__include__tag_2.setJspContext(pageContext);
        _jsp__include__tag_2.setReferName("changeRequest");
        _jsp__include__tag_2.setPage("com/doublechain/bank/transaction/Transaction$List.jsp");
        _jsp__include__tag_2.doTag();
        out.write(_jsp_string19, 0, _jsp_string19.length);
      }
      out.write(_jsp_string20, 0, _jsp_string20.length);
      if (_caucho_expr_14.evalBoolean(_jsp_env)) {
        out.write(_jsp_string17, 0, _jsp_string17.length);
        pageContext.requestSetOrRemove("nameChangeEventList", _caucho_expr_15.evalObject(_jsp_env));
        out.write(_jsp_string17, 0, _jsp_string17.length);
        pageContext.requestSetOrRemove("nameChangeEventListName", "nameChangeEventList");
        out.write(_jsp_string21, 0, _jsp_string21.length);
        _jsp__include__tag_2 = new _jsp._tags._include__tag();
        _jsp__include__tag_2.setJspContext(pageContext);
        _jsp__include__tag_2.setReferName("changeRequest");
        _jsp__include__tag_2.setPage("com/doublechain/bank/namechangeevent/NameChangeEvent$List.jsp");
        _jsp__include__tag_2.doTag();
        out.write(_jsp_string19, 0, _jsp_string19.length);
      }
      out.write(_jsp_string20, 0, _jsp_string20.length);
      if (_caucho_expr_16.evalBoolean(_jsp_env)) {
        out.write(_jsp_string17, 0, _jsp_string17.length);
        pageContext.requestSetOrRemove("accountChangeList", _caucho_expr_17.evalObject(_jsp_env));
        out.write(_jsp_string17, 0, _jsp_string17.length);
        pageContext.requestSetOrRemove("accountChangeListName", "accountChangeList");
        out.write(_jsp_string22, 0, _jsp_string22.length);
        _jsp__include__tag_2 = new _jsp._tags._include__tag();
        _jsp__include__tag_2.setJspContext(pageContext);
        _jsp__include__tag_2.setReferName("changeRequest");
        _jsp__include__tag_2.setPage("com/doublechain/bank/accountchange/AccountChange$List.jsp");
        _jsp__include__tag_2.doTag();
        out.write(_jsp_string19, 0, _jsp_string19.length);
      }
      out.write(_jsp_string23, 0, _jsp_string23.length);
      _caucho_expr_18.print(out, _jsp_env, false);
      out.write(_jsp_string24, 0, _jsp_string24.length);
      _caucho_expr_19.print(out, _jsp_env, false);
      out.write(_jsp_string24, 0, _jsp_string24.length);
      _caucho_expr_19.print(out, _jsp_env, false);
      out.write(_jsp_string25, 0, _jsp_string25.length);
      _caucho_expr_20.print(out, _jsp_env, false);
      out.write(_jsp_string26, 0, _jsp_string26.length);
      _caucho_expr_21.print(out, _jsp_env, false);
      out.write(_jsp_string27, 0, _jsp_string27.length);
      _caucho_expr_22.print(out, _jsp_env, false);
      out.write(_jsp_string28, 0, _jsp_string28.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      if (_jsp_SetLocaleTag_0 != null)
        _jsp_SetLocaleTag_0.release();
      _jsp_application.getJspApplicationContext().freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.server.util.CauchoSystem.getVersionId() != 3802963613949670813L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.vfs.Dependency depend;
      depend = (com.caucho.vfs.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void init(ServletConfig config)
    throws ServletException
  {
    com.caucho.server.webapp.WebApp webApp
      = (com.caucho.server.webapp.WebApp) config.getServletContext();
    super.init(config);
    com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
    manager.addTaglibFunctions(_jsp_functionMap, "c", "http://java.sun.com/jsp/jstl/core");
    manager.addTaglibFunctions(_jsp_functionMap, "fmt", "http://java.sun.com/jsp/jstl/fmt");
    manager.addTaglibFunctions(_jsp_functionMap, "fn", "http://java.sun.com/jsp/jstl/functions");
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${baseURL}");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@system_name']}");
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${not empty result.errorMessageList}");
    _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${result.errorMessageList}");
    _caucho_expr_4 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.sourcePosition}");
    _caucho_expr_5 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${item.body}");
    _caucho_expr_6 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@summary']}");
    _caucho_expr_7 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['transaction']}");
    _caucho_expr_8 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['name_change_event']}");
    _caucho_expr_9 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['account_change']}");
    _caucho_expr_10 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${ result}");
    _caucho_expr_11 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${ result.platform}");
    _caucho_expr_12 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${not empty userContext.accessTokens[\"transactionList\"] or ignoreListAccessControl}");
    _caucho_expr_13 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${result.transactionList}");
    _caucho_expr_14 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${not empty userContext.accessTokens[\"nameChangeEventList\"] or ignoreListAccessControl}");
    _caucho_expr_15 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${result.nameChangeEventList}");
    _caucho_expr_16 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${not empty userContext.accessTokens[\"accountChangeList\"] or ignoreListAccessControl}");
    _caucho_expr_17 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${result.accountChangeList}");
    _caucho_expr_18 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@home_page']}");
    _caucho_expr_19 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@message']}");
    _caucho_expr_20 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@log_out']}");
    _caucho_expr_21 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@qr_code']}");
    _caucho_expr_22 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@qr_scan_to_continue']}");
    new _jsp._tags._include__tag().init(config);
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("coreview/com/doublechain/bank/changerequest/ChangeRequest.jsp"), -1975837088959936691L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(mergePath.lookup("jar:file:/opt/resin-3.1.12/lib/resin.jar!/com/caucho/jstl/fmt.tld"), 8594578285720415164L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(com.caucho.jstl.rt.SetLocaleTag.class, -5807438068488217094L));
    depend = new com.caucho.vfs.Depend(appDir.lookup("tags/include.tag"), -1366740076671709024L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(_jsp._tags._include__tag.class, 5204705339566124878L));
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(_jsp._tags._include__tag.class, 5204705339566124878L));
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(_jsp._tags._include__tag.class, 5204705339566124878L));
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(_jsp._tags._include__tag.class, 5204705339566124878L));
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(_jsp._tags._include__tag.class, 5204705339566124878L));
  }

  static {
    try {
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;
  private static com.caucho.el.Expr _caucho_expr_3;
  private static com.caucho.el.Expr _caucho_expr_4;
  private static com.caucho.el.Expr _caucho_expr_5;
  private static com.caucho.el.Expr _caucho_expr_6;
  private static com.caucho.el.Expr _caucho_expr_7;
  private static com.caucho.el.Expr _caucho_expr_8;
  private static com.caucho.el.Expr _caucho_expr_9;
  private static com.caucho.el.Expr _caucho_expr_10;
  private static com.caucho.el.Expr _caucho_expr_11;
  private static com.caucho.el.Expr _caucho_expr_12;
  private static com.caucho.el.Expr _caucho_expr_13;
  private static com.caucho.el.Expr _caucho_expr_14;
  private static com.caucho.el.Expr _caucho_expr_15;
  private static com.caucho.el.Expr _caucho_expr_16;
  private static com.caucho.el.Expr _caucho_expr_17;
  private static com.caucho.el.Expr _caucho_expr_18;
  private static com.caucho.el.Expr _caucho_expr_19;
  private static com.caucho.el.Expr _caucho_expr_20;
  private static com.caucho.el.Expr _caucho_expr_21;
  private static com.caucho.el.Expr _caucho_expr_22;

  private final static char []_jsp_string2;
  private final static char []_jsp_string23;
  private final static char []_jsp_string15;
  private final static char []_jsp_string26;
  private final static char []_jsp_string16;
  private final static char []_jsp_string14;
  private final static char []_jsp_string17;
  private final static char []_jsp_string1;
  private final static char []_jsp_string28;
  private final static char []_jsp_string8;
  private final static char []_jsp_string18;
  private final static char []_jsp_string0;
  private final static char []_jsp_string7;
  private final static char []_jsp_string22;
  private final static char []_jsp_string10;
  private final static char []_jsp_string20;
  private final static char []_jsp_string12;
  private final static char []_jsp_string21;
  private final static char []_jsp_string6;
  private final static char []_jsp_string5;
  private final static char []_jsp_string25;
  private final static char []_jsp_string4;
  private final static char []_jsp_string11;
  private final static char []_jsp_string13;
  private final static char []_jsp_string24;
  private final static char []_jsp_string3;
  private final static char []_jsp_string27;
  private final static char []_jsp_string19;
  private final static char []_jsp_string9;
  static {
    _jsp_string2 = "/\" />    \n    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n    <meta name=\"description\" content=\"\">\n    <meta name=\"author\" content=\"\">\n   \n    <title>  ".toCharArray();
    _jsp_string23 = "\n\n	\n\n</div><!--<div class=\"tab-content\" style=\"padding-top: 10px\">-->\n\n\n\n\n <!-- /real content -->\n          \n          \n          </div>\n        </div><!--  <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\"> -->\n        </div><!-- <div class=\"row\"> -->\n        </div>\n        \n  \n<div id=\"footer\">\n  <div class=\"col-xs-12 navbar-inverse navbar-fixed-bottom\">\n  <div class=\"row\" id=\"bottomNav\">\n    <div class=\"col-xs-3 text-center\">\n    	<a href=\"./secUserManager/home/\"><i class=\"glyphicon glyphicon-home\"></i><br/>".toCharArray();
    _jsp_string15 = "\n\n	\n</div>\n\n	\n	\n\n	<div class=\"row\">\n".toCharArray();
    _jsp_string26 = "</a>\n    </div>\n  </div>\n  </div>\n</div>   <!-- --><!-- /.footer -->\n        \n    <!-- Bootstrap core JavaScript\n    ================================================== -->\n    <!-- Placed at the end of the document so the pages load faster -->\n    <script src=\"./bootstrap/jquery.min.js\"></script>\n    <script src=\"./bootstrap/jquery-ui.min.js\"></script>\n    \n    <script>window.jQuery || document.write('<script src=\"../../assets/js/vendor/jquery.min.js\"><\\/script>')</script>\n    <script src=\"./bootstrap/bootstrap.min.js\"></script>\n    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->\n    <script src=\"./bootstrap/holder.min.js\"></script>\n    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n    <script src=\"./bootstrap/ie10-viewport-bug-workaround.js\"></script>\n    <script src=\"./scripts/qrcode.js\" type=\"text/javascript\"></script>    \n    <script>\n\n 	var qrLocaleLabel = \"".toCharArray();
    _jsp_string16 = "\n\n</div>\n\n\n\n\n\n\n\n\n	\n\n\n\n\n\n	</div><!-- end of <div id=\"summary\" class=\"tab-pane fade in active\">-->\n\n	\n\n		".toCharArray();
    _jsp_string14 = "</a></li>\n \n	</ul>\n	</div>\n</div>\n<div class=\"tab-content\"  id='tab-content'>\n<div id=\"summary\" class=\"tab-pane fade in active\">\n<div class=\"row\">\n	\n	<div class=\"col-xs-12 col-md-12\">\n	\n	</div>\n</div>\n\n<div class=\"row\" desc=\"show parent objects\">\n	\n	   \n	".toCharArray();
    _jsp_string17 = "\n		".toCharArray();
    _jsp_string1 = "\n\n\n<!DOCTYPE html>\n<html lang=\"en\" slick-uniqueid=\"3\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n	<base href=\"".toCharArray();
    _jsp_string28 = "\";\n 	$(\"a[data-toggle='tab']\").removeClass(\"disabled\");\n 	\n	\n</script>\n     <script src=\"./scripts/common.js\" type=\"text/javascript\"></script>\n     <script src=\"./bootstrap/bootstrap3-typeahead.js\" type=\"text/javascript\"></script>\n\n\n</body></html>\n\n\n".toCharArray();
    _jsp_string8 = "\n    	</ul>\n    ".toCharArray();
    _jsp_string18 = "\n		<div id=\"transactionList\" class=\"tab-pane fade sublist\" refer-name=\"change_request\">\n			".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n\n\n".toCharArray();
    _jsp_string7 = "\n</div>\n    	".toCharArray();
    _jsp_string22 = "\n		<div id=\"accountChangeList\" class=\"tab-pane fade sublist\" refer-name=\"change_request\">\n			".toCharArray();
    _jsp_string10 = "</a></li>\n	 \n	".toCharArray();
    _jsp_string20 = "\n	".toCharArray();
    _jsp_string12 = "</a></li>\n			<li><a data-toggle=\"tab\" href=\"#nameChangeEventList\" class=\"disabled\"> ".toCharArray();
    _jsp_string21 = "\n		<div id=\"nameChangeEventList\" class=\"tab-pane fade sublist\" refer-name=\"change_request\">\n			".toCharArray();
    _jsp_string6 = "\n    		\n    		<div class=\"alert alert-success\">\n   ".toCharArray();
    _jsp_string5 = "\n    <ul>\n    	".toCharArray();
    _jsp_string25 = "</a>\n    </div>\n    <div class=\"col-xs-3 text-center\">\n    	<a href=\"./secUserManager/showlogin/\">\n    	<i class=\"glyphicon glyphicon-user\"></i><br>".toCharArray();
    _jsp_string4 = "\n\n\n\n\n<div id=\"msg\"></div>\n\n<div class=\"row\">\n\n	<div class=\"col-xs-12 col-md-12\">\n			    ".toCharArray();
    _jsp_string11 = "\n			<li><a data-toggle=\"tab\" href=\"#transactionList\" class=\"disabled\"> ".toCharArray();
    _jsp_string13 = "</a></li>\n			<li><a data-toggle=\"tab\" href=\"#accountChangeList\" class=\"disabled\"> ".toCharArray();
    _jsp_string24 = "</a>\n    </div>\n    <div class=\"col-xs-3 text-center\">\n    	<a href=\"./secUserManager/home/\"><i class=\"glyphicon glyphicon-envelope\"></i><br>".toCharArray();
    _jsp_string3 = " </title>\n\n    <!-- Bootstrap core CSS -->\n    <link href=\"./bootstrap/bootstrap.min.css\" rel=\"stylesheet\">\n\n    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n    <link href=\"./bootstrap/ie10-viewport-bug-workaround.css\" rel=\"stylesheet\">\n 	<link href=\"./bootstrap/jquery-ui.css\" rel=\"stylesheet\">\n    <!-- Custom styles for this template -->\n    <link href=\"./bootstrap/dashboard.css\" rel=\"stylesheet\">\n    <link href=\"./bootstrap/font-awesome.min.css\" rel=\"stylesheet\">\n   \n   \n\n    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->\n    <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\n    <script src=\"./bootstrap/ie-emulation-modes-warning.js\"></script>\n\n    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n    <!--[if lt IE 9]>\n      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n    <![endif]-->\n <style type=\"text/css\">* {\n text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; \n}\n\n</style>\n\n\n</head>\n\n  <body >\n\n\n    <div class=\"container-fluid\">\n      <div class=\"row\">\n      \n        <div class=\"col-xs-12 col-sm-12  col-md-12  main\">\n          \n          <div class=\"table-responsive\" id=\"content\">\n          <!-- real content -->\n\n".toCharArray();
    _jsp_string27 = "\";\n 	var scanQRTips = \"".toCharArray();
    _jsp_string19 = "\n		</div>\n	".toCharArray();
    _jsp_string9 = "\n</div>\n\n\n\n</div> <!--<div class=\"row\">-->\n\n<div class=\"row\">\n	\n</div>\n\n<div class=\"row\">\n	\n	<div class=\"col-xs-12 col-md-12\">\n\n	<ul class=\"nav nav-tabs\" id=\"navi-tabs\">\n	  <li class=\"active\"><a data-toggle=\"tab\" href=\"#summary\" class=\"disabled\"><i class=\"fa  fa-home\"></i> ".toCharArray();
  }
}
