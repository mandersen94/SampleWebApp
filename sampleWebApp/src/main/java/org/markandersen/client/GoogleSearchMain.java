package org.markandersen.client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class GoogleSearchMain {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		URLConnection urlConnection = null;
		LineNumberReader lnr = null;

		try {
			URL url = null;
			// https://www.google.com/search?client=safari&rls=en&q=michael+jordan&ie=UTF-8&oe=UTF-8
			if (args.length > 0) {
				url = new URL("http://www.google.com/search?q=" + URLEncoder.encode(args[0]));
			} else {
				url = new URL("http://www.google.com");
			}

			urlConnection = url.openConnection();
			lnr = new LineNumberReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String temp = lnr.readLine();
			while (temp != null) {
				sb.append(temp);
				temp = lnr.readLine();
			}
			System.out.printf("output size  = %d\n", sb.length());

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (lnr != null) {
				try {
					lnr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
