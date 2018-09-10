<jsp:include page='/MasterPageTopSection.jsp' />
<script type='text/javascript' src='jquery-3.1.1/jquery-3.1.1.min.js'></script>

<script type='text/javascript' src='js/EditItemForm.js'></script>
<h1>Item (update Module)</h1>
<h3 id='notificationSection'></h3>
<form id='itemUpdateForm'>
<table border='1'>
<tr><td>CODE</td>
<td><input type='number' name='code' id='code' maxlength='30' size='30'>
<span id='codeErrorSection'></span></td></tr>
<tr><td>NAME</td>
<td><input type='text' disabled='true' name='name' id='item_name' maxlength='30' size='30' >
<span id='nameErrorSection'></span></td></tr>
<tr><td>CATEGORY</td>
<td><input type='text' disabled='true' name='category' id='category' maxlength='30' size='30' >
<span id='categoryErrorSection'></span></td></tr>
<tr><td>PRICE</td>
<td><input type='number' disabled='true' name='price' id='price' maxlength='30' size='30' >
<span id='priceErrorSection'></span></td></tr>
<tr><td colspan='2' align='center'><input type='button' value='SAVE' onclick='get()' name='SAVE' id='SAVE'></td></tr>
</table>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />