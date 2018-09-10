package com.thinking.machines.inventory.beans;
public class NotificationBean implements java.io.Serializable
{
private String message;
private String nextPath;
private String nextPathMessage;
public NotificationBean()
{
message="";
nextPath="";
nextPathMessage="";
}
public void setMessage(String message)
{
this.message=message;
}
public void setNextPath(String nextPath)
{
this.nextPath=nextPath;
}
public void setNextPathMessage(String nextPathMessage)
{
this.nextPathMessage=nextPathMessage;
}
public String getMessage()
{
return this.message;
}
public String getNextPath()
{
return this.nextPath;
}
public String getNextPathMessage()
{
return this.nextPathMessage;
}
}