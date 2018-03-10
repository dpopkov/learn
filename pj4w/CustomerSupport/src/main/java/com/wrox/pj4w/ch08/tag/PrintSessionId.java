package com.wrox.pj4w.ch08.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintSessionId extends TagSupport {
    @Override
    public int doEndTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String uri = request.getRequestURI();
        String pageName = uri.substring(uri.lastIndexOf("/") + 1);
        HttpSession session = pageContext.getSession();
        System.out.println("JSP page = " + pageName + ", Session ID = " + session.getId());

        return Tag.EVAL_PAGE;
    }
}
