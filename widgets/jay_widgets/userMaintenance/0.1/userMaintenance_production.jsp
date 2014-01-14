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
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.jay.productionHelpers.UserMaintenanceProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	UserMaintenanceProductionHelper h = (UserMaintenanceProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<form method="post">
<input type =hidden value ="<%=h.getUserId() %>" name= "userId">
<input type=hidden value ="jay_widgets.userMaintenance.user" name="op"  >
<table>
	<thead></thead>
	<tbody>
	<tr><td>UserId:</td><td><label><%=h.getUserId() %></label></td></tr>
		<tr>
				<td>Username:</td><td><input type=text name=username value="<%=h.getUsername() %>" /></td>
		</tr>
		<tr>		
				<td>Password:</td><td><input type=text name=password value ="<%=h.getPassword() %>" /></td>
		</tr>
		<tr>
				<td><input type=submit value=Save /></td><td></td>
		</tr>
	</tbody>
</table>
</form>

<!--END-->
</body>
</html>
