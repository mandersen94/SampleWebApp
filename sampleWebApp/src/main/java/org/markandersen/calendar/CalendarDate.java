package org.markandersen.calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * A date on the Calendar.
 * 
 * @author mandersen
 */
public class CalendarDate {

	private int dateNumber;
	
	private List<CalendarEvent> calendarEvents = new ArrayList<CalendarEvent>();

	public CalendarDate() {
	}
	
	public CalendarDate(int dateNumber, List<CalendarEvent> calendarEvents){
		this.dateNumber = dateNumber;
		this.calendarEvents = calendarEvents;
	}
	
	public int getDateNumber() {
		return dateNumber;
	}

	public void setDateNumber(int dateNumber) {
		this.dateNumber = dateNumber;
	}

	public List<CalendarEvent> getCalendarEvents() {
		return calendarEvents;
	}

	public void setCalendarEvents(List<CalendarEvent> calendarEvents) {
		this.calendarEvents = calendarEvents;
	}
	
	
	
}
