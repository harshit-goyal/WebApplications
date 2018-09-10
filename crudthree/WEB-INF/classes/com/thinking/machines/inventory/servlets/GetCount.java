package com.thinking.machines.inventory.servlets;
import java.io.*;
import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GetCount extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
long count=0;
ItemDAOInterface itemDAOInterface=new ItemDAO();
PrintWriter pw=null;
try
{
count=itemDAOInterface.getCount();
try
{
pw=response.getWriter();
response.setContentType("application/json");
}catch(Exception e)
{
}
pw.print("{\"success\" : true, \"count\" : \""+count+"\"}");
System.out.println("add s phle");
}catch(DAOException daoException)
{
try{
pw=response.getWriter();
response.setContentType("application/json");
}catch(Exception e)
{
}
pw.print("{\"success\" : false, \"exception\" : \""+daoException.getMessage()+"\"}");
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
this.doGet(request,response);
}
}