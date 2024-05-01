package main.ui.commands;

import main.ui.Console;

public class Exit extends Command {
    public Exit(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "The output of their program.";
    }

    @Override
    public void execute() {
        getConsole().end();
    }
}