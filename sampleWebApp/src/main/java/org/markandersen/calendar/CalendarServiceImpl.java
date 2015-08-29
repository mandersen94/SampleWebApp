package org.markandersen.calendar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * 
 * @author mandersen
 */
public class CalendarServiceImpl implements CalendarService {

	/**
	 * 
	 */
	public CalendarInfo[][] getEventsForMonth(Calendar calendar) {

		Calendar today = Calendar.getInstance();
		Calendar monthCalendar = (Calendar) calendar.clone();
		monthCalendar.set(Calendar.DATE, 1);

		// get the number of days in the month.
		int numberOfDaysInMonth = monthCalendar.getActualMaximum(Calendar.DATE);

		// day of the week for the first day
		int dayOfWeek = monthCalendar.get(Calendar.DAY_OF_WEEK);

		// build the last day of the month.
		Calendar lastDayOfMonth = (Calendar) monthCalendar.clone();
		lastDayOfMonth.add(Calendar.MONTH, 1);
		lastDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		lastDayOfMonth.add(Calendar.DATE, -1);

		int weeksInMonth = lastDayOfMonth.get(Calendar.WEEK_OF_MONTH);
		CalendarInfo[] calendarBlocks = new CalendarInfo[numberOfDaysInMonth
				+ dayOfWeek - 1];
		int index = dayOfWeek - 1;

		// get days of the month into an array
		for (int i = index; i < calendarBlocks.length; i++) {
			Calendar cal = (Calendar) monthCalendar.clone();
			Event[] event = new Event[] {
					new Event( 1, "Claire's Birthday", "Claire's message",
							new Date(), new Date()),
					new Event( 2, "Katie's Birthday", "Jaspers", new Date(),
							new Date()) };
			calendarBlocks[i] = new CalendarInfo(cal, cal.getTime(), Arrays
					.asList(event), CalendarUtil.isDateMonthYearEqual(cal, today));
			monthCalendar.add(Calendar.DATE, 1);
		}

		// calendars in any array for each week.
		CalendarInfo[][] calendarWeeks = new CalendarInfo[weeksInMonth][7];
		int week = 0;
		int day = 0;
		for (int i = 0; i < calendarBlocks.length; i++) {
			calendarWeeks[week][day] = calendarBlocks[i];
			day++;
			if (day == 7) {
				day = 0;
				week++;
			}
		}

		return calendarWeeks;
	}

	/**
	 * 
	 * @param weeksInMonth
	 * @param calendarWeeks
	 */
	public static void printOutCalendar(CalendarInfo[][] calendarWeeks) {

		// go through the number of weeks.
		for (int i = 0; i < calendarWeeks.length; i++) {

			// go through the days of the weeks.
			for (int j = 0; j < 7; j++) {
				CalendarInfo calendarInfo = calendarWeeks[i][j];
				Calendar temp = calendarInfo.getCalendar();
				if (temp == null) {
					System.out.print("null\t");
				} else {
					System.out.print(temp.get(Calendar.DATE) + "\t");
				}
			}
			System.out.println("");
		}
	}

}
