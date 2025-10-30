/**
 * This class represents a collection of `Year` objects for a fixed range of years (2023–2026).
 * It allows retrieving a `Year` object based on the specified year number.
 */
public class CalendarYears {

    // `Year` objects for the years 2023 through 2026.
    private Year y2023;
    private Year y2024;
    private Year y2025;
    private Year y2026;

    /**
     * Constructor for the CalendarYears class.
     * Initializes `Year` objects for the years 2023, 2024, 2025, and 2026.
     */
    public CalendarYears() {
        y2023 = new Year(2023); // Initialize the Year object for 2023.
        y2024 = new Year(2024); // Initialize the Year object for 2024.
        y2025 = new Year(2025); // Initialize the Year object for 2025.
        y2026 = new Year(2026); // Initialize the Year object for 2026.
    }

    /**
     * Retrieves the `Year` object for the specified year.
     *
     * @param numYear The year number to retrieve (e.g., 2023).
     * @return The corresponding `Year` object for the given year.
     *         Returns the `Year` for 2026 if the year is not in the range 2023–2025.
     */
    public Year getYear(int numYear) {
        // Check which year matches and return the corresponding `Year` object.
        if (numYear == 2023)
            return y2023;
        if (numYear == 2024)
            return y2024;
        if (numYear == 2025)
            return y2025;

        // Default to returning the `Year` object for 2026.
        return y2026;
    }
}
