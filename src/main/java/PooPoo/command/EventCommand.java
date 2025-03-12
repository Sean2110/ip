package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.Event;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException {
        Event eventTask = new Event(description, from, to);
        tasks.addTask(eventTask);
        ui.showEvent();
        storage.saveTasks(tasks); // persist tasks
    }

}
