package controller;

import model.interfaces.ICommand;
import model.persistence.CommandHistory;

public class UndoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.undo();
    }
}