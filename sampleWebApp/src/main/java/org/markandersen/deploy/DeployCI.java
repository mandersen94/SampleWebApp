package org.markandersen.deploy;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author mandersen
 */
public class DeployCI {

	public String calculateRedirectURL(HttpServletRequest request) {

		String serverName = request.getServerName();
		String protocol = request.getProtocol();

		return "https://" + serverName
				+ "/ci20/index.jsp?applicationName=swaCAI";
	}
}
