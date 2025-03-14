package PooPoo;

import PooPoo.command.Command;
import PooPoo.storage.Storage;
import PooPoo.parser.Parser;
import PooPoo.tasklist.TaskList;
import PooPoo.ui.*;

/**
 * The {@code PooPoo} class serves as the main entry point for the application.
 * It initializes the necessary components and manages user interactions
 * through a command-line interface.
 */
public class PooPoo {

    // Storage, task list, and UI instances for managing tasks and user interaction.
    private static Storage storage;
    private static TaskList tasks;
    private static Ui ui;

    /**
     * The main method that starts the PooPoo task manager.
     * It initializes the storage, task list, and user interface,
     * then enters a loop to process user commands until the exit command is given.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        storage = new Storage();
        tasks = Storage.restoreTaskList("data/PooPoo.txt");
        ui = new Ui();

        Ui.showWelcome();   // Display welcome message

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = Ui.readCommand();  // Read user input
                Command c = Parser.parse(fullCommand);  // Parse input into a command
                c.execute(tasks, ui, storage);  // Execute the command
                isExit = c.isExit();    // Check if the command signals program exit
            } catch (PooPooException e) {
                Ui.showPooPooExceptions();  // Handle custom application errors
            } catch (IndexOutOfBoundsException e) {
                Ui.showIndexOutOfBoundExceptions(); // Handle index errors
            }
        }
    }
}
