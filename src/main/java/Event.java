import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * A task that is scheduled for a specific time.
 */public class Event extends Task{
    protected boolean timeBool;
    protected LocalDateTime dateTime;
    protected LocalDate date;

    protected DateTimeFormatter formatInput;
    protected DateTimeFormatter formatOutputTime = DateTimeFormatter.ofPattern("MMM d yyyy hh:m a");
    protected DateTimeFormatter formatOutputNoTime = DateTimeFormatter.ofPattern("MMM d yyyy");

    public Event(String description, String dateString, DateTimeFormatter formatInput, boolean timeBool) {
        super(description);
        this.formatInput = formatInput;
        this.timeBool = timeBool;
        if (!timeBool) {
            this.date = LocalDate.parse(dateString, formatInput);
        } else {
            this.dateTime = LocalDateTime.parse(dateString, formatInput);
        }
    }

    /**
     * Provides a String representation of the Deadline.
     * @return A String representation of the Deadline.
     */
    @Override
    public String toString() {
        if (timeBool) {
            return "[E][" + this.getStatusIcon() + "] " + this.description + " (at: " +
                    formatOutputTime.format(this.dateTime) + ")";
        } else {
            return "[E][" + this.getStatusIcon() + "] " + this.description + " (at: " +
                    formatOutputNoTime.format(this.date) + ")";
        }
    }
}
