package com.thinking.machines.inventory.servlets;
import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import com.thinking.machines.inventory.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RemoveItem extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
ItemBean itemBean=(ItemBean)request.getAttribute("itemBean");
ItemDAOInterface itemDAOInterface=new ItemDAO();
try
{
try{
itemDAOInterface.delete(itemBean.getCode());
NotificationBean notificationBean=new NotificationBean();
notificationBean.setMessage("Item Deleted");
notificationBean.setNextPath("/crudtwo/EditItemForm.jsp");
notificationBean.setNextPathMessage("add more items");
request.setAttribute("notificationBean",notificationBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setMessage(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/RemoveItemForm.jsp");
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