
# Calendar Scheduler (JavaFX)

Simple calendar/scheduler built with JavaFX. Navigate months/years, view days, and add/edit basic appointments.
Focuses on clean UI separation and data-structure modeling (indexing appointments by date).

**Status:** Built earlier and worked at submission time; not re-run on this machine now.

## Project Structure
```
calendar-scheduler/
├─ src/main/java/
│  ├─ Project.java               # JavaFX entry point
│  ├─ CalendarController.java    # UI logic: navigation & appointment CRUD
│  ├─ CalendarYears.java         # Model: collection of years/months, indexing data
│  └─ Year.java                  # Model for year/month/day representation
└─ src/main/resources/
    └─ project.fxml               # UI layout (FXML)
```

## Highlights
- Uses **data structures** (lists/maps) to store and index appointments by date.
- JavaFX + FXML UI: month/year navigation, day grid, simple dialogs.
- Clear separation of **model** (calendar data) and **controller** (UI events).

## How to Run
- **JDK 17+** and **JavaFX 17+**
- Open in IntelliJ IDEA and run `Project.java`.

Command-line (if needed):
```
--module-path "<path-to-javafx>/lib" --add-modules javafx.controls,javafx.fxml
```

## Notes
- Ensure `fx:controller` in `src/main/resources/project.fxml` matches `CalendarController`
  (use the full package name if you added one).
- `@FXML` fields/methods must match `fx:id` values in the FXML.

## Possible Improvements
- Persist appointments to JSON/CSV (save/load).
- Week view and search/filter.
- Recurring events, reminders, and import/export (ICS).
```
