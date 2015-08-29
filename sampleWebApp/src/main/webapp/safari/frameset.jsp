<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<HTML>

<HEAD>
	<TITLE>SWALife</TITLE>
	<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
	<META HTTP-EQUIV="Expires" CONTENT="1">
	<META http-equiv=Content-Type content="text/html; charset-big5">

</HEAD>




<!--  --> 
<FRAMESET id="swaFrameSet" rows="100,*" BORDER="0" FRAMEBORDER="NO" >

	<FRAME SCROLLING="AUTO" 
		name="portalTimerFrame" 
		src="/webExample/safari/keepalive.jsp">
		
	<FRAME SCROLLING="AUTO" noresize
		name="portalMainFrame" 
		src="/webExample/safari/portal.jsp">
		
		
</FRAMESET>
</HTML>
