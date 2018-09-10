package com.thinking.machines.inventory.servlets;
import java.io.*;
import java.util.*;

import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GetItem extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
ItemDAOInterface itemDAOInterface=new ItemDAO();
ArrayList<ItemDTOInterface> items=null;

PrintWriter pw=null;
try
{
items=itemDAOInterface.getAll();
try
{
pw=response.getWriter();
}catch(Exception e)
{
}
pw.println("<!Doctype html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>LIST ITEM MODULE (STYLE-ONE)</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<center>");
pw.println("<h2>list item Module (style one)</h2>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th>s no.</th>");
pw.println("<th>code</th>");
pw.println("<th>name</th>");
pw.println("<th>category</th>");
pw.println("<th>price</th>");
pw.println("</tr>");
pw.println("</thead>");
int sno=0;
pw.println("<tbody>");
for(ItemDTOInterface itemDTOInterface:items)
{
sno++;
pw.println("<tr>");
pw.println("<td align='right'>"+sno+".</td>");
pw.println("<td align='right'>"+itemDTOInterface.getCode()+"</td>");
pw.println("<td>"+itemDTOInterface.getName()+"</td>");
pw.println("<td >"+itemDTOInterface.getCategory()+"</td>");
pw.println("<td align='right'>"+itemDTOInterface.getPrice()+"</td>");
pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("</form>");
pw.println("<a href='/crudone/'>HOME</a>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
try{
pw=response.getWriter();
}catch(Exception e)
{
}
System.out.println("ayaya");
pw.println("<!Doctype html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>EDIT ITEM MODULE (STYLE-ONE)</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<center>");
pw.println("<h2>EDIT item Module (style one)</h2>");
pw.println("<h2>'"+daoException.getMessage()+"'</h2></br>");
pw.println("<a href='/crudone/'>HOME</a>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");

}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
this.doGet(request,response);
}
}