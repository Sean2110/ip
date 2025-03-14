package PooPoo.parser;

import PooPoo.command.*;
import PooPoo.ui.PooPooException;

public class Parser {

    public static Command parse(String input) throws PooPooException {
        String[] tokens = input.split(" ", 2);
        String commandWord = tokens[0].toLowerCase();

        switch (commandWord) {
            case "list":
                return new ListCommand();
            case "mark":
                int index = Integer.parseInt(tokens[1]);
                return new MarkCommand(index);
            case "todo":
                if (tokens.length < 2 || tokens[1].isEmpty()) {
                    throw new PooPooException();
                }
                return new TodoCommand(tokens[1]);
            case "deadline":
                String[] deadlineParts = tokens[1].split(" /by ", 2);
                return new DeadlineCommand(deadlineParts[0], deadlineParts[1]);
            case "event":
                String[] eventParts = tokens[1].split(" /from | /to ", 3);
                return new EventCommand(eventParts[0], eventParts[1], eventParts[2]);
            case "delete":
                return new DeleteCommand(Integer.parseInt(tokens[1]));
            case "find":
                return new FindCommand(tokens[1]);
            case "bye":
                return new ExitCommand();
            default:
                throw new PooPooException();
        }
    }
}
