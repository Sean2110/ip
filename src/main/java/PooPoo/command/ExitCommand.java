package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.Ui;

/**
 * The {@code ExitCommand} class handles the termination of the program.
 */
public class ExitCommand extends Command {

    /**
     * Executes the exit command by displaying the farewell message.
     * This command does not modify the task list or storage.
     *
     * @param tasks   The task list (not used in this command).
     * @param ui      The UI instance used to display the farewell message.
     * @param storage The storage system (not used in this command).
     */
    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        Ui.showBye();
    }

}
