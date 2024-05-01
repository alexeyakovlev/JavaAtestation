package main.ui.commands;

import main.ui.Console;

public class SaveFamily extends Command {
    public SaveFamily(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Save the family. ";
    }

    @Override
    public void execute() {
        getConsole().saveFamily();
    }
}