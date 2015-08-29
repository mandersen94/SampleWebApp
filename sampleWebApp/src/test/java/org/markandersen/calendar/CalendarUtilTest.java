package org.markandersen.calendar;

import java.util.Calendar;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * 
 * @author mandersen
 */
public class CalendarUtilTest {

	@Test
	public void testIsDateMonthYearEqual() {

		CalendarUtil util = new CalendarUtil();

		Calendar one = Calendar.getInstance();
		Calendar two = Calendar.getInstance();
		int todayDay = one.get(Calendar.DAY_OF_MONTH);
		int todayMonth = one.get(Calendar.MONTH);
		int todayYear = one.get(Calendar.YEAR);

		assertTrue("Calendars should have been true.", util
				.isDateMonthYearEqual(one, two));

		one.add(Calendar.DAY_OF_MONTH, 1);
		assertFalse("Calendars were different days.", util
				.isDateMonthYearEqual(one, two));

		one.add(Calendar.DAY_OF_MONTH, -2);
		assertFalse("Calendars were different days.", util
				.isDateMonthYearEqual(one, two));

		// bring the dates back equal and verify.
		one.add(Calendar.DAY_OF_MONTH, 1);
		assertTrue("Calendars should have been true.", util
				.isDateMonthYearEqual(one, two));

		one.add(Calendar.MONTH, 1);
		assertFalse("Calendars were different months.", util
				.isDateMonthYearEqual(one, two));

		one.add(Calendar.MONTH, -2);
		assertFalse("Calendars were different months.", util
				.isDateMonthYearEqual(one, two));

		// bring the months back equal and verify.
		one.add(Calendar.MONTH, 1);
		assertTrue("Calendars should have been true.", util
				.isDateMonthYearEqual(one, two));

		one.add(Calendar.YEAR, 1);
		assertFalse("Calendars were different year.", util
				.isDateMonthYearEqual(one, two));

		one.add(Calendar.YEAR, -2);
		assertFalse("Calendars were different year.", util
				.isDateMonthYearEqual(one, two));

		one.add(Calendar.YEAR, 1);
		assertTrue("Calendars should be equal.", util.isDateMonthYearEqual(one,
				two));

	}
}
