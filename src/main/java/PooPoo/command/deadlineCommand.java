package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.Deadline;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

public class deadlineCommand extends Command {
    private final String description;
    private final String by;

    public deadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException {
        Deadline deadlineTask = new Deadline(description, by);
        tasks.addTask(deadlineTask);
        ui.showDeadline();
        storage.saveTasks(tasks); // persist tasks
    }

}
