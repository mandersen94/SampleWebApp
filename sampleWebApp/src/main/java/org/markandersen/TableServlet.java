package org.markandersen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: TableServlet
 * 
 */
public class TableServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	private List<String[]> tableData;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public TableServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		initTableData();
		getServletContext().setAttribute("tableData", tableData);

	}

	/**
	 * creates the table data.
	 */
	private void initTableData() {
		tableData = new ArrayList<String[]>();
		int rows = 1000;
		int columns = 6;
		for (int i = 0; i < rows; i++) {
			String[] row = new String[columns];
			for (int j = 0; j < columns; j++) {
				row[j] = "row " + i + ", column " + j;
			}
			tableData.add(row);
		}
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Enumeration parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = (String) parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.printf("%s = %s\n", paramName, paramValue);
		}

		int offset = Integer.parseInt(request.getParameter("offset"));
		int pageSize = 50;

		int startIndex = offset;
		int endIndex = (startIndex + pageSize - 1);
		if (endIndex >= tableData.size()) {
			endIndex = tableData.size();
		}

		System.out.printf("startIndex = %d, endIndex = %d\n", startIndex,
				endIndex);
		List<String[]> subList = tableData.subList(startIndex, endIndex);
		request.setAttribute("subList", subList);
		request.setAttribute("startIndex", startIndex);
		request.setAttribute("endIndex", endIndex);

		response.setContentType("text/xml");
		PrintWriter writer = response.getWriter();
		printHeader(writer, offset);
		for (String[] columns : subList) {
			writer.println("<tr>");
			for (String column : columns) {
				writer.println("<td>" + column + "</td>");
			}
			writer.println("</tr>");
		}

		printFooter(writer, tableData.size());
		writer.close();

		// String page = "table.jspx";
		// RequestDispatcher requestDispatcher = request
		// .getRequestDispatcher(page);
		// requestDispatcher.forward(request, response);
	}

	private void printFooter(PrintWriter writer, int rowCount) {
		writer.println("</rows><rowcount>" + rowCount
				+ "</rowcount></response>	</ajax-response>");
	}

	private void printHeader(PrintWriter writer, int offset) {
		writer.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>");
		writer
				.println("<ajax-response>");
		writer.println("<response type=\"object\" id=\"data_grid_updater\">");
		writer.println("<rows update_ui=\"true\" offset=\"" + offset + "\">");

	}
}