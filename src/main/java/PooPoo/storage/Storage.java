package PooPoo.storage;

import PooPoo.tasklist.*;
import PooPoo.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * The {@code Storage} class handles the saving and loading of tasks from a file.
 * It ensures task data persistence between program executions.
 */
public class Storage {

    // Stores the list of tasks with an initial capacity of 100.
    public static ArrayList<Task> taskList = new ArrayList<>(100);

    /**
     * Saves the current task list to the default file path.
     * If an error occurs during saving, an error message is displayed.
     *
     * @param tasks The task list to be saved.
     */
    public static void saveTasks(TaskList tasks) {
        try {
            Storage.saveTaskList(tasks, "data/PooPoo.txt");
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Saves the provided task list to the specified file path.
     * Creates directories if they do not exist.
     *
     * @param tasks    The task list to be saved.
     * @param filePath The file path where the tasks should be saved.
     * @throws IOException If an error occurs while writing to the file.
     */
    public static void saveTaskList(TaskList tasks, String filePath) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        FileWriter save = new FileWriter(file);

        // Writes each task as a string representation to the file.
        for (Task task : tasks.getTaskList()) {
            save.write(task.toString() + "\n");
        }
        save.close();
    }

    /**
     * Restores the task list from the specified file.
     * If the file does not exist, it creates a new file.
     *
     * @param filePath The file path where tasks are stored.
     * @return A {@code TaskList} object containing the restored tasks.
     */
    public static TaskList restoreTaskList(String filePath) {
        TaskList tasks = new TaskList();
        File store = new File(filePath);

        // If the file doesn't exist, create the necessary directories and an empty file.
        if (!store.exists()) {
            if (store.getParentFile() != null) {
                store.getParentFile().mkdirs();
            }
            try {
                store.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating new file: " + filePath);
                return tasks;
            }
        }

        // Regular expression to parse task entries from the file.
        Pattern pattern = Pattern.compile("^\\[(T|D|E)\\]\\[( |X)\\]\\s*(.*)$");

        try (Scanner save = new Scanner(store)) {
            // Reads each line from the file and reconstructs tasks.
            while (save.hasNext()) {
                String line = save.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (!matcher.matches()) {
                    System.err.println("Invalid line format, skipping: " + line);
                    continue;
                }
                String type = matcher.group(1);           // T (ToDo), D (Deadline), or E (Event)
                String doneSymbol = matcher.group(2);     // " " for not done, "X" for done
                boolean isDone = doneSymbol.equals("X");
                String details = matcher.group(3);        // The task details

                Task task = null;
                switch (type) {
                    case "T":
                        // Creates a ToDo task.
                        task = new ToDo(details);
                        break;
                    case "D":
                        // Extracts the description and deadline from the string.
                        int byIndex = details.lastIndexOf(" (by:");
                        if (byIndex != -1) {
                            String desc = details.substring(0, byIndex).trim();
                            String byPart = details.substring(byIndex + 5, details.length() - 1).trim();
                            task = new Deadline(desc, byPart);
                        } else {
                            task = new Deadline(details, "");
                        }
                        break;
                    case "E":
                        // Extracts the description, start time, and end time for an Event.
                        int fromIndex = details.lastIndexOf(" (from:");
                        if (fromIndex != -1) {
                            String desc = details.substring(0, fromIndex).trim();
                            String extra = details.substring(fromIndex).trim();
                            if (extra.startsWith("(") && extra.endsWith(")")) {
                                extra = extra.substring(1, extra.length() - 1);
                            }
                            int toIndex = extra.indexOf(" to:");
                            if (toIndex != -1) {
                                String from = extra.substring(6, toIndex).trim(); // after "from:"
                                String to = extra.substring(toIndex + 4).trim();
                                task = new Event(desc, from, to);
                            } else {
                                task = new Event(details, "", "");
                            }
                        } else {
                            task = new Event(details, "", "");
                        }
                        break;
                    default:
                        System.err.println("Unknown task type, skipping: " + line);
                        continue;
                }
                if (task != null && isDone) {
                    task.markAsDone();
                }

                tasks.addTask(task);
            }
        } catch (FileNotFoundException e) {
            Ui.showFileNotFoundException();
        }

        return tasks;
    }

}
