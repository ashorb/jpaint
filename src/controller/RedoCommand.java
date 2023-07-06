package controller;

import model.interfaces.ICommand;
import model.persistence.CommandHistory;

public class RedoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.redo();
    }
}
