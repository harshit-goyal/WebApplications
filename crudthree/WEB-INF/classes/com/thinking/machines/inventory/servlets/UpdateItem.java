package com.thinking.machines.inventory.servlets;
import java.io.*;
import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateItem extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String name=request.getParameter("name");
String category=request.getParameter("category");
int price=Integer.parseInt(request.getParameter("price"));
int code=Integer.parseInt(request.getParameter("code"));
ItemDAOInterface itemDAOInterface=new ItemDAO();
ItemDTOInterface itemDTOInterface=new ItemDTO();
itemDTOInterface.setName(name);
itemDTOInterface.setCategory(category);
itemDTOInterface.setPrice(price);
itemDTOInterface.setCode(code);
PrintWriter pw=null;
response.setContentType("application/json");
try
{
itemDAOInterface.update(itemDTOInterface);
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