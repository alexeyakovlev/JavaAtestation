package main.ui.commands;

import main.ui.Console;
public class AddHuman extends Command {
    public AddHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Adding a person to the family. ";
    }

    @Override
    public void execute() {
        getConsole().addHumanNew();
    }
}