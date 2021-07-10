package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class makequiz_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/common/header.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Make Quiz</title>\n");
      out.write("        <link href=\"./template/css/makequiz.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"./template/css/common.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"./template/css/header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"header-container\">\n");
      out.write("            <ul class=\"header\">\n");
      out.write("                <li><a class=\"header-item\" href=\"home\">Home</a></li>\n");
      out.write("                <li><a class=\"header-item\" href=\"takequiz\">Take Quiz</a></li>\n");
      out.write("                <li><a class=\"header-item\" href=\"makequiz\">Make Quiz</a></li>\n");
      out.write("                <li><a class=\"header-item\" href=\"managequiz\">Manage Quiz</a></li>\n");
      out.write("                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </header>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("            <div class=\"content-container\">\n");
      out.write("                <form id=\"make-form\" class=\"form\" method=\"POST\" action=\"makequiz\">\n");
      out.write("                    <div class=\"form-item\">\n");
      out.write("                        <label for=\"question\" class=\"label\">Question: </label>\n");
      out.write("                        <textarea id=\"question\" required name=\"question\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.question}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    </div>   \n");
      out.write("                    <div class=\"form-item\">\n");
      out.write("                        <label for=\"option1\" class=\"label\">Option1: </label>   \n");
      out.write("                        <textarea id=\"option1\" required name=\"option1\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.option1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-item\">\n");
      out.write("                        <label for=\"option2\" class=\"label\">Option2: </label>     \n");
      out.write("                        <textarea id=\"option2\" required name=\"option2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.option2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-item\">\n");
      out.write("                        <label for=\"option3\" class=\"label\">Option3: </label>\n");
      out.write("                        <textarea id=\"option3\" required name=\"option3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.option3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-item\">\n");
      out.write("                        <label for=\"option4\" class=\"label\">Option4: </label> \n");
      out.write("                        <textarea id=\"option4\" required name=\"option4\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.option4}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-item\">  \n");
      out.write("                        <label class=\"label\">Answer(s):</label> \n");
      out.write("                        <div class=\"option-container\">\n");
      out.write("                            <div class=\"option-item\">\n");
      out.write("                                <input class=\"option-answer\"  name=\"op1\" id=\"op1\" type=\"checkbox\" value=\"true\"/>\n");
      out.write("                                <label class=\"form-label op-label\" for=\"op1\">Option 1</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"option-item\">\n");
      out.write("                                <input class=\"option-answer\" name=\"op2\" id=\"op2\" type=\"checkbox\" value=\"true\"/>\n");
      out.write("                                <label class=\"form-label op-label\" for=\"op2\">Option 2</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"option-item\">\n");
      out.write("                                <input class=\"option-answer\" name=\"op3\" id=\"op3\" type=\"checkbox\" value=\"true\"/> \n");
      out.write("                                <label class=\"form-label op-label\" for=\"op3\">Option 3</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"option-item\">\n");
      out.write("                                <input class=\"option-answer\" name=\"op4\" id=\"op4\" type=\"checkbox\" value=\"true\"/> \n");
      out.write("                                <label class=\"form-label op-label\" for=\"op4\">Option 4</label>       \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>                      \n");
      out.write("                    <div class=\"mess\">\n");
      out.write("                        <input id=\"btn-save\" class=\"button save-btn\" type=\"submit\" value=\"Save\"/> \n");
      out.write("                        <h5 id=\"mess\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h5>  \n");
      out.write("                    </div>                   \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"js/makeQuiz.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user!=Empty}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <li><a class=\"header-item\" href=\"LogOutController\">Log out</a></li>\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
