package com.thinking.machines.inventory.servlets;
import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import com.thinking.machines.inventory.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteItem extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
ItemBean itemBean=(ItemBean)request.getAttribute("itemBean");
ItemDAOInterface itemDAOInterface=new ItemDAO();
ItemDTOInterface itemDTOInterface=new ItemDTO();
itemDTOInterface.setCode(itemBean.getCode());
try
{
try{
itemDTOInterface=itemDAOInterface.get(itemDTOInterface.getCode());
itemBean.setName(itemDTOInterface.getName());
System.out.println(itemBean.getName());
itemBean.setCategory(itemDTOInterface.getCategory());
itemBean.setPrice(itemDTOInterface.getPrice());
request.setAttribute("itemBean",itemBean);
System.out.println(itemBean.getPrice());
System.out.println(itemBean.getCategory());
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/RemoveItemForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setMessage(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/DeleteItemForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception e)
{
System.out.println(e);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
this.doGet(request,response);
}
}