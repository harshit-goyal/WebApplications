package com.thinking.machines.inventory.beans;
public class ErrorBean implements java.io.Serializable
{
private String message;
public ErrorBean()
{
this.message="";
}
public void setMessage(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
}