package PooPoo;

import PooPoo.ui.*;

import java.io.File;
import java.util.Scanner;

public class PooPoo {
    public static TaskList taskList = new TaskList();

    public static void handleTask(String command) throws PooPooException {
        if (command.equalsIgnoreCase("list")) {
            // list all tasks
            taskList.listTask();
        } else if (command.startsWith("mark")) {
            // mark as done
            String[] tokens = command.split(" ");
            int index = Integer.parseInt(tokens[1]);
            if (index == 0) {
                throw new IndexOutOfBoundsException();
            }
            taskList.markTask(index);
            // successfully marked as done.
            System.out.println("Thank you! I have marked it as done! Good job!");
        } else if (command.startsWith("deadline")) {
            // deadline
            int deadlinePosition = command.indexOf(" ");
            int byPosition = command.indexOf("/by");
            String deadline = command.substring(deadlinePosition, byPosition).trim();
            String by = command.substring(byPosition + 3).trim();
            taskList.addTask(new Deadline(deadline, by));
            System.out.println("Okiee I've added the deadline!! Make sure you do it by then!");
        } else if (command.startsWith("todo")) {
            // todos
            int toDoPosition = command.indexOf("todo");
            String toDo = command.substring(toDoPosition + 5);
            taskList.addTask(new ToDo(toDo));
            System.out.println("Okiee I've added the todo!!");
        } else if (command.startsWith("event")) {
            // event
            int eventPosition = command.indexOf(" ");
            int fromPosition = command.indexOf("/from");
            int toPosition = command.indexOf("/to");
            String event = command.substring(eventPosition, fromPosition).trim();
            String from = command.substring(fromPosition + 5, toPosition).trim();
            String to = command.substring(toPosition + 3).trim();
            taskList.addTask(new Event(event, from, to));
            System.out.println("Okiee I've added the event!! All the best!");
        } else if (command.startsWith("delete")) {
            //delete
            String[] tokens = command.split(" ");
            int deleteIndex = Integer.parseInt(tokens[1]) - 1;
            taskList.removeTask(deleteIndex);
        } else {
            // exceptions
            throw new PooPooException();
        }
    }

    public static void main(String[] args) {
        File save = new File("./data/PooPoo.txt");

        String NAME = "PooPoo";
        String ASK = "How can I help you?";
        String BYE = "Bye! Hope to see you again!";

        Scanner sc = new Scanner(System.in);

        System.out.println("Hii! Nice to meet you! I'm " + NAME);
        System.out.println(ASK);

        while (true) {
            String commands = sc.nextLine();
            if (commands.equalsIgnoreCase("bye")) {
                System.out.println(BYE + "\n");
                break;
            }
            try {
                handleTask(commands);
            } catch (PooPooException e) {
                System.out.println("I don't understand T~T");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please add a number after mark!");
            }
        }
    }
}
