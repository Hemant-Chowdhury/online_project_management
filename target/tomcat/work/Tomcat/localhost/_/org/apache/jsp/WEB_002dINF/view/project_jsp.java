/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-18 14:27:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class project_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/view/common/nav.jsp", Long.valueOf(1550398774005L));
    _jspx_dependants.put("/WEB-INF/view/common/header.jsp", Long.valueOf(1550481339317L));
    _jspx_dependants.put("/WEB-INF/view/common/footer.jsp", Long.valueOf(1549828845969L));
    _jspx_dependants.put("/WEB-INF/view/common/projectNav.jsp", Long.valueOf(1550398842026L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("<title>Project</title>\r\n");
      out.write("<div class=\"head\">\r\n");
      out.write("\t\t<div class=\"home\">\r\n");
      out.write("\t\t\t<a href=\"home.html\" style=\"color: black; text-decoration-line: none;\"><font\r\n");
      out.write("\t\t\t\tsize=\"5\" style=\"padding: 10px;\">Home</font></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"dropdown\"\r\n");
      out.write("\t\t\tstyle=\"float: right; margin-top: 10px; margin-right: 50px;\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-primary dropdown-toggle\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t<span class=\"glyphicon glyphicon-user\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<div class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t<a class=\"dropdown-item\" href=\"/user/profile\">View Profile</a>\r\n");
      out.write("\t\t\t\t <a class=\"dropdown-item\" href=\"/logout\">Logout</a> \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"dropdown\"\r\n");
      out.write("\t\t\tstyle=\"float: right; margin-top: 10px; margin-right: 20px;\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-primary dropdown-toggle\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t<span class=\"glyphicon glyphicon-bell\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<div class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t<div class=\"panel-heading\">Notifications</div>\r\n");
      out.write("\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown-item\">First item</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown-item\">Second item</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown-item\">Third item</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("<body style=\"background-color: #A0A0A0;\">\r\n");
      out.write("<div style=\"height: auto; width: 10%; padding: 0px; float: left;\">\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t<li><a href=\"/project\">Project</a></li>\r\n");
      out.write("\t\t<li><a href=\"/milestone\">Milestones</a></li>\r\n");
      out.write("\t\t<li><a href=\"/report\">Reports</a></li>\r\n");
      out.write("\t\t<li><a href=\"/meet\">Meetings</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div\r\n");
      out.write("\tstyle=\"width: 90%; float: left; padding: 10px; height: 800px; background-color: white;\">\r\n");
      out.write("\t<div style=\"width: 100%; float: left;\">\r\n");
      out.write("\t\t<h1 class=\"heading\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.getProjectName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<hr class=\"hr\"\r\n");
      out.write("\t\tstyle=\"width: 100%; height: 1px; background-color: black; float: left; display: block;\">\r\n");
      out.write("\t<div\r\n");
      out.write("\t\tstyle=\"width: 32%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;\">\r\n");
      out.write("\t\t<div style=\"width: 100%; float: left;\">\r\n");
      out.write("\t\t\t<h4 class=\"heading\" style=\"margin-left: 0px;\">Project\r\n");
      out.write("\t\t\t\tParticipants</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<hr class=\"hr\"\r\n");
      out.write("\t\t\tstyle=\"width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;\">\r\n");
      out.write("\t\t<div style=\"height: auto; width: 100%; padding: 0px; float: left;\">\r\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${listParticipant}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<button class=\"btn btn-warning\" style=\"width: 100%\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#demo\">Add Participant</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form action=\"/project/addParticipant\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"input-group\" style=\"margin-top: 3px;\">\r\n");
      out.write("\t\t\t\t\t<span class=\"input-group-addon\" style=\"width: auto; height: 34px;\"><div\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"margin-top: 2px;\">Participant Name</div></span> <input\r\n");
      out.write("\t\t\t\t\t\tid=\"username\" type=\"text\" class=\"form-control\" name=\"username\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Enter username\" style=\"height: auto;\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"input-group\" style=\"margin-top: 3px;\">\r\n");
      out.write("\t\t\t\t\t<span class=\"input-group-addon\" style=\"width: auto; height: 34px;\"><div\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"margin-top: 2px;\">Type</div></span> <input id=\"Type\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control\" placeholder=\"Enter Manager/Developer\"\r\n");
      out.write("\t\t\t\t\t\tname=\"type\" style=\"height: auto;\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-default\"\r\n");
      out.write("\t\t\t\t\tstyle=\"border: 0px; height: 18px; width: auto; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 12px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: right; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255);\">Submit</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div\r\n");
      out.write("\t\tstyle=\"width: 32%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;\">\r\n");
      out.write("\t\t<div style=\"width: 100%; float: left;\">\r\n");
      out.write("\t\t\t<h4 class=\"heading\" style=\"margin-left: 0px;\">Project Details</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<hr class=\"hr\"\r\n");
      out.write("\t\t\tstyle=\"width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;\">\r\n");
      out.write("\t\t<div style=\"height: auto; width: 100%; padding: 0px; float: left;\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li class=\"list-group-item\" style=\"margin: 2px;\"><b>Created\r\n");
      out.write("\t\t\t\t\t\tby:</b> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.getOwner()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</li>\r\n");
      out.write("\t\t\t\t<li class=\"list-group-item\" style=\"margin: 2px;\"><b>Date\r\n");
      out.write("\t\t\t\t\t\tCreated:</b> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.getTimestamp()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</li>\r\n");
      out.write("\t\t\t\t<li class=\"list-group-item\" style=\"margin: 2px;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"comment\">Project Description:</label>\r\n");
      out.write("\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"5\" id=\"comment\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"border-radius: 1px; resize: none;\" disabled>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.getDescription() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </textarea>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div\r\n");
      out.write("\t\tstyle=\"width: 32%; float: left; padding: 10px; height: 500px; background-color: #ddd; margin: 5px; overflow-y: auto;\">\r\n");
      out.write("\t\t<div style=\"width: 100%; float: left;\">\r\n");
      out.write("\t\t\t<h4 class=\"heading\" style=\"margin-left: 0px;\">Forum</h4>\r\n");
      out.write("\t\t\t<div id=\"displayarea\" name=\"displayarea\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<hr class=\"hr\"\r\n");
      out.write("\t\t\tstyle=\"width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var url = '/project/getChat'\r\n");
      out.write(" \r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write(" \r\n");
      out.write("$.ajaxSetup({ cache: false }); \r\n");
      out.write(" \r\n");
      out.write("setInterval(function() {$(\"#displayarea\").load(url); }, 1000);\r\n");
      out.write(" \r\n");
      out.write("});\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("</script>\r\n");
      out.write("\t<form name=\"sendMessage\" action=\"/project/sendMessage\" method=\"post\"\r\n");
      out.write("\t\tstyle=\"float: right; width: 32%; margin-right: 20px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"input-group\" style=\"margin-top: 3px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<textarea id=\"message\" name=\"message\" class=\"form-control\" rows=\"0\" placeholder = \"Enter message\"\r\n");
      out.write("\t\t\t\tstyle=\"border-radius: 10px; margin-top: 5px; margin-left: -7px; resize: none;\"></textarea>\r\n");
      out.write("\t\t\t<button type=\"submit\"  class=\"btn btn-success\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 12%; height: 30px; margin-top: 8px; margin-left: 4px; margin-right: 5px; padding: 2px;\">\r\n");
      out.write("\t\t\t\t<span class=\"glyphicon glyphicon-send \" style=\"margin: 2px;\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/webjars/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/webjars/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
}