import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PooPoo {
    public static ArrayList<String> taskList = new ArrayList<>(100);
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
                break;
            } else if (command.equalsIgnoreCase("list")) {
                for (int i = 1; i <= taskList.size(); i++) {
                    System.out.println(i + ". " + taskList.get(i - 1));
                    }
            } else {
                    taskList.add(command);
                    System.out.print("added ");
                    System.out.println(command);
            }
        }

        System.out.println(Bye + "\n");
    }
}
