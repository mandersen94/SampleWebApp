package org.markandersen.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author mandersen
 */
public class CalendarInfo {

	private Calendar calendar;
	
	private Date date;
	
	private List<Event> events;
	
	private boolean isToday = false;
	
	/**
	 * 
	 * @param calendar
	 * @param date
	 * @param events
	 * @param isToday
	 */
	public CalendarInfo(Calendar calendar, Date date, List<Event> events, boolean isToday){
		this.calendar = calendar;
		this.date = date;
		this.events = events;
		this.isToday = isToday;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public boolean isToday() {
		return isToday;
	}

	public void setToday(boolean isToday) {
		this.isToday = isToday;
	}
	
	
}
