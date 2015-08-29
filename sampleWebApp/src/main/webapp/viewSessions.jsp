<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<jsp:directive.page import="java.net.InetAddress"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'viewSession.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript"></script>



	</head>

	<body> 
		Host = <%= InetAddress.getLocalHost() %><br>Web Session Info. 
		<br><br>
		session creation time = <%= new Date(session.getCreationTime()) %><br><br>
		session id = <%= session.getId() %><br><br>
		session is new = <%= session.isNew() %><br><br>
		session last accessed time = <%= new Date(session.getLastAccessedTime()) %><br><br>

		<%
			Boolean hasSessionBoolean = (Boolean) request.getAttribute("hasSession");
            boolean hasSession = hasSessionBoolean.booleanValue();
            
			List keys = (List) request.getAttribute("keys");
			if (keys == null) {
				keys = new ArrayList();
			} else {
				
			}
			for (int i = 0; i < keys.size(); i++) {
				String key = (String) keys.get(i);
				String value = (String) session.getAttribute(key);
		%>
		<%=key%>
		=
		<%=value%><br>
		<%
		}
		%>
		
		<br>
		<a href="sessionAddAttribute.jsp">Add Session Attribute</a><br/>
		<a href="index.jsp">Main Page</a>
	</body>
</html>

