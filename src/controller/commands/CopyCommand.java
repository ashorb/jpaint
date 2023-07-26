package controller.commands;

import controller.interfaces.ICommand;
import model.ShapeList;
import model.interfaces.IShape;

public class CopyCommand implements ICommand {

    private final ShapeList shapeList;

    public CopyCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        shapeList.getCopyList().clear();
        if (!(shapeList.getSelectedList().isEmpty())) {
            for (IShape shape : shapeList.getSelectedList()) {
                shapeList.getCopyList().add(shape);
            }
        }
//        System.out.println("copy list (copy class): " + shapeList.getCopyList());
    }
}
