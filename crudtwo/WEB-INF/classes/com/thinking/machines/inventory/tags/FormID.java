package com.thinking.machines.inventory.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
public class FormID extends TagSupport
{
public int doStartTag()
{
try
{
String uid=UUID.randomUUID().toString();
uid=uid.replaceAll("-","k");
pageContext.setAttribute(uid,uid,PageContext.SESSION_SCOPE);
JspWriter jw;
jw=pageContext.getOut();
jw.write("<input type='hidden' name='formID' value='"+uid+"'>");
}catch(Exception exception)
{
System.out.println(exception);
}
return super.SKIP_BODY;
}
public int doEndTag()
{
return EVAL_PAGE;
}



}