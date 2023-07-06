package controller;

import model.interfaces.ICommand;

public class ProcessCommand {
    public void process(ICommand command) {
        command.execute();
    }
}
