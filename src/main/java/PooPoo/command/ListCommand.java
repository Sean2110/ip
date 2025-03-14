package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

/**
 * The {@code ListCommand} class handles displaying all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by displaying all tasks in the task list.
     *
     * @param tasks   The task list containing tasks to be displayed.
     * @param ui      The UI instance used to display the list of tasks.
     * @param storage The storage system (not used in this command).
     * @throws PooPooException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException {
        TaskList.listTask();
    }
}
