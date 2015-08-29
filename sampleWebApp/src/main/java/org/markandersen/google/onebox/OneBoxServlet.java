package org.markandersen.google.onebox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneBoxServlet extends HttpServlet {


	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("OneBoxServlet::init()");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3455160563424461604L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		dumpParams(request);
		writeResponse(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void writeResponse(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			String output =  getResultsFile();		
			writer.println(output );
		} finally {
			writer.close();
		}
	}

	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	private String getResultsFile() throws IOException {
		String filename = "/Users/mandersen/developer/google-gsa/onebox/google_onebox_sdk/mark_ext_results.xml";
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = "";
		StringBuffer buf = new StringBuffer();
		while((line = br.readLine()) != null){
			buf.append(line).append("\n");
		}
		return buf.toString();
	}

	/**
	 * 
	 * @param req
	 */
	@SuppressWarnings("unchecked")
	private void dumpParams(HttpServletRequest request) {
		System.out.println("Dumping paramters.\n");
		Set<String> keySet = request.getParameterMap().keySet();
		for (String key : keySet) {
			String value = request.getParameter(key);
			System.out.printf("%s = %s\n", key, value);
		}

	}
}
