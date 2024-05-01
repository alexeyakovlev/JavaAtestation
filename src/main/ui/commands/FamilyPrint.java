package main.ui.commands;

import main.ui.Console;

public class FamilyPrint extends Command {

    public FamilyPrint(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "The seal of the family tree.";
    }

    @Override
    public void execute() {
        getConsole().familyPrint();
    }
}