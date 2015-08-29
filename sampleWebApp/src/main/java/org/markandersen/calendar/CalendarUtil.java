package org.markandersen.calendar;

import java.util.Calendar;

/**
 * 
 *
 * @author mandersen
 */
public class CalendarUtil {

	/**
	 * Returns true if the Calendar objects represent the same Day, Month, and Year.  
	 * Else returns false.  There is no comparision or evaluation of time.
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean isDateMonthYearEqual(Calendar one, Calendar two){
		
		if( (one.get(Calendar.DAY_OF_MONTH)) != (two.get(Calendar.DAY_OF_MONTH)) ){
			return false;
		} else if ( (one.get(Calendar.MONTH)) != (two.get(Calendar.MONTH)) ){
			return false;
		} else if ( (one.get(Calendar.YEAR)) != (two.get(Calendar.YEAR)) ){
			return false;
		} else {
			return true;
		}
		
	}
}
