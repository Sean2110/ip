package PooPoo.tasklist;

/**
 * The {@code Event} class represents a task that occurs within a specific time range.
 * It extends the {@code Task} class and includes a start time and an end time.
 */
public class Event extends Task{
    protected String from;
    protected String to;

    /**
     * Constructs an {@code Event} task with the specified description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from        The start time of the event.
     * @param to          The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Retrieves the start time of the event.
     *
     * @return The start time as a string.
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Retrieves the end time of the event.
     *
     * @return The end time as a string.
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Returns a string representation of the event task,
     * including its type, description, start time, and end time.
     *
     * @return A formatted string representing the event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

}
