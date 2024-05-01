package main.ui.commands;

import main.ui.Console;

public class Load extends Command {
    public Load(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Upload a family. ";
    }

    @Override
    public void execute() {
        getConsole().loadFamily();
    }
}