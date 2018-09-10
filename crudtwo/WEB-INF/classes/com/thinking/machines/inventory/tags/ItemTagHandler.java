package com.thinking.machines.inventory.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import java.util.*;
public class ItemTagHandler extends BodyTagSupport
{
private ArrayList<ItemDTOInterface> items;
private int currentIndex=0;
public ItemTagHandler()
{
try
{
ItemDAOInterface itemDAOInterface;
itemDAOInterface=new ItemDAO();
items=itemDAOInterface.getAll();
}
catch(Exception exception)
{
items=new ArrayList<ItemDTOInterface>();
}
}
public int doStartTag()
{
if(items.size()==0)return SKIP_BODY;
setScriptingVariables();
return EVAL_BODY_INCLUDE;

}public int doAfterBody()
{
currentIndex++;
if(currentIndex==items.size())return SKIP_BODY;
setScriptingVariables();
return EVAL_BODY_AGAIN;
}
public int doEndTag()
{
this.currentIndex=0;
return EVAL_PAGE;
}
public void setScriptingVariables()
{
ItemDTOInterface itemDTOInterface;
itemDTOInterface=items.get(currentIndex);
pageContext.setAttribute("serialNumber",new Integer(currentIndex+1));
pageContext.setAttribute("code",new Integer(itemDTOInterface.getCode()));
pageContext.setAttribute("name",itemDTOInterface.getName());
pageContext.setAttribute("price",itemDTOInterface.getPrice());
pageContext.setAttribute("category",itemDTOInterface.getCategory());
}
}