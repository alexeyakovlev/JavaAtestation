package main.ui.commands;

import main.ui.Console;

public class SortName extends Command {
    public SortName(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Sort the family by name. ";
    }

    @Override
    public void execute() {
        getConsole().sortFamilyName();
    }
}