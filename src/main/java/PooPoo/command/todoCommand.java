package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.Deadline;
import PooPoo.tasklist.TaskList;
import PooPoo.tasklist.ToDo;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;


public class todoCommand extends Command {
    private final String description;

    public todoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        ToDo todoTask = new ToDo(description);
        tasks.addTask(todoTask);
        ui.showTodo();
        storage.saveTasks(tasks); // persist task
    }
}
