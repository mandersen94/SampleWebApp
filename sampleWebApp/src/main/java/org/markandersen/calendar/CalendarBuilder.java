package org.markandersen.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarBuilder {

	public void build() {

		List<Calendar> days = new ArrayList<Calendar>();
		Calendar monthCalendar = Calendar.getInstance();
		monthCalendar.set(Calendar.DATE, 1);
		int monthNumber = monthCalendar.get(Calendar.MONTH);
		int numberOfDaysInMonth = monthCalendar.getActualMaximum(Calendar.DATE);
		int minimalDaysInFirstWeek = monthCalendar.getMinimalDaysInFirstWeek();
		int firstDayOfWeek = monthCalendar.getFirstDayOfWeek();
		int dayOfWeek = monthCalendar.get(Calendar.DAY_OF_WEEK);
		Calendar lastDayOfMonth = monthCalendar.getInstance();
		lastDayOfMonth.add(Calendar.MONTH, 1);
		lastDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		lastDayOfMonth.add(Calendar.DATE, -1);

		int weeksInMonth = lastDayOfMonth.get(Calendar.WEEK_OF_MONTH);
		Calendar[] calendarBlocks = new Calendar[numberOfDaysInMonth
				+ dayOfWeek - 1];
		int index = dayOfWeek - 1;

		Calendar[][] calendarWeeks = new Calendar[weeksInMonth][7];

		for (int i = index; i < calendarBlocks.length; i++) {
			calendarBlocks[i] = (Calendar) monthCalendar.clone();
			monthCalendar.add(Calendar.DATE, 1);
		}

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

		for (Calendar cal : calendarBlocks) {
			if (cal == null) {
				System.out.println("date = null");
			} else {
				int date = cal.get(Calendar.DATE);
				System.out.println("date = " + date);
			}
		}

		System.out.println("done");

	}

	public static void main(String[] args) {
		new CalendarBuilder().build();

	}

	/**
	 * 
	 * @param septFirstCalendar
	 */
	public Calendar[][] getWeeksOfMonthArray(Calendar calendar) {
		
		Calendar monthCalendar = (Calendar) calendar.clone();
		monthCalendar.set(Calendar.DATE, 1);
		
		// get the number of days in the month.
		int numberOfDaysInMonth = monthCalendar.getActualMaximum(Calendar.DATE);

		//int minimalDaysInFirstWeek = monthCalendar.getMinimalDaysInFirstWeek();
		//int firstDayOfWeek = monthCalendar.getFirstDayOfWeek();
		
		//day of the week for the first day
		int dayOfWeek = monthCalendar.get(Calendar.DAY_OF_WEEK);
		
		//build the last day of the month.
		Calendar lastDayOfMonth = (Calendar) monthCalendar.clone();
		lastDayOfMonth.add(Calendar.MONTH, 1);
		lastDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		lastDayOfMonth.add(Calendar.DATE, -1);

		
		int weeksInMonth = lastDayOfMonth.get(Calendar.WEEK_OF_MONTH);
		Calendar[] calendarBlocks = new Calendar[numberOfDaysInMonth
				+ dayOfWeek - 1];
		int index = dayOfWeek - 1;


		//get days of the month into an array
		for (int i = index; i < calendarBlocks.length; i++) {
			calendarBlocks[i] = (Calendar) monthCalendar.clone();
			monthCalendar.add(Calendar.DATE, 1);
		}

		//calendars in any array for each week.
		Calendar[][] calendarWeeks = new Calendar[weeksInMonth][7];
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
	public static void printOutCalendar(Calendar[][] calendarWeeks) {
		
		//go through the number of weeks.
		for (int i = 0; i < calendarWeeks.length; i++) {
			
			//go through the days of the weeks.
			for (int j = 0; j < 7; j++) {
				Calendar temp = calendarWeeks[i][j];
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
