function validation(f)
{
var vCode=f.code.value;
var vCodeErrorSection=document.getElementById("codeErrorSection");
vCodeErrorSection.innerHTML="";
if(vCode.trim().length==0)
{
vCodeErrorSection.innerHTML="Required";
return false;
}
if(vCode<=0)
{
vCodeErrorSection.innerHTML="invalide";
return false;
}
return true;
}