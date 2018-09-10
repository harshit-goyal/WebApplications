<jsp:include page='/MasterPageTopSection.jsp' />
<h1>Item (Remove Module)</h1>
<jsp:useBean id='itemBean' scope='request' class='com.thinking.machines.inventory.beans.ItemBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.inventory.beans.ErrorBean' />
<h3><jsp:getProperty name='errorBean' property='message' /></h3>
<h3>code  </h3>
<h3>${itemBean.code}</h3>
<form id='itemRemoveForm' action='/crudtwo/RemoveItem.jsp' >
<input type='hidden' name='code' id='code' maxlength='30' size='30' value='${itemBean.code}'>
<input type='hidden' name='name' id='name' maxlength='30' size='30' value='${itemBean.name}'>
<input type='hidden' name='category' id='category' maxlength='30' size='30' value='${itemBean.category}'>
<input type='hidden' name='price' id='price' maxlength='30' size='30' value='${itemBean.price}'>
<table border='1'>
<tr><td>NAME</td>
<td>"${itemBean.name}"</td></tr>
<tr><td>CATEGORY</td><td>"${itemBean.category}"</td></tr>
<tr><td>PRICE</td><td>"${itemBean.price}"</td></tr>
<tr><td colspan='2' align='center'><input type='submit' value='SAVE'></td></tr>
</table>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />