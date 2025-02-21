package PooPoo.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TaskList {
    public ArrayList<Task> taskList = new ArrayList<>(100);

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(int index) {
        System.out.println("Okiee I've removed this task: \n" + taskList.get(index));
        taskList.remove(index);
        System.out.println("You have " + taskList.size() + " remaining tasks left! All the best!");
    }

    public void listTask() {
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + ". " + taskList.get(i - 1).toString());
        }
    }

    public void markTask(int taskIndex) {
        taskList.get(taskIndex - 1).markAsDone();
    }

    public void saveTaskList(String filePath) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        FileWriter save = new FileWriter(file);
        // for loop to fw.write(task in string representation)
        for (Task task : taskList) {
            save.write(task.toString() + "\n");
        }
        save.close();
    }

    public void restoreTaskList(String filePath) {
        File store = new File(filePath);
        // create a File for the given file path
        // If the file doesn't exist, create the necessary directories and an empty file.
        if (!store.exists()) {
            if (store.getParentFile() != null) {
                store.getParentFile().mkdirs();
            }
            try {
                store.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating new file: " + filePath);
                return;
            }
        }

        Pattern pattern = Pattern.compile("^\\[(T|D|E)\\]\\[( |X)\\]\\s*(.*)$");

        try (Scanner save = new Scanner(store)) {
            // create a Scanner using the File as the source (catch error)
            while (save.hasNext()) {
                String line = save.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (!matcher.matches()) {
                    System.err.println("Invalid line format, skipping: " + line);
                    continue;
                }
                String type = matcher.group(1);         // T, D, or E
                String doneSymbol = matcher.group(2);     // " " for not done, "X" for done
                boolean isDone = doneSymbol.equals("X");
                String details = matcher.group(3);        // the remainder of the line

                Task task = null;
                switch (type) {
                    case "T":
                        // For a todo task, the details are the description.
                        task = new ToDo(details);
                        break;
                    case "D":
                        // For deadlines, assume details end with " (by: ...)"
                        int byIndex = details.lastIndexOf(" (by:");
                        if (byIndex != -1) {
                            String desc = details.substring(0, byIndex).trim();
                            // Extract the by-part by removing the surrounding parentheses.
                            String byPart = details.substring(byIndex + 5, details.length() - 1).trim();
                            task = new Deadline(desc, byPart);
                        } else {
                            // Fallback if no deadline info is found.
                            task = new Deadline(details, "");
                        }
                        break;
                    case "E":
                        // For events, assume details end with " (from: ... to: ...)"
                        int fromIndex = details.lastIndexOf(" (from:");
                        if (fromIndex != -1) {
                            String desc = details.substring(0, fromIndex).trim();
                            String extra = details.substring(fromIndex).trim();
                            // Remove the surrounding parentheses if present.
                            if (extra.startsWith("(") && extra.endsWith(")")) {
                                extra = extra.substring(1, extra.length() - 1);
                            }
                            // Expect extra to be in the format "from: ... to: ..."
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
                addTask(task);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + filePath);
        }
    }
}
