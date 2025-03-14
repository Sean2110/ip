package PooPoo.ui;

import PooPoo.tasklist.TaskList;

import java.util.Scanner;

// index should be 1-based => user is using 1-based
public class Ui {
    protected String description;
    protected static String NAME = "PooPoo";
    protected static String ASK = "How can I help you?";
    protected static String BYE = "Bye! Hope to see you again!";

    public static void showWelcome() {
        System.out.println("Hii! Nice to meet you! I'm " + NAME);
        System.out.println(ASK);
    }

    public static void showBye() {
        System.out.println(BYE + "\n");
    }

    public static void showPooPooExceptions() {
        System.out.println("I don't understand T~T");
    }

    public static void showIndexOutOfBoundExceptions() {
        System.out.println("Please enter a valid number");
    }

    public static void showFileNotFoundException() {
        System.err.println("Error: File not found");
    }

    public static void showMark() {
        System.out.println("Thank you! I have marked it as done! Good job!");
    }

    public static void showDeadline() {
        System.out.println("Okiee I've added the deadline!! Make sure you do it by then!");
    }

    public static void showEvent() {
        System.out.println("Okiee I've added the event!! All the best!");
    }

    public static void showTodo() {
        System.out.println("Okiee I've added the todo!!");
    }

    public static void showDelete(int index) {
        System.out.println("Okiee I've removed this task: \n" + TaskList.getTask(index));
    }

    public static void showRemainingTask() {
        System.out.println("You have " + TaskList.getSize() + " remaining tasks left! All the best!");
    }

    public static void showTask(int index) {
        System.out.println(index + ". " + TaskList.getTask(index).toString());
    }

    public static void showFind() {
        System.out.println("These are the matching tasks in the list!: \n");
    }

    public static String readCommand () {
        return new Scanner(System.in).nextLine();
    }
}
