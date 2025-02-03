import java.util.Scanner;

public class PooPoo {
    public static void main(String[] args) {
        String Name = "PooPoo";
        String Ask = "How can I help you?";
        String Bye = "Bye! Hope to see you soon!";
        Scanner sc = new Scanner(System.in);

        System.out.println("Hii! Nice to meet you! I'm " + Name);
        System.out.println(Ask);

        //echo level 1
        while (true) {
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("bye")) {
                break;
            } else {
                System.out.println(command);
            }
        }

        System.out.println(Bye + "\n");
    }
}
