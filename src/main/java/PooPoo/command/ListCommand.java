package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException {
        TaskList.listTask();
    }
}
