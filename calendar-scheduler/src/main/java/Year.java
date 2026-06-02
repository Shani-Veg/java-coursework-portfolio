import java.util.Calendar;

/**
 * This class represents a Year object, used to calculate calendar layouts
 * and date-related alignments for a specific year number.
 */
public class Year {
    private int numOfYear;
    private Calendar calendar;

    /**
     * Constructor for the Year class.
     *
     * @param _numOfYear The year number to initialize (e.g., 2025).
     */
    public Year(int _numOfYear) {
        numOfYear = _numOfYear;
        calendar = Calendar.getInstance();
    }

    /**
     * Retrieves the day of the week for the first day of a given month and year.
     *
     * @param year  The year (e.g., 2025).
     * @param month The month number (1 for January, 12 for December).
     * @return The day of the week (1 for Sunday, 7 for Saturday).
     */
    public int getDayInWeek(int year, int month) {
        // Set the calendar to the first day of the given month and year.
        calendar.set(year, month - 1, 1);

        // Get the day of the week.
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
