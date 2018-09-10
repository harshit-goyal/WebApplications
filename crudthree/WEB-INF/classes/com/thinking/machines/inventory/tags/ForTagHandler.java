package com.thinking.machines.inventory.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ForTagHandler extends BodyTagSupport
{
private int start;
private int end;
private int step;
private int mf;
private int value;
private boolean accending;
public ForTagHandler()
{
reset();
}
public void setStart(int start)
{
this.start=start;
}
public void setEnd(int end)
{
this.end=end;
}
public void setStep(int step)
{
this.step=step;
}
public int getStart()
{
return this.start;
}
public int getEnd()
{
return this.end;
}
public int getStep()
{
return this.step;
}

public int doStartTag()
{
int x,j;
x=start-end;
j=x>>31;
j=(j^x)-j;
this.mf=((start-end)/j)*(-1);
this.step=this.step*mf;
this.value=this.start;
if(((this.value-this.end)*mf)>0) return SKIP_BODY;
setScriptingVariables();
return EVAL_BODY_INCLUDE;
}public int doAfterBody()
{
this.value=this.value+this.step;
if(((this.value-this.end)*mf)>0)
{
System.out.println("m aya h");
return SKIP_BODY;
}
setScriptingVariables();
return EVAL_BODY_AGAIN;
}
public int doEndTag()
{
reset();
System.out.println("doEndTag m aya h");
return EVAL_PAGE;
}
public void reset()
{
this.start=0;
this.step=1;
this.end=0;
this.mf=0;
this.value=0;
}
public void setScriptingVariables()
{
pageContext.setAttribute("value",new Integer(value));
}
}