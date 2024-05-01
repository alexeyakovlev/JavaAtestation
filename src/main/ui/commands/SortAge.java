package main.ui.commands;

import main.ui.Console;

public class SortAge extends Command {
    public SortAge(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Sort the family by age. ";
    }

    @Override
    public void execute() {
        getConsole().sortFamilyAge();

    }
}