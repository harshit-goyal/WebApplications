<%@ taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<script type='text/javascript' src='AddItemForm.js'></script>
<h1>Item (Add Module)</h1>
<jsp:useBean id='itemBean' scope='request' class='com.thinking.machines.inventory.beans.ItemBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.inventory.beans.ErrorBean' />
<h3><jsp:getProperty name='errorBean' property='message' /></h3>
<form id='itemAddForm' action='/crudtwo/AddItem.jsp' onsubmit='return validation(this)'>
<tm:FormID/>
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