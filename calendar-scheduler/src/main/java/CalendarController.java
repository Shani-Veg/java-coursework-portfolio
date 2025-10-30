import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;

/**
 * The `CalendarController` class handles the logic and UI interaction for a calendar application.
 * It manages year and month selection, displays a grid-based calendar, and allows scheduling of appointments.
 */
public class CalendarController {

    @FXML
    private Label monthAndYear; // Label to display the current month and year.

    @FXML
    private ComboBox<Integer> monthChange; // Dropdown menu for selecting a month.

    @FXML
    private ComboBox<Integer> yearChange; // Dropdown menu for selecting a year.

    @FXML
    private GridPane calendarBord; // GridPane to display the calendar days.

    @FXML
    private Label daysOfWeekText; // Label to display the days of the week.

    private int yearNum; // Currently selected year.
    private int monthNum; // Currently selected month.

    private String[] monthsName = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    }; // Array of month names.

    private String daysName = "\tSunday\t   Monday\t     Tuesday    Wednesday     Thursday\t\tFriday\t  Saturday";
    private CalendarYears calendarYears; // Instance of `CalendarYears` to manage year data.
    private final int DAYS = 7; // Number of days in a week.
    private final int WEEKS = 6; // Maximum number of weeks in a month (rows in the calendar grid).
    private Button dayButton[]; // Array of buttons for each calendar day.
    private int date; // Selected date for appointments.

    /**
     * Initializes the calendar view and sets up default values for the UI components.
     */
    public void initialize() {
        calendarYears = new CalendarYears(); // Initialize `CalendarYears` for managing years.

        // Populate the month and year dropdowns.
        for (int i = 1; i < 13; i++) {
            monthChange.getItems().add(i);
        }
        for (int i = 2023; i < 2027; i++) {
            yearChange.getItems().add(i);
        }

        // Set the days of the week label.
        daysOfWeekText.setText(daysName);

        // Initialize the calendar grid buttons.
        dayButton = new Button[DAYS * WEEKS];
        for (int i = 0; i < DAYS * WEEKS; i++) {
            dayButton[i] = new Button();
            dayButton[i].setText(""); // Initially, no date is displayed.
            dayButton[i].setPrefSize(
                    calendarBord.getPrefWidth() / DAYS,
                    calendarBord.getPrefHeight() / WEEKS
            );

            // Add buttons to the grid layout.
            calendarBord.add(dayButton[i], i % DAYS, i / DAYS);

            // Set an event handler for each button.
            dayButton[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    handleButton(event);
                }
            });
        }
    }

    /**
     * Handles the change of the month and year using the dropdown menus.
     * Updates the calendar display accordingly.
     */
    @FXML
    void changeButton(ActionEvent event) {
        yearNum = yearChange.getValue(); // Get selected year.
        monthNum = monthChange.getValue(); // Get selected month.

        // Update the label to show the selected month and year.
        monthAndYear.setText(monthsName[monthNum - 1] + " " + yearNum);

        // Clear dropdown selections.
        monthChange.setValue(null);
        yearChange.setValue(null);

        // Get the starting day of the week and the number of days in the month.
        int dayInWeek = calendarYears.getYear(yearNum).getDayInWeek(yearNum, monthNum);
        int numOfDays = getNumOfDays(monthNum, yearNum);

        // Clear all buttons (reset the calendar grid).
        for (int i = 0; i < DAYS * WEEKS; i++) {
            dayButton[i].setText("");
            dayButton[i].setStyle("");
        }

        // Populate the calendar grid with day numbers and highlight days with appointments.
        for (int i = 0; i < numOfDays; i++) {
            dayButton[dayInWeek + i - 1].setText((i + 1) + ""); // Set day number.

            // Highlight days with appointments.
            if (calendarYears.getYear(yearNum).getMonth(monthNum).containsKey(i + 1)) {
                dayButton[dayInWeek + i - 1].setStyle("-fx-background-color: lightblue; -fx-font-weight: bold;");
            }
        }
    }

    /**
     * Calculates the number of days in a given month of a specific year.
     *
     * @param month The month (1 for January, 12 for December).
     * @param year  The year.
     * @return The number of days in the specified month.
     */
    private int getNumOfDays(int month, int year) {
        // Handle months with 30 days.
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        // Handle February (consider leap years).
        if (month == 2) {
            if (year == 2024) // Leap year (e.g., 2024).
                return 29;
            else
                return 28;
        }

        // Default case: months with 31 days.
        return 31;
    }

    /**
     * Handles button clicks for specific calendar days.
     * Opens a dialog to view or edit appointments for the selected day.
     *
     * @param event The action event triggered by a button click.
     */
    private void handleButton(ActionEvent event) {
        Button tempButton = (Button) event.getSource(); // Get the button that was clicked.
        date = Integer.parseInt(tempButton.getText()); // Extract the day number.
        showDialog(yearNum, monthNum, date); // Show the appointment dialog.
    }

    /**
     * Displays a dialog box for viewing or editing appointments for a specific day.
     *
     * @param yearNum  The selected year.
     * @param monthNum The selected month.
     * @param date     The selected day.
     */
    private void showDialog(int yearNum, int monthNum, int date) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Appointments for " + date + "/" + monthNum + "/" + yearNum);

        // Text area for displaying or editing the appointment.
        TextArea textArea = new TextArea();
        if (calendarYears.getYear(yearNum).getMonth(monthNum).containsKey(date)) {
            textArea.setText(calendarYears.getYear(yearNum).getMonth(monthNum).get(date)); // Load existing appointment.
        }

        dialog.getDialogPane().setContent(textArea); // Add text area to the dialog.

        // Add a "Save" button to the dialog.
        ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(saveButtonType);

        // Save the updated appointment when the dialog is closed.
        dialog.setResultConverter(dialogButton -> textArea.getText());
        String appointmentText = dialog.showAndWait().get();

        // Update the calendar data with the new appointment.
        calendarYears.getYear(yearNum).getMonth(monthNum).put(date, appointmentText);

        // Highlight the day button if an appointment is saved.
        if (!appointmentText.trim().isEmpty()) {
            int buttonIndex = calendarYears.getYear(yearNum).getDayInWeek(yearNum, monthNum) + date - 2;
            dayButton[buttonIndex].setStyle("-fx-background-color: lightblue; -fx-font-weight: bold;");
        }
    }
}
