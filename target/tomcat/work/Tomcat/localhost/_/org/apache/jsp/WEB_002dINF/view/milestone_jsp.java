/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-25 20:15:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class milestone_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/view/common/nav.jsp", Long.valueOf(1550855265935L));
    _jspx_dependants.put("/WEB-INF/view/common/header.jsp", Long.valueOf(1551125092417L));
    _jspx_dependants.put("/WEB-INF/view/common/footer.jsp", Long.valueOf(1550854208311L));
    _jspx_dependants.put("/WEB-INF/view/common/projectNav.jsp", Long.valueOf(1551100094385L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005faction;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005faction.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns:th=\"http://www.thymeleaf.org\">\r\n");
      out.write("<head th:include=\"layout :: head(title=~{::title},links=~{})\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/style.css\">\r\n");
      out.write("\r\n");
      out.write("<title></title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("<title>Milestones</title>\r\n");
      out.write("<div class=\"head\">\r\n");
      out.write("\t<div class=\"home\">\r\n");
      out.write("\t\t<a href=\"home\" style=\"color: black; text-decoration-line: none;\"><font\r\n");
      out.write("\t\t\tsize=\"5\" style=\"padding: 10px;\">Home</font></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"dropdown\"\r\n");
      out.write("\t\tstyle=\"float: right; margin-top: 10px; margin-right: 50px;\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-primary dropdown-toggle\"\r\n");
      out.write("\t\t\tdata-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t<span class=\"glyphicon glyphicon-user\"></span>\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t<div class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t<a class=\"dropdown-item\" href=\"/profile\">View Profile</a> <a\r\n");
      out.write("\t\t\t\tclass=\"dropdown-item\" href=\"/logout\">Logout</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"float: right; margin-top: 10px; margin-right: 5px;\">\r\n");
      out.write("\t<a href=\"/notifications\">\r\n");
      out.write("\t<button type=\"button\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t<i class=\"glyphicon glyphicon-bell notification-icon\"></i>\r\n");
      out.write("\t</button>\r\n");
      out.write("\t</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("<body style=\"background-color: #A0A0A0;\">\r\n");
      out.write("<div style=\"height: auto; width: 10%; padding: 0px; float: left;\">\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t<li><a href=\"/projects\">All Projects</a></li>\r\n");
      out.write("\t\t<li><a href=\"/project\">Project</a></li>\r\n");
      out.write("\t\t<li><a href=\"/milestone\">Milestones</a></li>\r\n");
      out.write("\t\t<li><a href=\"/report\">Reports</a></li>\r\n");
      out.write("\t\t<li><a href=\"/meeting\">Meetings</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div\r\n");
      out.write("\tstyle=\"width: 90%; float: left; padding: 10px; height: 1400px; background-color: white; overflow-y: auto;\">\r\n");
      out.write("\t<div style=\"width: 100%; float: left;\">\r\n");
      out.write("\t\t<h1 class=\"heading\" style=\"margin-right: 5px; width: 160px;\">Milestone</h1>\r\n");
      out.write("\t\t<h1 class=\"heading\" style=\"margin-right: 5px; width: 180px;\">Date Created</h1>\r\n");
      out.write("\t\t<h1 class=\"heading\" style=\"margin-right: 5px; width: 180px;\">Start\r\n");
      out.write("\t\t\tDate</h1>\r\n");
      out.write("\t\t<h1 class=\"heading\" style=\"margin-right: 5px; width: 180px;\">End\r\n");
      out.write("\t\t\tDate</h1>\r\n");
      out.write("\t\t<h1 class=\"heading\" style=\"margin-right: 5px; width: 180px;\">Status\r\n");
      out.write("\t\t</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<hr class=\"hr\"\r\n");
      out.write("\t\tstyle=\"width: 100%; height: 1px; background-color: black; float: left; display: block;\">\r\n");
      out.write("\t<div class=\"panel-group\" id=\"accordion\"\r\n");
      out.write("\t\tstyle=\"float: left; width: 100%;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${view}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- ADD MILESTONE BUTTON -->\r\n");
      out.write("\t<button type=\"submit\" class=\"btn btn-primary\"\r\n");
      out.write("\t\tstyle=\"border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 25%;\"\r\n");
      out.write("\t\tonclick=\"document.getElementById('form').style.display='block'\">Add\r\n");
      out.write("\t\tMilestone</button>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"form\" class=\"panel panel-default\"\r\n");
      out.write("\t\tstyle=\"background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 25px; display: none;\">\r\n");
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_form_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<form action=\"/milestone\">\r\n");
      out.write("\t\t\t<button type=\"submit\" id=\"cancel\" class=\"btn btn-success\"\r\n");
      out.write("\t\t\t\tstyle=\"border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(30, 250, 35); color: rgb(255, 255, 255); width: 60%;\">Cancel</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/webjars/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/webjars/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_form_005fform_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005faction.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_form_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_form_005fform_005f0.setParent(null);
    // /WEB-INF/view/milestone.jsp(39,2) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setAction("/milestone/addMilestone");
    // /WEB-INF/view/milestone.jsp(39,2) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setMethod("post");
    int[] _jspx_push_body_count_form_005fform_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_form_005fform_005f0 = _jspx_th_form_005fform_005f0.doStartTag();
      if (_jspx_eval_form_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<center>\r\n");
          out.write("\t\t\t\t<div class=\"form-group\" style=\"margin-top: 40px;\">\r\n");
          out.write("\t\t\t\t\t<label for=\"milestoneName\">Milestone Name:</label> <input type=\"text\"\r\n");
          out.write("\t\t\t\t\t\tclass=\"form-control\" id=\"milestoneName\"\r\n");
          out.write("\t\t\t\t\t\tplaceholder=\"Enter Milestone Name\" name=\"milestoneName\"\r\n");
          out.write("\t\t\t\t\t\tstyle=\"width: 60%;\" required=\"required\" />\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t</center>\r\n");
          out.write("\r\n");
          out.write("\t\t\t<button type=\"submit\" class=\"btn btn-default\"\r\n");
          out.write("\t\t\t\tstyle=\"border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: 60%;\">Submit</button>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_form_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_form_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005fform_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005fform_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005fform_005f0.doFinally();
      _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005faction.reuse(_jspx_th_form_005fform_005f0);
    }
    return false;
  }
}
