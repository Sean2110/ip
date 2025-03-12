package PooPoo;

import PooPoo.command.Command;
import PooPoo.storage.Storage;
import PooPoo.parser.Parser;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.*;

public class PooPoo {
    public static TaskList taskList = new TaskList();
    private static Storage storage;
    private static TaskList tasks;
    private static Ui ui;

    public static void main(String[] args) {
        storage = new Storage();
        tasks = Storage.restoreTaskList("data/PooPoo.txt");
        ui = new Ui();

        Ui.showWelcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = Ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (PooPooException e) {
                Ui.showPooPooExceptions();
            } catch (IndexOutOfBoundsException e) {
                Ui.showIndexOutOfBoundExceptions();
            }
        }
    }
}
