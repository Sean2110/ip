package PooPoo.tasklist;

/**
 * The {@code Deadline} class represents a task with a specific due date.
 * It extends the {@code Task} class and includes a deadline.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Constructs a {@code Deadline} task with the specified description and due date.
     *
     * @param description The description of the deadline task.
     * @param by          The due date of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Retrieves the due date of the deadline task.
     *
     * @return The due date as a string.
     */
    public String getBy() {
        return this.by;
    }

    /**
     * Returns a string representation of the deadline task,
     * including its type, description, and due date.
     *
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }


}