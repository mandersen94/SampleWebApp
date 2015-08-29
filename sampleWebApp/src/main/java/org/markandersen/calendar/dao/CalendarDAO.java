package org.markandersen.calendar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.markandersen.calendar.Event;

public interface CalendarDAO {

	public List<Event> getEventsForDay(Date date);

}
