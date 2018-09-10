<%@ taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<h1>Items</h1>
page number :13
<br>
<select id='itemPageSize' name='itemPageSize'>
<tm:For start='100' end='200' step='5'>
<option value='${value}'>${value}</option>
</tm:For>
</select>
<a href='/crudone'>hhome</a>

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
<tm:Item>
<tr>
<td><%=serialNumber%></td>
<td><%=name%> (<%=code%>)</td>
<td><%=price%></td>
<td>${category}</td>
</tr>
</tm:Item>
</tbody>
</table>
<hr>
<jsp:include page='/MasterPageBottomSection.jsp' />