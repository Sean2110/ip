package PooPoo.tasklist;

import PooPoo.ui.Ui;

import java.util.ArrayList;

// 0-based ArrayList
public class TaskList {
    public static ArrayList<Task> taskList = new ArrayList<>(100);

    public static void addTask(Task task) {
        taskList.add(task);
    }

    public static void deleteTask(int taskIndex) {
        taskList.remove(taskIndex - 1);
    }

    public static Task getTask(int index) {
        return taskList.get(index - 1);
    }

    public static int getSize() {
        return taskList.size();
    }

    public static void listTask() {
        for (int i = 0; i < TaskList.getSize(); i++) {
            Ui.showTask(i + 1);
        }
    }

    public static void findTask(String description) {
        for (int i = 0; i < TaskList.getSize(); i++) {
            if (taskList.get(i).toString().contains(description)) {
                Ui.showTask(i + 1);
            }
        }
    }

    public static void markTask(int taskIndex) {
        taskList.get(taskIndex - 1).markAsDone();
    }

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }
}
