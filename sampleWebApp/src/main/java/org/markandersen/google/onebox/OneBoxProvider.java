package org.markandersen.google.onebox;

import java.util.Iterator;

import com.google.enterprise.sdk.onebox.FailureCode;
import com.google.enterprise.sdk.onebox.Field;
import com.google.enterprise.sdk.onebox.IOneBoxResults;
import com.google.enterprise.sdk.onebox.ModuleResult;
import com.google.enterprise.sdk.onebox.OneBoxResults;
import com.google.enterprise.sdk.onebox.samples.EmployeeDirectory;

public class OneBoxProvider extends
		com.google.enterprise.sdk.onebox.OneBoxProvider {

	/**
	 * Method is delegated to by the Google servlet.
	 */
	@Override
	protected IOneBoxResults provideOneBoxResults(String apiMaj, String apiMin,
			String oneboxName, String dateTime, String ipAddr, String lang,
			String query, String[] matchGroups) {
		// Create results object
		OneBoxResults res = new OneBoxResults();

		// Check api version for compatibility
		int apiVersion = ((Integer.parseInt(apiMaj) << 0xFF) | (Integer
				.parseInt(apiMin)));
		if (apiVersion < ((1 << 0xFF) | 0)) { // 1.0
			res
					.setFailure(FailureCode.lookupFailure,
							"OneBox API versions older than 1.0 not supported by provider");
			return res;
		}
		// Check language for compatibility
		if (!"en".equalsIgnoreCase(lang)) {
			res.setFailure(FailureCode.lookupFailure,
					"Languages other than english not supported by provider");
			return res;
		}

		//
		// TODO implement your OneBox here...
		//

		res
				.setProviderText("NoAuthEmployeeDirectoryProvider: ACME Employee Directory");
		res.setImageUrl(webAppBaseURL + "samples/hashmap/images/acme.JPG");

		int matchCount = 0;
		// Search by brute force. In a real provider with a larger dataset or
		// with
		// more complex computations you'd want to use a faster, more robust
		// lookup
		// mechanism such as a relational database.
		for (Iterator iter = EmployeeDirectory.iterator(); iter.hasNext();) {
			EmployeeDirectory.EmployeeDirectoryEntry emp = (EmployeeDirectory.EmployeeDirectoryEntry) iter
					.next();

			if (query.toUpperCase().equals(emp.lastName.toUpperCase())) {
				matchCount++;
				if (res.canAddResult()) {
					ModuleResult mr = new ModuleResult(emp.lastName + ", "
							+ emp.firstName, webAppBaseURL
							+ "acme_directory.html");
					mr.addField(new Field("position", emp.position));
					mr.addField(new Field("department", emp.department));
					mr.addField(new Field("phone", emp.phone));
					mr.addField(new Field("email", emp.email));
					mr.addField(new Field("building", emp.building));
					mr.addField(new Field("office", emp.office));
					res.addResult(mr);
				}
			}
		}
		res.setResultsTitleLink(matchCount
				+ " matching results in the ACME Employee Directory",
				webAppBaseURL + "samples/hashmap/acme_directory.html");
		return res;

	}
}
