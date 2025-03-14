package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.Event;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

/**
 * The {@code EventCommand} class handles the creation and addition of an
 * {@code Event} task to the task list.
 */
public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    /**
     * Constructs an {@code EventCommand} with the given description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from        The start time of the event.
     * @param to          The end time of the event.
     */
    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    /**
     * Executes the event command by adding a new {@code Event} task to the task list.
     * Displays the added event using the UI and saves the updated task list to storage.
     *
     * @param tasks   The task list to which the event is added.
     * @param ui      The UI instance used to display the task addition.
     * @param storage The storage system where tasks are saved.
     * @throws PooPooException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException {
        Event eventTask = new Event(description, from, to);
        tasks.addTask(eventTask);
        ui.showEvent();
        storage.saveTasks(tasks);
    }

}
