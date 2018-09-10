package com.thinking.machines.inventory.servlets;
import java.io.*;
import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteItem extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
int code=Integer.parseInt(request.getParameter("code"));
ItemDAOInterface itemDAOInterface=new ItemDAO();
PrintWriter pw=null;
response.setContentType("application/json");
try
{
itemDAOInterface.delete(code);
try
{
pw=response.getWriter();
}catch(Exception e)
{
}
pw.print("{\"success\" : true}");
System.out.println("success");
}catch(DAOException daoException)
{
try{
pw=response.getWriter();
}catch(Exception e)
{
}
pw.print("{\"success\" : false,\"exception\" :\""+daoException.getMessage()+"\"}");
System.out.println("success  false ");
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
this.doGet(request,response);
}
}