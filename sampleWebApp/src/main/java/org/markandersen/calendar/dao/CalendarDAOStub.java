package org.markandersen.calendar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.markandersen.calendar.Event;

/**
 * 
 * @author e63582
 */
public class CalendarDAOStub implements CalendarDAO {

	public List<Event> getEventsForDay(Date date) {

		return new ArrayList<Event>();
	}
}
