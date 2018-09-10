package com.thinking.machines.library.servlets;
import com.thinking.machines.library.dl.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class EditBook extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{ try
{ int code=Integer.parseInt(request.getParameter("code"));
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
BookInterface book;
BookDAO bookDAO=new BookDAO();
try
{
book=bookDAO.getByCode(code);
String title=book.getTitle();
int authorCode=book.getAuthorCode();
String category=book.getCategory();
int price=book.getPrice();
AuthorDAO authorDAO=new AuthorDAO();
LinkedList<AuthorInterface> authors;
authors=authorDAO.getAll();
pw.println("<!doctype html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Whatever Corporation</title>");
pw.println("<meta name='description' content='The Whatever Corporation'>");
pw.println("<meta name='author' content='Thinking Machines'>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var title=frm.title.value.trim();");
pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");
pw.println("titleErrorSection.innerHTML='&nbsp;';");
pw.println("var authorCode=frm.authorCode.value;");
pw.println("var authorCodeErrorSection=document.getElementById('authorCodeErrorSection');");
pw.println("authorCodeErrorSection.innerHTML='&nbsp;';");
pw.println("var category=frm.category.value;");
pw.println("var categoryErrorSection=document.getElementById('categoryErrorSection');");
pw.println("categoryErrorSection.innerHTML='&nbsp;';");
pw.println("var price=frm.price.value.trim();");
pw.println("var priceErrorSection=document.getElementById('priceErrorSection');");
pw.println("priceErrorSection.innerHTML='&nbsp;';");
pw.println("var errorComponent=null;");
pw.println("var valid=true;");
pw.println("if(title.length==0)");
pw.println("{");
pw.println("titleErrorSection.innerHTML=\"Required\";");
pw.println("valid=false;");
pw.println("errorComponent=frm.title;");
pw.println("}");
pw.println("if(authorCode==-1)");
pw.println("{");
pw.println("authorCodeErrorSection.innerHTML=\"Required\";");
pw.println("valid=false;");
pw.println("if(errorComponent==null)");
pw.println("{");
pw.println("errorComponent=frm.authorCode;");
pw.println("}");
pw.println("}");
pw.println("if(category=='none')");
pw.println("{");
pw.println("categoryErrorSection.innerHTML=\"Required\";");
pw.println("valid=false;");
pw.println("if(errorComponent==null)");
pw.println("{");
pw.println("errorComponent=frm.category;");
pw.println("}");
pw.println("}");
pw.println("if(price.length==0)");
pw.println("{");
pw.println("frm.price.value=\"0\";");
pw.println("}");
pw.println("v=\"0123456789\";");
pw.println("var i=0;");
pw.println("while(i<price.length)");
pw.println("{");
pw.println("if(v.indexOf(price.charAt(i))==-1)");
pw.println("{");
pw.println("priceErrorSection.innerHTML=\"Invalid\";");
pw.println("valid=false;");
pw.println("if(errorComponent==null)");
pw.println("{");
pw.println("errorComponent=frm.price;");
pw.println("}");
pw.println("break;");
pw.println("}");
pw.println("i++;");
pw.println("}");
pw.println("if(!valid) errorComponent.focus();");
pw.println("return valid;");
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
pw.println("<h2>Edit Book</h2>");
pw.println("<form action='/crudone/updateBook' onsubmit='return validateForm(this)' method='post'>");
pw.println("<input type='hidden' id='code' name='code' value='"+code+"'>");
pw.println("<table border='0'>");
pw.println("<tr>");
pw.println("<td>Title</td>");
pw.println("<td>");
pw.println("<input type='text' name='title' id='title' maxlength='35' size='31' value='"+title+"'>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td></td><td>");
pw.println("<span id='titleErrorSection' style='color:red'>&nbsp;</span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Author</td>");
pw.println("<td>");
pw.println("<select id='authorCode' name='authorCode'>");
pw.println("<option value='-1'>&lt;Select&gt;</option>");
for(AuthorInterface author:authors)
{ if(author.getCode()==authorCode)
{
pw.println("<option selected value='"+author.getCode()+"'>"+author.getName()+"</option>");
} else
{
pw.println("<option value='"+author.getCode()+"'>"+author.getName()+"</option>");
}}
pw.println("</select>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td></td><td>");
pw.println("<span id='authorCodeErrorSection' style='color:red'>&nbsp;</span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Category</td>");
pw.println("<td>");
pw.println("<select id='category' name='category'>");
pw.println("<option value='none'>&lt;Select&gt;</option>");
if(category.equals("Science fiction"))
{
pw.println("<option selected value='Science fiction'>Science fiction</option>");
} else
{
pw.println("<option value='Science fiction'>Science fiction</option>");
} if(category.equals("Satire"))
{
pw.println("<option selected value='Satire'>Satire</option>");
} else
{
pw.println("<option value='Satire'>Satire</option>");
} if(category.equals("Drama"))
{
pw.println("<option selected value='Drama'>Drama</option>");
} else
{
pw.println("<option value='Drama'>Drama</option>");
} if(category.equals("Action and Adventure"))
{
pw.println("<option selected value='Action and Adventure'>Action and Adventure</option>");
} else
{
pw.println("<option value='Action and Adventure'>Action and Adventure</option>");
} if(category.equals("Mystery"))
{
pw.println("<option selected value='Mystery'>Mystery</option>");
} else
{
pw.println("<option value='Mystery'>Mystery</option>");
} if(category.equals("Horror"))
{
pw.println("<option selected value='Horror'>Horror</option>");
} else
{
pw.println("<option value='Horror'>Horror</option>");
}
pw.println("</select>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td></td><td>");
pw.println("<span id='categoryErrorSection' style='color:red'>&nbsp;</span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Price</td>");
pw.println("<td>");
pw.println("<input type='text' name='price' id='price' maxlength='5' size='6' style='text-align:right' value='"+price+"'>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td></td><td>");
pw.println("<span id='priceErrorSection' style='color:red'>&nbsp;</span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td colspan='2' align='center'>");
pw.println("<button type='submit'>Update</button>");
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
}catch(DAOException daoException)
{
AuthorDAO authorDAO=new AuthorDAO();
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
for(BookInterface b:books)
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
pw.println("<td style='border:1px solid black'>"+b.getTitle()+"</td>");
pw.println("<td align='right' style='border:1px solid black'>"+b.getCode()+"</td>");
for(AuthorInterface author:authors)
{ if(author.getCode()==b.getAuthorCode())
{
pw.println("<td align='right' style='border:1px solid black'>"+author.getName()+"</td>");
break;
}}
pw.println("<td align='right' style='border:1px solid black'>"+b.getCategory()+"</td>");
pw.println("<td align='right' style='border:1px solid black'>"+b.getPrice()+"</td>");
pw.println("<td align='right' style='border:1px solid black'><a href='/crudone/editBook?code="+b.getCode()+"'><img src='/crudone/images/edit_icon.png' style='padding:5px'></a></td>");
pw.println("<td align='right' style='border:1px solid black'><a href='javascript:deleteBook("+b.getCode()+",\""+b.getTitle()+"\")'><img src='/crudone/images/delete_icon.png' style='padding:5px'></a></td>");
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
}catch(DAOException daoException2)
{ // this case won't arise
}
}
}
catch(Exception exception)
{
}
}
}