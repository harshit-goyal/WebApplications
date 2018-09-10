<%@ taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm' %>
<tm:FormResubmitted>
<jsp:forward page='/FormResubmitted.jsp'/>
</tm:FormResubmitted>
<jsp:useBean id='itemBean' scope='request' class='com.thinking.machines.inventory.beans.ItemBean' />
<jsp:setProperty name='itemBean' property='*' />
<jsp:forward page='/addItem' />