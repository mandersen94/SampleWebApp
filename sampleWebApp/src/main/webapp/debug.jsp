
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" session="false" %>

---------------------------------<br/>
Header Dump: <br/><br/>
<div>
<%
	java.util.Enumeration enumeration = request.getHeaderNames();
	while(enumeration.hasMoreElements()) {
        String headerName = (String) enumeration.nextElement();
        java.util.List headerValues = java.util.Collections.list(request.getHeaders(headerName));

        out.println(headerName + " = " + headerValues);
        out.println("<br/>");
    }
%>
    <br/><br/>
----------------------------------
<br/>
Other servlet values:<br/>
<br/>
localName = <%= request.getLocalName() %> <br/>
localAddress = <%= request.getLocalAddr() %> <br/>
localPort = <%= request.getLocalPort() %> <br/>
remoteHost = <%= request.getRemoteHost() %> <br/>
remoteAddr = <%= request.getRemoteAddr()%> <br/>
    remotePort = <%= request.getRemotePort() %> <br/>
serverName = <%= request.getServerName() %> <br/>
serverPort = <%= request.getServerPort() %> <br/>
    PathInfo = <%= request.getPathInfo() %> <br/>
    QueryString = <%= request.getQueryString()%> <br/>
    requestedSessionID = <%= request.getRequestedSessionId()%> <br/>
scheme = <%= request.getScheme()%> <br/>
isSecure = <%= request.isSecure() %> <br/>
hasHTTPSession =
    <%
        if(request.getSession(false) == null) {
            out.println("false");
        } else {
            out.println("true");
        }
    %>

    <br/>
	-----------------------------------
<br/>
machine = <%= java.net.InetAddress.getLocalHost() %>
<br/>
    -----------------------------------
<br/>
    <br/>

    Cookies:<br/><br/>
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            out.println(cookie.getName() + " = " + cookie.getValue());
            out.println("<br/>");
        }
    %>
    <br/>
</div>
