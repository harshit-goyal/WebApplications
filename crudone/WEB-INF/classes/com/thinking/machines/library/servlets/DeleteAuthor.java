package com.thinking.machines.library.servlets;
import com.thinking.machines.library.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class DeleteAuthor extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{ try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
int code=Integer.parseInt(request.getParameter("code"));
String name=request.getParameter("name");
BookDAO bookDAO=new BookDAO();
try
{
boolean bookWithAuthorExists=bookDAO.containsBookWithAuthorCode(code);
if(bookWithAuthorExists)
{
pw.println("<!doctype html>");
pw.println("<html lang=\"en\">");
pw.println("<head>");
pw.println("<meta charset=\"utf-8\">");
pw.println("<title>Whatever Corporation</title>");
pw.println("<meta name=\"description\" content=\"The Whatever Corporation\">");
pw.println("<meta name=\"author\" content=\"Thinking Machines\">");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var name=frm.name.value.trim();");
pw.println("var nameErrorSection=document.getElementById(\"nameErrorSection\");");
pw.println("nameErrorSection.innerHTML=\"\";");
pw.println("if(name.length==0)");
pw.println("{");
pw.println("nameErrorSection.innerHTML=\"Required\";");
pw.println("frm.name.focus();");
pw.println("return false;");
pw.println("}");
pw.println("var validCharacters=\"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .\";");
pw.println("var e=0;");
pw.println("while(e<name.length)");
pw.println("{");
pw.println("if(validCharacters.indexOf(name.charAt(e))==-1)");
pw.println("{");
pw.println("nameErrorSection.innerHTML=\"Invalid characters in name of author\";");
pw.println("frm.name.focus();");
pw.println("return false;");
pw.println("}");
pw.println("e++;");
pw.println("}");
pw.println("return true;");
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
pw.println("<br>");
pw.println("<h2>Delete Author </h2>");
pw.println("<div style='color:red'>Cannot delete author as book exists against it.</div>");
pw.println("<form action='/crudone/getAuthorForDeletion' onsubmit='return validateForm(this)' method='post'>");
pw.println("<table border='0'>");
pw.println("<tr>");
pw.println("<td>Name of author</td>");
pw.println("<td>");
pw.println("<input type='text' name='name' id='name' maxlength='35' size='31' value='"+name+"'>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td colspan='2' align='right'>");
pw.println("<span id='nameErrorSection' style='color:red'>&nbsp;</span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td colspan='2' align='center'>");
pw.println("<button type='submit'>Delete</button>");
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</form>");
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
return;
}}
catch(DAOException daoException)
{
System.out.println(daoException); // don't forget to remove after testing
}
AuthorDAO authorDAO=new AuthorDAO();
try
{ authorDAO.remove(code);
}catch(DAOException daoException)
{}
pw.println("<!doctype html>");
pw.println("<html lang=\"en\">");
pw.println("<head>");
pw.println("<meta charset=\"utf-8\">");
pw.println("<title>Whatever Corporation</title>");
pw.println("<meta name=\"description\" content=\"The Whatever Corporation\">");
pw.println("<meta name=\"author\" content=\"Thinking Machines\">");
pw.println("</head>");
pw.println("<body style='background:#F5F5F5'>");
pw.println("<div style='background:#DBDBDB;width:100%;border:2px'> ");
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
pw.println("<br>");
pw.println("<h2>Notification</h2>");
pw.println("<div style='font-size:24pt'>");
pw.println("<b>Author deleted successfully</b>");
pw.println("<br><br>");
pw.println("<form action='/crudone/AuthorDeleteForm.html'>");
pw.println("<Button type='submit'>Delete more authors</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<br>");
pw.println("<br>");
pw.println("<br>");
pw.println("<div style='background:#DBDBDB;width:100%;border:2px;padding:10px'> ");
pw.println("<center>");
pw.println("&copy; Thinking Machines 2017-2040");
pw.println("</center>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}}}

