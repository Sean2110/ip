package PooPoo.command;

import PooPoo.storage.Storage;
import PooPoo.tasklist.*;
import PooPoo.ui.PooPooException;
import PooPoo.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;


public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws PooPooException;

    public boolean isExit() {
        return false;
    }
}
