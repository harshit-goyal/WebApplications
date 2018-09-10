package com.thinking.machines.inventory.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
public class ItemTEI extends TagExtraInfo
{
public VariableInfo[] getVariableInfo(TagData tagData)
{
VariableInfo v[]=new VariableInfo[5];
v[0]=new VariableInfo("serialNumber","java.lang.Integer",true,VariableInfo.NESTED);
v[1]=new VariableInfo("code","java.lang.Integer",true,VariableInfo.NESTED);
v[2]=new VariableInfo("name","java.lang.String",true,VariableInfo.NESTED);
v[3]=new VariableInfo("price","java.lang.Integer",true,VariableInfo.NESTED);
v[4]=new VariableInfo("category","java.lang.String",true,VariableInfo.NESTED);
return v;
}}
