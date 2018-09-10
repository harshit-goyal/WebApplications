function jsonToQueryString(json)
{
alert($);
return "?"+Object.keys(json).map(function(key){
return encodeURIComponent(key)+"="+encodeURIComponent(json[key]);
}).join("&");
}
function deleteItem()
{
alert($);
var json={
"code" : $("#code").val(),
};
var qs=jsonToQueryString(json);
$.ajax(
{
"type" : "GET",
"url" : "deleteItem"+qs,
"success" : function(data){
alert(data+" deepesh");
if(data.success==true)
{
alert("deepesh43");
$("#notificationSection").html("data deleted : ");
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
alert($);
$("#notificationSection").html();
var json={
"code":$("#code").val(),
};
var qs=jsonToQueryString(json);
alert(qs);
$.ajax(
{
"type" : "GET",
"url" : "getItem"+qs,
"success" : function(data){
alert(data);
if(data.success==true)
{
alert("deepesh43");
$("#item_name").val(data.item.name),
$("#category").val(data.item.category),
$("#price").val(data.item.price),
$("#item_name").prop("disabled",true),
$("#category").prop("disabled",true),
$("#price").prop("disabled",true),
$("#code").prop("disabled",true),
$("#SAVE").attr("onclick","deleteItem()")
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