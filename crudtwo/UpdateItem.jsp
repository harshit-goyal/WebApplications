<jsp:useBean id='itemBean' scope='request' class='com.thinking.machines.inventory.beans.ItemBean' />
<jsp:setProperty name='itemBean' property='*' />
<jsp:forward page='/updateItem' />