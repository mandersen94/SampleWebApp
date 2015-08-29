

Header Dump: </br>
<div>
<%
	java.util.Enumeration enumeration = request.getHeaderNames();
	while(enumeration.hasMoreElements()){
		String headerName = (String)enumeration.nextElement();
		java.util.List headerValues = java.util.Collections.list(request.getHeaders(headerName));
		out.println(headerName + " = " + headerValues);
		out.println("<br/>");
	}
%>

<br/>

localName = <%= request.getLocalName() %> <br/>
localAddress = <%= request.getLocalAddr() %> <br/>
localPort = <%= request.getLocalPort() %> <br/>
remoteHost = <%= request.getRemoteHost() %> <br/>
remotePort = <%= request.getRemotePort() %> <br/>
serverName = <%= request.getServerName() %> <br/>
serverPort = <%= request.getServerPort() %> <br/>
<br/>
<br/>
machine = <%= java.net.InetAddress.getLocalHost() %>
<br/>
</div>
