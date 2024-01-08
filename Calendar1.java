/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2; // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int sundayCount = 0; // Declare sundayCount as a static class variable

	/**
	 * Prints the calendars of all the years in the 20th century. Also prints the
	 * number of Sundays that occured on the first day of the month during this
	 * period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999,
		// inclusive.
		// Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday,
		// prints "Sunday".
		// The following variable, used for debugging purposes, counts how many days
		// were advanced so far.

		advance();
		while (year < 2000) {
			// Write the body of the while
			advance();
		}

		// Write the necessary ending code here
		System.out.println("During the 20th century, " + sundayCount + " Sundays fell on the first day of the month");
	}

	// Advances the date (day, month, year) and the day-of-the-week.
	// If the month changes, sets the number of days in this month.
	// Side effects: changes the static variables dayOfMonth, month, year,
	// dayOfWeek, nDaysInMonth.
	private static void advance() {
		dayOfWeek = (dayOfWeek % 7) + 1; // Update the day of the week

		// If the day is a Sunday and it's the first day of the month, print "Sunday".
		if (dayOfWeek == 1 && dayOfMonth == 1) {
			System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
			sundayCount++;
		} else {
			System.out.println(dayOfMonth + "/" + month + "/" + year);
		}

		if (dayOfMonth == nDaysInMonth) {
			// If it's the last day of the month, reset to the first day of the next month
			dayOfMonth = 1;
			if (month == 12) {
				// If it's December, reset to January of the next year
				month = 1;
				year++;
			} else {
				// If it's not December, move to the next month
				month++;
			}
			nDaysInMonth = nDaysInMonth(month, year); // Update the number of days in the new month
		} else {
			// If it's not the last day of the month, simply move to the next day
			dayOfMonth++;
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		return (year % 4 == 0);
	}

	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int days = 0;
		switch (month) {
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				days = isLeapYear(year) ? 29 : 28;
				break;
			default:
				days = 31;
		}
		return days;
	}
}
