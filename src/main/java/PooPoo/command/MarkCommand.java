package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.Ui;

/**
 * The {@code MarkCommand} class handles marking a task as completed.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Constructs a {@code MarkCommand} with the specified task index.
     *
     * @param index The index of the task to be marked as completed (1-based index).
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the mark command by marking the specified task as done.
     * Displays the updated task status using the UI and saves the updated task list to storage.
     *
     * @param tasks   The task list containing the task to be marked as completed.
     * @param ui      The UI instance used to display the marked task.
     * @param storage The storage system where the updated task list is saved.
     */
    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        tasks.markTask(index);
        ui.showMark();
        storage.saveTasks(tasks);
    }
}
