import java.util.Calendar;
import java.util.HashMap;

/**
 * This class represents a Year object, which stores information about meetings
 * scheduled for each day of the year. Each month is represented as a HashMap
 * where the key is the day of the month, and the value is a string representing
 * a meeting.
 */
public class Year {
    // The year number (e.g., 2025).
    private int numOfYear;

    // Array of 12 HashMaps, each representing a month.
    // Each HashMap stores day-to-meeting mappings.
    private HashMap<Integer, String>[] month;

    // Constant for the number of months in a year.
    private final int NUM_OF_MONTH = 12;

    // Calendar instance to perform date-related calculations.
    Calendar calendar;

    /**
     * Constructor for the Year class.
     * Initializes the year, creates the months, and sets up the calendar instance.
     *
     * @param _numOfYear The year number to initialize (e.g., 2025).
     */
    public Year(int _numOfYear) {
        numOfYear = _numOfYear;

        // Initialize the month array and create the months.
        month = new HashMap[NUM_OF_MONTH];
        createMonth();

        // Set up the Calendar instance.
        calendar = Calendar.getInstance();
    }

    /**
     * Initializes the month array with empty HashMaps for each month.
     */
    private void createMonth() {
        month = new HashMap[NUM_OF_MONTH];
        for (int i = 0; i < NUM_OF_MONTH; i++) {
            month[i] = new HashMap<>();
        }
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

    /**
     * Retrieves all meetings scheduled for a specific month.
     *
     * @param monthNum The month number (1 for January, 12 for December).
     * @return A HashMap containing all day-to-meeting mappings for the month.
     */
    public HashMap<Integer, String> getMonth(int monthNum) {
        // Adjust for zero-based indexing of the month array.
        return month[monthNum - 1];
    }
}
