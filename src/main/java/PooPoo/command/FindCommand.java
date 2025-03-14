package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.Ui;

public class FindCommand extends Command{
    public final String description;

    public FindCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        ui.showFind();
        tasks.findTask(description);
        storage.saveTasks(tasks);
    }
}
