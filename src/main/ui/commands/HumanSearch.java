package main.ui.commands;

import main.ui.Console;

public class HumanSearch extends Command {
    public HumanSearch(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Search for a person by name. ";
    }

    @Override
    public void execute() {
        getConsole().humanSearch();
    }
}