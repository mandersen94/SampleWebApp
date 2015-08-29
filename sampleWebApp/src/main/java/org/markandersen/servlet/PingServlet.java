package org.markandersen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;

/**
 * 
 * @author e63582
 * 
 */
public class PingServlet extends HttpServlet {

	private static Logger logger = Logger.getLogger(PingServlet.class);

	/**
	 * Constructor of the object.
	 */
	public PingServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("PingServlet::process(): enter.");
		System.out.println("ping request received.");
		
		doSomethingElse(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC\"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println(" <BODY>");
		out.print(" Ping request made at " + new Date() + " <br>");
		out.println("hostname = " + request.getServerName() + "<br>");
		out.println("User-Agent = " + request.getHeader("User-Agent") + "<br>");
		out.println(" </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		logger.info("PingServlet::process(): exit.");

	}

	private void doSomethingElse(HttpServletRequest request,
			HttpServletResponse response) {
		NDC.push("doSomethingElseNDC");
		logger.info("PingServlet::doSomethingElse(): my turn.");
		NDC.pop();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
