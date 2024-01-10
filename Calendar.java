public class Calendar {
    static int currentMonth;
    static int currentDay;
    static int startYear;
    static int curretYear;
    static int endYear;
    static int currentDayOfTheWeek;
    static int nDaysInMonth;
    static boolean isLeapYear;
    static int nDays;

    public static void main(String args[]) {
        startYear = 1990;
        curretYear = Integer.parseInt(args[0]);
        endYear = curretYear + 1;
        advance();
    }

    // Advances the date (day, month, year) and the day-of-the-week
    public static void advance() {
        currentDayOfTheWeek = 2;
        while (startYear < endYear) {
            currentMonth = 1;
            while (currentMonth <= 12) {
                currentDay = 1;
                while (currentDay <= nDaysInMonth(currentMonth, startYear)) {
                    if (startYear == curretYear) {
                        if (currentDayOfTheWeek <= 7) {
                            System.out.print(currentDay + "/" + currentMonth + "/" + startYear);
                            if (currentDayOfTheWeek == 1) {
                                System.out.print(" Sunday");
                                currentDay++;
                                currentDayOfTheWeek++;
                            } else {
                                currentDay++;
                                currentDayOfTheWeek++;
                            }
                            if (currentDayOfTheWeek > 7) {
                                currentDayOfTheWeek = 1;
                            }
                        }
                        System.out.println();
                    } else {
                        if (currentDayOfTheWeek <= 7) {
                            if ((currentDay == 1) && (currentDayOfTheWeek) == 1) {
                                currentDay++;
                                currentDayOfTheWeek++;
                            } else {
                                currentDay++;
                                currentDayOfTheWeek++;
                            }
                            if (currentDayOfTheWeek > 7) {
                                currentDayOfTheWeek = 1;
                            }
                        }
                    }
                }
                currentMonth++;
            }
            startYear++;
        }
    }

    // Returns true if the given year is a leap year, false otherwise
    private static boolean isLeapYear(int year) {
        isLeapYear = ((year % 400) == 0);
        isLeapYear = isLeapYear || ((year % 4) == 0 && (year % 100) != 0);
        return isLeapYear;
    }

    // Returns the number of days in the given month and year
    private static int nDaysInMonth(int curMonth, int startYear) {
        int days = 0;
        switch (curMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = isLeapYear(curretYear) ? 29 : 28;
                break;
            default:
                days = 31;
        }
        return days;
    }
}