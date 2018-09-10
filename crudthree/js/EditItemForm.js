function jsonToQueryString(json)
{
alert($);
return "?"+Object.keys(json).map(function(key){
return encodeURIComponent(key)+"="+encodeURIComponent(json[key]);
}).join("&");
}
function updateItem()
{
alert($);
var json={
"code" : $("#code").val(),
"name" : $("#item_name").val(),
"category" : $("#category").val(),
"price" : $("#price").val(),
};
var qs=jsonToQueryString(json);
alert(qs);
$.ajax(
{
"type" : "GET",
"url" : 'updateItem'+qs,
"success" : function(data){
alert(data+" deepesh");
if(data.success==true)
{
alert("deepesh43");
$("#notificationSection").html("unable to update ");
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

function get()
{
var json={
"code" : $("#code").val(),
};
var qs=jsonToQueryString(json);
alert($);
alert(qs);
$.ajax(
{
"type" : "GET",
"url" :"getItem"+qs,
"success" : function(data){
alert(data);
if(data.success==true)
{
alert("deepesh43");
$("#item_name").val(data.item.name),
$("#category").val(data.item.category),
$("#price").val(data.item.price),
$("#item_name").prop("disabled",false),
$("#category").prop("disabled",false),
$("#price").prop("disabled",false),
$("#code").prop("disabled",true),
$("#SAVE").attr("onclick","updateItem()"),
$("#SAVE").prop("value","updateItem()")
}
else
{
alert("deepesh54");
$("#notificationSection").html(data.exception);
}
},
"error" : function(){
alert("deepesh654");
alert();
}
});
}