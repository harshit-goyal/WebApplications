package com.thinking.machines.inventory.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
public class ForTEI extends TagExtraInfo
{
public VariableInfo[] getVariableInfo(TagData tagData)
{
VariableInfo v[]=new VariableInfo[1];
v[0]=new VariableInfo("value","java.lang.Integer",true,VariableInfo.NESTED);
return v;
}}
