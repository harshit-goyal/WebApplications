<jsp:include page='/MasterPageTopSection.jsp' />
<h1>Notification</h1>
<jsp:useBean id='notificationBean' scope='request' class='com.thinking.machines.library.beans.NotificationBean' />
<br>
<h1>${notificationBean.message}</h1>
<a href='${notificationBean.actionURL}'>${notificationBean.actionText}</a>
<jsp:include page='/MasterPageBottomSection.jsp' />