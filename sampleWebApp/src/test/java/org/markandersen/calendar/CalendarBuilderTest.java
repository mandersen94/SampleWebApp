package org.markandersen.calendar;

import java.util.Calendar;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalendarBuilderTest {

	private CalendarBuilder calendarBuilder = new CalendarBuilder();

	/**
	 * 
	 */
	@Test
	public void testGetWeeksOfMonthArrayWeeks() {

		Calendar septFirstCalendar = Calendar.getInstance();
		septFirstCalendar.set(2009, Calendar.SEPTEMBER, 1);
		Calendar[][] weeksOfMonthArray = calendarBuilder
				.getWeeksOfMonthArray(septFirstCalendar);
		CalendarBuilder.printOutCalendar(weeksOfMonthArray);
		
		assertEquals("Wrong number of weeks returned.", 5,
				weeksOfMonthArray.length);
		assertNull("Should have been null.", weeksOfMonthArray[0][0]);
		assertNull("Should have been null.", weeksOfMonthArray[0][1]);
		assertEquals("Should have been 1.", 1, weeksOfMonthArray[0][2].get(Calendar.DAY_OF_MONTH));
		assertEquals("Should have been 2.", 2, weeksOfMonthArray[0][3].get(Calendar.DAY_OF_MONTH));

		assertEquals("Should have been 28.", 28, weeksOfMonthArray[4][1].get(Calendar.DAY_OF_MONTH));
		assertEquals("Should have been 29.", 29, weeksOfMonthArray[4][2].get(Calendar.DAY_OF_MONTH));
		assertEquals("Should have been 30.", 30, weeksOfMonthArray[4][3].get(Calendar.DAY_OF_MONTH));
		assertNull("Should have been null.", weeksOfMonthArray[4][4]);
		assertNull("Should have been null.", weeksOfMonthArray[4][5]);
		assertNull("Should have been null.", weeksOfMonthArray[4][6]);

		
		Calendar febFirstCalendar = Calendar.getInstance();
		febFirstCalendar.set(2009, Calendar.FEBRUARY, 1);
		weeksOfMonthArray = calendarBuilder
				.getWeeksOfMonthArray(febFirstCalendar);
		CalendarBuilder.printOutCalendar(weeksOfMonthArray);
		assertEquals("Wrong number of weeks returned.", 4,
				weeksOfMonthArray.length);
		assertEquals("Should have been 1.", 1, weeksOfMonthArray[0][0].get(Calendar.DAY_OF_MONTH));
		assertEquals("Should have been 2.", 2, weeksOfMonthArray[0][1].get(Calendar.DAY_OF_MONTH));
		assertEquals("Should have been 3.", 3, weeksOfMonthArray[0][2].get(Calendar.DAY_OF_MONTH));
		assertEquals("Should have been 4.", 4, weeksOfMonthArray[0][3].get(Calendar.DAY_OF_MONTH));

		assertEquals("Should have been 26.", 26, weeksOfMonthArray[3][4].get(Calendar.DAY_OF_MONTH));
		assertEquals("Should have been 27.", 27, weeksOfMonthArray[3][5].get(Calendar.DAY_OF_MONTH));
		assertEquals("Should have been 28.", 28, weeksOfMonthArray[3][6].get(Calendar.DAY_OF_MONTH));

		
	}
}
