<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" session="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>

    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<br/>
Date = <%= new Date() %><br/>
<br/>
<jsp:include page="./debug.jsp" flush="true"/>
<br/><br/>

Index page.<br>

<a href="Session">View Sessions</a><br/>
<a href="sessionAddAttribute.jsp">Add session key</a><br/>
<a href="logout.jsp">Logout</a><br/>
<a>Remove session key</a>
</body>
</html>
