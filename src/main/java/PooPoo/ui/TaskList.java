package PooPoo.ui;

import java.util.ArrayList;

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

    }
}
