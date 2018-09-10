<jsp:include page='/MasterPageTopSection.jsp' />
<script type='text/javascript' src='EditItemForm.js'></script>
<h1>Item (Edit Module)</h1>
<jsp:useBean id='itemBean' scope='request' class='com.thinking.machines.inventory.beans.ItemBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.inventory.beans.ErrorBean' />
<h3><jsp:getProperty name='errorBean' property='message' /></h3>
<form id='ItemEditForm' action='/crudtwo/EditItem.jsp' onsubmit='return validation(this)'>
<table border='1'>
<tr><td>CODE</td>
<td><input type='text' name='code' id='code' maxlength='30' size='30' value='${itemBean.code}'>
<span id='codeErrorSection'></span></td></tr>
<tr><td colspan='2' align='center'><input type='submit' value='SAVE'></td></tr>
</table>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />