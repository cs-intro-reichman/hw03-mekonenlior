public class Calendar {

	static int dayOfMonth = 1;
	static int month = 1;
	static int dayOfWeek;
	static int year;
	static int nDaysInMonth = 31;

	public static void main(String[] args) {
		year = Integer.parseInt(args[0]);
		advance();
	}

	// Tests the isLeapYear function.
	public static void isLeapYearTest(int year) {
		String commonOrLeap = isLeapYear(year) ? "leap" : "common";
		System.out.println(year + " is a " + commonOrLeap + " year");
	}

	// Tests the nDaysInMonth function.
	public static void nDaysInMonthTest(int year) {
		for (int month = 1; month <= 12; month++) {
			System.out.println("Month " + month + " has " + nDaysInMonth(month, year) + " days");
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0);
	}

	// Returns the number of days in the given month and year.
	public static int nDaysInMonth(int month, int year) {
		int days = 0;
		switch (month) {
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 2:
				days = isLeapYear(year) ? 29 : 28;
				break;
		}
		return days;

	}

	// Advances the date (day, month, year) and the day-of-the-week.
	public static void advance() {
		// Calculate the day of week for January 1st of the current year once
		int dayOfWeekForJanuary1st = ((year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400 + 1) % 7;

		// Adjust the day of week based on the starting day
		dayOfWeek = (dayOfWeek + dayOfWeekForJanuary1st) % 7;
	
		// Print the date and day of week with conditional formatting for Sundays
		System.out.println(dayOfMonth + "/" + month + "/" + year + (dayOfWeek == 0 ? " Sunday" : ""));
	
		if (dayOfMonth == nDaysInMonth) {
			dayOfMonth = 1;
			if (month == 12) {
				month = 1;
				year++;
			} else {
				month++;
			}
			nDaysInMonth = nDaysInMonth(month, year); // Update the number of days in the new month
		} else {
			dayOfMonth++;
		}
	
		// Update the day of week
		dayOfWeek = (dayOfWeek + 1) % 7;
	
		// Recursive call for subsequent dates (already includes printing the last date)
		if (month != 12 || dayOfMonth != 31) {
			advance();
		}
	}
}
