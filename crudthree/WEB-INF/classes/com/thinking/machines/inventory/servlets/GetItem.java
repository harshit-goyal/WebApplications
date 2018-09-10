package com.thinking.machines.inventory.servlets;
import java.io.*;
import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class GetItem extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
int from=Integer.parseInt(request.getParameter("from"));
int to=Integer.parseInt(request.getParameter("to"));
ItemDAOInterface itemDAOInterface=new ItemDAO();
ArrayList<ItemDTOInterface> items=null;
PrintWriter pw=null;
boolean hasNext=false;
response.setContentType("application/json");
try
{
items=itemDAOInterface.getAll(from,to);
try
{
pw=response.getWriter();
}catch(Exception e)
{
}
if(items!=null){
pw.print("[");
for(ItemDTOInterface item:items)
{
if(hasNext) pw.print(",");
pw.print(item.toJSON());
hasNext=true;
}
pw.print("]");
}
}catch(DAOException daoException)
{
try{
pw=response.getWriter();
}catch(Exception e)
{
}
pw.print("{\"success\":false,\"exception\":\""+daoException.getMessage()+"\"}");
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
this.doGet(request,response);
}
}