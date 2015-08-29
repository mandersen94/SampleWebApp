package org.markandersen.deploy;

import java.net.MalformedURLException;
import java.net.URL;


import org.springframework.mock.web.MockHttpServletRequest;

import junit.framework.TestCase;

public class DeployCITest extends TestCase {

	public void testCalculateURL() throws MalformedURLException {
		DeployCI deploy = new DeployCI();

		String originalURL = "https://www18.swalifeqa.com/ci20/swaSSOInvalidate.jsp";
		URL url = new URL(originalURL);
		MockHttpServletRequest httpRequest = new MockHttpServletRequest("GET", originalURL);
		httpRequest.setServerName(url.getHost());
		httpRequest.setProtocol(url.getProtocol());
		String calculateRedirectURL = deploy.calculateRedirectURL(httpRequest);
		String expectedURL = "https://www18.swalifeqa.com/ci20/index.jsp?applicationName=swaCAI";
		
		assertEquals(expectedURL, calculateRedirectURL);
	}
}
