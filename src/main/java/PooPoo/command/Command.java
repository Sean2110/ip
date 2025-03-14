package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.*;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code Command} class represents an abstract command that can be executed.
 * Subclasses should implement the {@code execute} method to define specific command behavior.
 */
public abstract class Command {

    /**
     * Executes the command using the provided task list, UI, and storage.
     * Each subclass should provide its own implementation.
     *
     * @param tasks   The task list that the command interacts with.
     * @param ui      The UI instance for user interactions.
     * @param storage The storage system for saving or retrieving tasks.
     * @throws PooPooException If an error occurs during execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException;

    /**
     * Indicates whether this command should terminate the program.
     * By default, commands do not cause the program to exit.
     *
     * @return {@code false} unless overridden by an exit command.
     */
    public boolean isExit() {
        return false;
    }
}
