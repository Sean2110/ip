package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.Deadline;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

/**
 * The {@code DeadlineCommand} class handles the creation and addition of a
 * {@code Deadline} task to the task list.
 */
public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    /**
     * Constructs a {@code DeadlineCommand} with the given description and due date.
     *
     * @param description The description of the deadline task.
     * @param by The due date of the deadline task.
     */
    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the deadline command by adding a new {@code Deadline} task to the task list.
     * Displays the added task using the UI and saves the updated task list to storage.
     *
     * @param tasks   The task list to which the deadline task is added.
     * @param ui      The UI instance used to display the task addition.
     * @param storage The storage system where tasks are saved.
     * @throws PooPooException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException {
        Deadline deadlineTask = new Deadline(description, by);
        tasks.addTask(deadlineTask);
        ui.showDeadline();
        storage.saveTasks(tasks);
    }

}
