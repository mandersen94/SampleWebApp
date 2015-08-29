package org.markandersen.calendar;

import java.util.Date;

/**
 * 
 * @author mandersen
 */
public class Event {

	private int eventId;
	
	private String title;
	
	private String message;
	
	private Date startTime;
	
	private Date endTime;

	public Event(int eventId, String title, String message, Date startTime, Date endTime){
		this.eventId = eventId;
		this.title = title;
		this.message = message;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	
}
