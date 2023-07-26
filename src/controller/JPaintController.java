package controller;

import controller.commands.CopyCommand;
import controller.commands.PasteShape;
import controller.commands.RedoCommand;
import controller.commands.UndoCommand;
import controller.interfaces.IJPaintController;
import model.Shape;
import model.ShapeList;
import model.interfaces.IApplicationState;
import controller.interfaces.ICommand;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private ICommand command;
    private final ShapeList shapeList;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, applicationState::setActiveShape);
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, applicationState::setActivePrimaryColor);
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, applicationState::setActiveSecondaryColor);
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, applicationState::setActiveShadingType);
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, applicationState::setActiveStartAndEndPointMode);
        uiModule.addEvent(EventName.UNDO, this::undo);
        uiModule.addEvent(EventName.REDO, this::redo);
        uiModule.addEvent(EventName.COPY, this::copy);
        uiModule.addEvent(EventName.PASTE, this::paste);
        uiModule.addEvent(EventName.DELETE, this::delete);
        uiModule.addEvent(EventName.GROUP, this::group);
        uiModule.addEvent(EventName.UNGROUP, this::ungroup);
    }

    private void undo() {
        command = new UndoCommand();
        command.execute();
    }

    private void redo() {
        command = new RedoCommand();
        command.execute();
    }

    private void copy() {
        command = new CopyCommand(shapeList);
        command.execute();
    }

    private void paste() {
        command = new PasteShape(applicationState, shapeList);
        command.execute();
    }

    private void delete() {
    }

    private void group() {
    }

    private void ungroup() {
    }
}
