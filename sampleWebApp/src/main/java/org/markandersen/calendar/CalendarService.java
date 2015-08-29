package org.markandersen.calendar;

import java.util.Calendar;

/**
 * 
 * @author mandersen
 */
public interface CalendarService {

	/**
	 * 
	 * @param calendar
	 */
	public CalendarInfo[][] getEventsForMonth(Calendar calendar);
	
}
