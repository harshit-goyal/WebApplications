package com.thinking.machines.inventory.beans;
public class ItemBean implements java.io.Serializable,Comparable<ItemBean>
{
private int code;
private String name;
private String category;
private int price;
public ItemBean()
{
code=0;
name="";
category="";
price=0;
}
public void setCode(int code)
{
this.code=code;
}
public void setCategory(String category)
{
this.category=category;
}
public void setPrice(int price)
{
this.price=price;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public String getCategory()
{
return this.category;
}
public int getCode()
{
return this.code;
}
public int getPrice()
{
return this.price;
}
public boolean equals(Object object)
{
if(!(object instanceof ItemBean)) return false;
ItemBean itemBean=(ItemBean)object;
return this.name.equals(itemBean.name);
}
public int compareTo(ItemBean itemBean)
{
return this.name.compareTo(itemBean.name);
}

}