 
package com.thinking.machines.library.servlets;
import com.thinking.machines.library.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class GetBooks extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{ try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
AuthorDAO authorDAO=new AuthorDAO();
BookDAO bookDAO=new BookDAO();
try
{
LinkedList<AuthorInterface> authors;
authors=authorDAO.getAll();
LinkedList<BookInterface> books;
books=bookDAO.getAll();
pw.println("<!doctype html>");
pw.println("<html lang=\"en\">");
pw.println("<head>");
pw.println("<meta charset=\"utf-8\">");
pw.println("<title>Whatever Corporation</title>");
pw.println("<meta name=\"description\" content=\"The Whatever Corporation\">");
pw.println("<meta name=\"author\" content=\"Thinking Machines\">");
pw.println("<script>");
pw.println("function deleteBook(bookCode,bookTitle)");
pw.println("{");
pw.println("var c=confirm('Delete Book : '+bookTitle+'('+bookCode+')');");
pw.println("if(c)");
pw.println("{");
pw.println("var deleteBookForm=document.getElementById('deleteBookForm');");
pw.println("deleteBookForm.code.value=bookCode;");
pw.println("deleteBookForm.title.value=bookTitle;");
pw.println("deleteBookForm.submit();");
pw.println("}");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body style='background:#F5F5F5'>");
pw.println("<div style='background:#DBDBDB;width:100%;border:2px'>");
pw.println("<table width='100%'>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<img src='/crudone/images/logo.png'><br>");
pw.println("</td>");
pw.println("<td align='right' style='padding:5px'>");
pw.println("<a href='/crudone/'>Home</a>");
pw.println("</td>");
pw.println("</table>");
pw.println("</div>");
pw.println("<br>");
pw.println("<h2>Books </h2>");
pw.println("<table style='border:1px solid black'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th>S.No.</th>");
pw.println("<th>Title</th>");
pw.println("<th>Code</th>");
pw.println("<th>Author</th>");
pw.println("<th>Category</th>");
pw.println("<th>Price</th>");
pw.println("<th></th>");
pw.println("<th></th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
int sno=0;
for(BookInterface book:books)
{
sno++;
if(sno%2==0)
{
pw.println("<tr style='background:#DDDDDD'>");
} else
{
pw.println("<tr>");
}
pw.println("<td align='right' style='border:1px solid black'>"+sno+"</td>");
pw.println("<td style='border:1px solid black'>"+book.getTitle()+"</td>");
pw.println("<td align='right' style='border:1px solid black'>"+book.getCode()+"</td>");
for(AuthorInterface author:authors)
{
if(author.getCode()==book.getAuthorCode())
{
pw.println("<td align='right' style='border:1px solid black'>"+author.getName()+"</td>");
break;
}
}
pw.println("<td align='right' style='border:1px solid black'>"+book.getCategory()+"</td>");
pw.println("<td align='right' style='border:1px solid black'>"+book.getPrice()+"</td>");
pw.println("<td align='right' style='border:1px solid black'><a href='/crudone/editBook?code="+book.getCode()+"'><img src='/crudone/images/edit_icon.png' style='padding:5px'></a></td>");
pw.println("<td align='right' style='border:1px solid black'><a href='javascript:deleteBook("+book.getCode()+",\""+book.getTitle()+"\")'><img src='/crudone/images/delete_icon.png' style='padding:5px'></a></td>");
pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("<br>");
pw.println("<br>");
pw.println("<br>");
pw.println("<div style='background:#DBDBDB;width:100%;border:2px;padding:10px'>");
pw.println("<center>");
pw.println("&copy; Thinking Machines 2017-2040");
pw.println("</center>");
pw.println("</div>");
pw.println("<form id='deleteBookForm' action='/crudone/deleteBook' method='POST'>");
pw.println("<input type='hidden' name='code' id='code'>");
pw.println("<input type='hidden' name='title' id='title'>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
System.out.println(daoException); // don't forget to remove this after testing
pw.println("<!doctype html>");
pw.println("<html lang=\"en\">");
pw.println("<head>");
pw.println("<meta charset=\"utf-8\">");
pw.println("<title>Whatever Corporation</title>");
pw.println("<meta name=\"description\" content=\"The Whatever Corporation\">");
pw.println("<meta name=\"author\" content=\"Thinking Machines\">");
pw.println("</head>");
pw.println("<body style='background:#F5F5F5'>");
pw.println("<div style='background:#DBDBDB;width:100%;border:2px'>");
pw.println("<table width='100%'>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<img src='/crudone/images/logo.png'><br>");
pw.println("</td>");
pw.println("<td align='right' style='padding:5px'>");
pw.println("<a href='/crudone/'>Home</a>");
pw.println("</td>");
pw.println("</table>");
pw.println("</div>");
pw.println("<br>");
pw.println("<h2>Books </h2>");
pw.println("<br>");
pw.println("<div style='font-size:24pt;color:red'>");
pw.println("<b>No books added </b>");
pw.println("<br><br>");
pw.println("<form action='/crudone/'>");
pw.println("<Button type='submit'>Ok</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<br>");
pw.println("<br>");
pw.println("<br>");
pw.println("<div style='background:#DBDBDB;width:100%;border:2px;padding:10px'>");
pw.println("<center>");
pw.println("&copy; Thinking Machines 2017-2040");
pw.println("</center>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}
}
catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
}