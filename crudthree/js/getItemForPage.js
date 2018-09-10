function jsonToQueryString(json)
{
alert($);
return "?"+Object.keys(json).map(function(key){
return encodeURIComponent(key)+"="+encodeURIComponent(json[key]);
}).join("&");
}
function getItem()
{
var json={
"from" : "0",
"to" : "10"
};
var qs=jsonToQueryString(json);
alert($);
$.ajax(
{
"type" : "GET",
"url" : 'getItem'+qs,
"success" : function(data){
alert(data);
var x=0;
$.each(data,function(i,val){ 
alert(x+"  code : "+val.code+" name : "+val.name+" category : "+val.category+" price : "+val.price);
x++;
});
if(data.success==true)
{
alert("deepesh43");
$("#notificationSection").html("data added with code : "+data.code);
}
else
{
alert("deepesh54");
$("#notificationSection").html("unable to add error is  : "+data.exception);
}
},
"error" : function(){
alert("deepesh654");
alert();
}
});
}