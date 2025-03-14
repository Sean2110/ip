package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.tasklist.ToDo;
import PooPoo.ui.Ui;

/**
 * The {@code TodoCommand} class handles the creation and addition of a
 * {@code ToDo} task to the task list.
 */
public class TodoCommand extends Command {
    private final String description;

    /**
     * Constructs a {@code TodoCommand} with the given description.
     *
     * @param description The description of the ToDo task.
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the ToDo command by adding a new {@code ToDo} task to the task list.
     * Displays the added task using the UI and saves the updated task list to storage.
     *
     * @param tasks   The task list to which the ToDo task is added.
     * @param ui      The UI instance used to display the task addition.
     * @param storage The storage system where tasks are saved.
     */
    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        ToDo todoTask = new ToDo(description);
        tasks.addTask(todoTask);
        ui.showTodo();
        storage.saveTasks(tasks);
    }
}
