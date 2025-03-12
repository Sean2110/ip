package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.Ui;

public class markCommand extends Command {
    private final int index;

    public markCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        tasks.markTask(index);
        ui.showMark();
        storage.saveTasks(tasks);
    }
}
