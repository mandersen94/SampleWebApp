

<%
	session.invalidate();
	//remove cookieS
	Cookie[] cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {
		Cookie cookie = cookies[i];
		String name = cookie.getName();
		if ("swaid".equals(name)) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		} else if ("SouthwestAirlinesINT".equals(name)){
            cookie.setMaxAge(0);
            response.addCookie(cookie);		
		} else if ("JSESSIONID".equals(name)){
            cookie.setMaxAge(0);
            response.addCookie(cookie);     		
		}
	}
	
	//build the request dynamically so it doesn't depend on environments.
	//String serverName = request.getServerName();
	
	//QA
	//String url = "https://www18.swalifeqa.com/ci20/index.jsp?applicationName=swaCAI";
	
	//PROD
	String url = "https://www18.swalife.com/ci20/index.jsp?applicationName=swaCAI";
	response
			.sendRedirect(url);
%>