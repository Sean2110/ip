package PooPoo.storage;

import PooPoo.ui.*;
import PooPoo.ui.TaskList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
        initializeFile();
    }

    private void initializeFile() {
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        // Create the directory if it doesn't exist
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        // Create the file if it doesn't exist
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }

    public void loadData(TaskList taskList) {
        File file = new File(filePath);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                // Parse the line into a Task
                Task task = parseLine(line);
                // If we successfully parsed a task, add it to the TaskList
                // WITHOUT saving to file again
                if (task != null) {
                    taskList.addTask(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load data: " + e.getMessage());
        }
    }


    public void saveData(TaskList taskList) {
        File file = new File(filePath);
        try (FileWriter fw = new FileWriter(file)) {
            for (Task task : taskList.getAllTasks()) {
                String line = formatTaskForSaving(task);
                fw.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Could not save data: " + e.getMessage());
        }
    }

    private Task parseLine(String line) {
        // Split by '|'
        String[] parts = line.split("\\|");
        // Trim whitespace from each part
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        // Basic validation
        if (parts.length < 3) {
            System.out.println("Invalid line format: " + line);
            return null;
        }

        String taskType = parts[0]; // T, D, E
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        switch (taskType) {
            case "T": // ToDo
                return createToDo(description, isDone);

            case "D": // Deadline
                if (parts.length < 4) {
                    System.out.println("Invalid deadline format: " + line);
                    return null;
                }
                String by = parts[3];
                return createDeadline(description, by, isDone);

            case "E": // Event
                if (parts.length < 5) {
                    System.out.println("Invalid event format: " + line);
                    return null;
                }
                String from = parts[3];
                String to = parts[4];
                return createEvent(description, from, to, isDone);

            default:
                System.out.println("Unknown task type: " + taskType);
                return null;
        }
    }

    // formatting the storage
    private String formatTaskForSaving(Task task) {
        if (task instanceof ToDo) {
            //todo
            ToDo todo = (ToDo) task;
            return "T | " + todo.isDone() + " | " + todo.getDescription();
        } else if (task instanceof Deadline) {
            //deadline
            Deadline deadline = (Deadline) task;
            return "D | " + deadline.isDone() + " | " + deadline.getDescription() + " | " + deadline.getBy();
        } else {
            //event
            Event event = (Event) task;
            return "E | " + event.isDone() + " | " + event.getDescription() + " | " + event.getFrom() + " | " + event.getTo();
        }
    }

    private ToDo createToDo(String description, boolean isDone) {
        ToDo td = new ToDo(description);
        if (isDone) {
            td.markAsDone();
        }
        return td;
    }

    private Deadline createDeadline(String description, String by, boolean isDone) {
        Deadline deadline = new Deadline(description, by);
        if (isDone) {
            deadline.markAsDone();
        }
        return deadline;
    }

    private Event createEvent(String description, String from, String to, boolean isDone) {
        Event event = new Event(description, from, to);
        if (isDone) {
            event.markAsDone();
        }
        return event;
    }
}
