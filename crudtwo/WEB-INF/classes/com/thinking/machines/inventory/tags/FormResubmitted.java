package com.thinking.machines.inventory.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class FormResubmitted extends TagSupport
{
public int doStartTag()
{
try
{
HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
String formID=request.getParameter("formID");
if(formID==null)
{
return super.EVAL_BODY_INCLUDE;
}
String uid=(String)pageContext.getAttribute(formID,PageContext.SESSION_SCOPE);
if(uid==null)
{
return super.EVAL_BODY_INCLUDE; // body will be processed
}
pageContext.removeAttribute(formID,pageContext.SESSION_SCOPE);
}catch(Exception exception)
{
System.out.println(exception);
}
return SKIP_BODY;
}
public int doEndTag()
{
return super.EVAL_PAGE;
}
}