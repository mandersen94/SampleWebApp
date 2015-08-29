
<%
	System.out.println("Keep Alive hit.");
	String prefix = "172.";
	String remoteAddr = request.getRemoteAddr();
	System.out.println("remoteAddr = " + remoteAddr);
	if(remoteAddr == null){
		remoteAddr = "";
	}
	remoteAddr = "172.18.24.192";
	
	if(remoteAddr.startsWith(prefix)){
		System.out.println("KeepAlive active");
		out.print("Y");
	} else {
		System.out.println("KeepAlive inactive");
		out.print("N");	
	}
%>