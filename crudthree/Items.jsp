<%@ taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm' %>
<body onload='getItem()'>
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='jquery-3.1.1/jquery-3.1.1.min.js'></script>
<script src='js/getItemForPage.js'></script>
<h1>Items</h1>
page number :13
<br>
<select id='itemPageSize' name='itemPageSize'>
<tm:For start='0' end='200' step='5'>
<option value='${value}'>${value}</option>
</tm:For>
</select>
<a href='/crudthree'>hhome</a>
<table border='1'>
<thead>
<tr>
<th>S.No.</th>
<th>Item</th>
<th>Price</th>
<th>Category</th>
</tr>
</thead>
<tbody>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
<hr>
</body>
<jsp:include page='/MasterPageBottomSection.jsp' />