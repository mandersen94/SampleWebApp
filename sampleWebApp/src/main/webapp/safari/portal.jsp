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
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<META http-equiv=Content-Type content="text/html; charset-big5">
	<script type="text/javascript">
		function doOnLoad(){
			console.log("doOnLoad()::");			
			var onLoadDiv = document.getElementById('eipOnLoadUrl');
				if ( onLoadDiv != null ) { 
 					top.portalMainFrame.document.location=onLoadDiv.innerHTML;
				} 
			
		}
	
	</script>
	</HEAD>
	<BODY style="background-color: green;" onload="doOnLoad();">
		<p>This is the portal.</p>
		<% if (true) { %>
		<div id="eipOnLoadUrl">/webExample/safari/redirect.jsp</div>
		<% } %>
	</BODY>
</HTML>
