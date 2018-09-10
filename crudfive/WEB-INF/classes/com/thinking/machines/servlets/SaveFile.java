package com.thinking.machines.servlets;
import java.io.*;
import javazoom.upload.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class SaveFile extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
MultipartFormDataRequest mrequest=new MultipartFormDataRequest(request);
Integer code=Integer.parseInt(mrequest.getParameter("code"));
String description=mrequest.getParameter("description");
boolean fileSaved=false;
Hashtable files=mrequest.getFiles();
if(files!=null && !files.isEmpty())
{
UploadFile file=(UploadFile)files.get("whateverFile");
String fileName=file.getFileName();
UploadBean uploadBean=new UploadBean();
uploadBean.setFilesizelimit(209715200);
uploadBean.setFolderstore(getServletContext().getRealPath("/")+"WEB-INF/uploaded");
fileName=code+"_"+fileName;
file.setFileName(fileName);
uploadBean.store(mrequest,"whateverFile");
}
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
pw.println("<!Doctype html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>File upload example</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("Data Saved");
pw.println("</body>");
pw.println("</html>");
}catch(Exception e)
{
System.out.println(e);
}
}
}