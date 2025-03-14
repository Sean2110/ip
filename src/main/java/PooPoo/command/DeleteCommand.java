package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

/**
 * The {@code DeleteCommand} class handles the removal of a task from the task list.
 */
public class DeleteCommand extends Command {
    private final int index;

    /**
     * Constructs a {@code DeleteCommand} with the specified task index.
     *
     * @param index The index of the task to be deleted (1-based index).
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the delete command by removing a task from the task list.
     * Displays the deleted task using the UI, updates the remaining task count,
     * and saves the updated task list to storage.
     *
     * @param tasks   The task list from which the task will be removed.
     * @param ui      The UI instance used to display the task deletion.
     * @param storage The storage system where the updated task list is saved.
     * @throws PooPooException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException {
        ui.showDelete(index);
        tasks.deleteTask(index);
        ui.showRemainingTask();
        storage.saveTasks(tasks);
    }
}
