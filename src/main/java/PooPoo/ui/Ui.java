package PooPoo.ui;

import PooPoo.tasklist.TaskList;

import java.util.Scanner;

/**
 * The {@code Ui} class handles user interactions in the PooPoo application.
 * It provides methods to display messages, read user input, and handle errors.
 */
public class Ui {
    protected String description;

    // Static messages used throughout the UI.
    protected static String NAME = "PooPoo";
    protected static String ASK = "How can I help you?";
    protected static String BYE = "Bye! Hope to see you again!";

    /**
     * Displays the welcome message when the application starts.
     */
    public static void showWelcome() {
        System.out.println("Hii! Nice to meet you! I'm " + NAME);
        System.out.println(ASK);
    }

    /**
     * Displays the goodbye message when the application exits.
     */
    public static void showBye() {
        System.out.println(BYE + "\n");
    }

    /**
     * Displays an error message when an unknown command is entered.
     */
    public static void showPooPooExceptions() {
        System.out.println("I don't understand T~T");
    }

    /**
     * Displays an error message when an invalid index is entered.
     */
    public static void showIndexOutOfBoundExceptions() {
        System.out.println("Please enter a valid number");
    }

    /**
     * Displays an error message when the task data file is not found.
     */
    public static void showFileNotFoundException() {
        System.err.println("Error: File not found");
    }

    /**
     * Displays a confirmation message when a task is marked as done.
     */
    public static void showMark() {
        System.out.println("Thank you! I have marked it as done! Good job!");
    }

    /**
     * Displays a confirmation message when a deadline task is added.
     */
    public static void showDeadline() {
        System.out.println("Okiee I've added the deadline!! Make sure you do it by then!");
    }

    /**
     * Displays a confirmation message when an event task is added.
     */
    public static void showEvent() {
        System.out.println("Okiee I've added the event!! All the best!");
    }

    /**
     * Displays a confirmation message when a ToDo task is added.
     */
    public static void showTodo() {
        System.out.println("Okiee I've added the todo!!");
    }

    /**
     * Displays a confirmation message when a task is deleted.
     *
     * @param index The index of the deleted task.
     */
    public static void showDelete(int index) {
        System.out.println("Okiee I've removed this task: \n" + TaskList.getTask(index));
    }

    /**
     * Displays the number of remaining tasks in the task list.
     */
    public static void showRemainingTask() {
        System.out.println("You have " + TaskList.getSize() + " remaining tasks left! All the best!");
    }

    /**
     * Displays a specific task from the task list.
     *
     * @param index The index of the task to display.
     */
    public static void showTask(int index) {
        System.out.println(index + ". " + TaskList.getTask(index).toString());
    }

    /**
     * Reads and returns a command input from the user.
     *
     * @return The user input as a string.
     */
    public static String readCommand () {
        return new Scanner(System.in).nextLine();
    }
}
