package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.Ui;

public class exitCommand extends Command {

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        Ui.showBye();
    }

}
