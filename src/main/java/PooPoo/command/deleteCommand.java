package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.Event;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

public class deleteCommand extends Command {
    private final int index;

    public deleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException {
        ui.showDelete(index);
        tasks.deleteTask(index);
        ui.showRemainingTask();
        storage.saveTasks(tasks);
    }
}
