package PooPoo.tasklist;

import PooPoo.ui.Ui;

import java.util.ArrayList;

/**
 * Represents a list of tasks. Provides methods to add, delete, retrieve, and manipulate tasks.
 */
public class TaskList {

    // Stores the list of tasks with an initial capacity of 100.
    public static ArrayList<Task> taskList = new ArrayList<>(100);

    /**
     * Adds a task to the task list
     *
     * @param task The task to be added
     */
    public static void addTask(Task task) {
        taskList.add(task);
    }

    /**
     * Deletes a task from the task list based on the given index
     *
     * @param taskIndex The index of the task to be removed (1-based index).
     */
    public static void deleteTask(int taskIndex) {
        taskList.remove(taskIndex - 1);
    }

    /**
     * Retrieves a task from the task list.
     *
     * @param index The index of the task to retrieve (1-based index).
     * @return The task at the specified index.
     */
    public static Task getTask(int index) {
        return taskList.get(index - 1);
    }

    /**
     * Returns the total number of tasks in the task list.
     *
     * @return The size of the task list.
     */
    public static int getSize() {
        return taskList.size();
    }

    /**
     * Displays all tasks in the task list.
     * Uses the Ui class to display each task.
     */
    public static void listTask() {
        for (int i = 0; i < TaskList.getSize(); i++) {
            Ui.showTask(i + 1);
        }
    }

    /**
     * Marks a task as done based on the given index.
     *
     * @param taskIndex The index of the task to mark as done (1-based index).
     */
    public static void markTask(int taskIndex) {
        taskList.get(taskIndex - 1).markAsDone();
    }

    /**
     * Returns the full list of tasks.
     *
     * @return The list of tasks.
     */
    public static ArrayList<Task> getTaskList() {
        return taskList;
    }
}
