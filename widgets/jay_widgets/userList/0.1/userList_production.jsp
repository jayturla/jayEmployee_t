
<html>
<head>
<title></title>
</head>
<body>
<%
	WbdProductionHelper helper = null;
	JspHelper jh = null;
	String snippetVar_myProperty;
	String snippetVar_thisNavpoint;
%>
<!--START-->
<%@page import="com.dinaa.data.XNodes"%>
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.jay.productionHelpers.UserListProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	UserListProductionHelper h = (UserListProductionHelper) helper;
	XData data = h.getData(jh);
	XNodes nodes = data.getNodes("/select/user");
	
%>

<!-- ********** INSERT HTML HERE ********** -->
<table border=1>
	<tr>
		<th><center>ID</center></th>
		<th><center>Username</center></th>
		<th><center>Password</center></th>
	</tr>
	<% for (nodes.first(); nodes.next();) {%>
	<tr>
		<td width=50><a href="%%targetPage%%?userId=<%=nodes.getText("userId") %>"><%=nodes.getText("userId") %></a></td>
		<td width=200><%=nodes.getText("username") %></td>
		<td width=200><%=nodes.getText("password") %></td>
	</tr>
	<% } %>
</table>

<!--END-->
</body>
</html>
