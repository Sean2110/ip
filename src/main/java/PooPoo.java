import java.util.ArrayList;
import java.util.Scanner;

public class PooPoo {
    public static ArrayList<Task> taskList = new ArrayList<>(100);
    public static void main(String[] args) {
        String Name = "PooPoo";
        String Ask = "How can I help you?";
        String Bye = "Bye! Hope to see you soon!";


        Scanner sc = new Scanner(System.in);

        System.out.println("Hii! Nice to meet you! I'm " + Name);
        System.out.println(Ask);

        while (true) {
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("bye")) {
                // goodbye
                break;
            } else if (command.equalsIgnoreCase("list")) {
                // list all tasks
                for (int i = 1; i <= taskList.size(); i++) {
                    System.out.println(i + ". " + taskList.get(i - 1).toString());
                }
            } else if (command.startsWith("mark")) {
                // mark as done
                String[] tokens = command.split(" ");
                int index = Integer.parseInt(tokens[1]);
                taskList.get(index - 1).markAsDone();
                // sucessfully marked as done.
                System.out.println("Thank you! I have marked it as done! Good job!");
            } else {
                // add new task
                taskList.add(new Task(command));
                System.out.print("added ");
                System.out.println(command);
            }
        }

        System.out.println(Bye + "\n");
    }
}
