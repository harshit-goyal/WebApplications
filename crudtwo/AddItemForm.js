function validation(f)
{
var vName=f.name.value;
var vCategory=f.category.value;
var vPrice=f.price.value;
var vNameErrorSection=document.getElementById("nameErrorSection");
var vCategoryErrorSection=document.getElementById("categoryErrorSection");
var vPriceErrorSection=document.getElementById("priceErrorSection");
vPriceErrorSection.innerHTML="";
vNameErrorSection.innerHTML="";
vCategoryErrorSection.innerHTML="";
var errorComponent=null;
var error="false";
if(vName.trim().length==0)
{
vNameErrorSection.innerHTML="Required";
errorComponent=f.name;
error="true";
}
if(vPrice.trim().length==0)
{
f.price.value=0;
vPrice=0;
}
if(vPrice<0)
{
vPriceErrorSection.innerHTML="invalid value";
if(errorComponent==null)
{
errorComponent=f.category;
error="true";
}
}
if(vCategory.trim().length==0)
{
vCategoryErrorSection.innerHTML="Required";
if(errorComponent==null)
{
errorComponent=f.category;
error="true";
}
}
if(errorComponent!=null)
{
errorComponent.focus();
return false;
}
return true;
}