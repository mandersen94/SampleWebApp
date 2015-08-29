package org.markandersen.bean;

import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "org.markandersen:name=StatsManagedResource", 
		description = "Marks Managed Stats Bean", log = true, logFile = "jmx.log", 
		currencyTimeLimit = 15, persistPolicy = "OnUpdate", 
		persistPeriod = 200, persistLocation = "foo", persistName = "bar")
public class Statistics {

	private int count = 0;

	public void clear() {
		count = 0;
	}

	public void incrementCount() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
