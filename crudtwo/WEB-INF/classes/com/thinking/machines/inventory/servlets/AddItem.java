package com.thinking.machines.inventory.servlets;
import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exception.*;
import com.thinking.machines.inventory.dl.*;
import com.thinking.machines.inventory.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddItem extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
ItemBean itemBean=(ItemBean)request.getAttribute("itemBean");
ItemDAOInterface itemDAOInterface=new ItemDAO();
ItemDTOInterface itemDTOInterface=new ItemDTO();
itemDTOInterface.setName(itemBean.getName());
itemDTOInterface.setCategory(itemBean.getCategory());
itemDTOInterface.setPrice(itemBean.getPrice());
try
{
try{
itemDAOInterface.add(itemDTOInterface);
NotificationBean notificationBean=new NotificationBean();
notificationBean.setMessage("Item added with code as : "+itemDTOInterface.getCode());
notificationBean.setNextPath("/crudtwo/AddItemForm.jsp");
notificationBean.setNextPathMessage("add more items");
request.setAttribute("notificationBean",notificationBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setMessage(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/AddItemForm.jsp");
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