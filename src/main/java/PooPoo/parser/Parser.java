package PooPoo.parser;

import PooPoo.command.*;
import PooPoo.ui.PooPooException;

/**
 * The {@code Parser} class is responsible for interpreting user input
 * and returning the corresponding {@code Command} object.
 */
public class Parser {

    /**
     * Parses the user input and returns the appropriate {@code Command} object based on the input command word.
     *
     * @param input The raw input string entered by the user.
     * @return A {@code Command} object corresponding to the input command.
     * @throws PooPooException If the input is invalid or cannot be processed.
     */
    public static Command parse(String input) throws PooPooException {
        String[] tokens = input.split(" ", 2);
        String commandWord = tokens[0].toLowerCase();

        switch (commandWord) {
            case "list":
                // Returns a command that lists all tasks.
                return new ListCommand();
            case "mark":
                // Parses the index and returns a command to mark the task as done.
                int index = Integer.parseInt(tokens[1]);
                return new MarkCommand(index);
            case "todo":
                // Ensures that a description is provided for the todo task.
                if (tokens.length < 2 || tokens[1].isEmpty()) {
                    throw new PooPooException();
                }
                return new TodoCommand(tokens[1]);
            case "deadline":
                // Splits the input into task description and deadline.
                String[] deadlineParts = tokens[1].split(" /by ", 2);
                return new DeadlineCommand(deadlineParts[0], deadlineParts[1]);
            case "event":
                // Splits the input into event description, start time, and end time.
                String[] eventParts = tokens[1].split(" /from | /to ", 3);
                return new EventCommand(eventParts[0], eventParts[1], eventParts[2]);
            case "delete":
                // Parses the index and returns a command to delete the task.
                return new DeleteCommand(Integer.parseInt(tokens[1]));
            case "bye":
                // Returns a command that signals program termination.
                return new ExitCommand();
            default:
                // Throws an exception if the input command is unrecognized.
                throw new PooPooException();
        }
    }
}
