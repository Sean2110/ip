package PooPoo.tasklist;

/**
 * The {@code ToDo} class represents a simple task without a specific deadline or time range.
 * It extends the {@code Task} class.
 */
public class ToDo extends Task{

    /**
     * Constructs a {@code ToDo} task with the given description.
     *
     * @param description The description of the ToDo task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the ToDo task,
     * including its type and description.
     *
     * @return A formatted string representing the ToDo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
