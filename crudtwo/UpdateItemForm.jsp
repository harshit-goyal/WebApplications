<jsp:include page='/MasterPageTopSection.jsp' />
<script type='text/javascript' src='AddItemForm.js'></script>
<h1>Item (update Module)</h1>
<jsp:useBean id='itemBean' scope='request' class='com.thinking.machines.inventory.beans.ItemBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.inventory.beans.ErrorBean' />
<h3><jsp:getProperty name='errorBean' property='message' /></h3>
<h3>code  </h3>
<h3>${itemBean.code}</h3>
<form id='itemUpdateForm' action='/crudtwo/UpdateItem.jsp' onsubmit='return validation(this)'>
<input type='hidden' name='code' id='code' maxlength='30' size='30' value='${itemBean.code}'>
<table border='1'>
<tr><td>NAME</td>
<td><input type='text' name='name' id='name' maxlength='30' size='30' value='${itemBean.name}'>
<span id='nameErrorSection'></span></td></tr>
<tr><td>CATEGORY</td>
<td><input type='text' name='category' id='category' maxlength='30' size='30' value='${itemBean.category}'>
<span id='categoryErrorSection'></span></td></tr>
<tr><td>PRICE</td>
<td><input type='number' name='price' id='price' maxlength='30' size='30' value='${itemBean.price}'>
<span id='priceErrorSection'></span></td></tr>
<tr><td colspan='2' align='center'><input type='submit' value='SAVE'></td></tr>
</table>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />