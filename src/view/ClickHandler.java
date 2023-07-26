package view;

import controller.commands.CreateShape;
import controller.commands.MoveShape;
import controller.commands.SelectShape;
import controller.interfaces.ICommand;
import model.Point;
import model.ShapeAttributes;
import model.ShapeList;
import model.ShapeType;
import model.interfaces.IApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickHandler extends MouseAdapter {

    private final IApplicationState appState;
    private final ShapeList shapeList;
    private ShapeType shapeType;
    private final Point startPoint = new Point();
    private final Point endPoint = new Point();

    ShapeAttributes shapeAttributes;

    public ClickHandler(IApplicationState appState, ShapeList shapeList) {
        this.shapeList = shapeList;
        this.appState = appState;
    }

    @Override
    public void mousePressed(MouseEvent e) { //location when mouse pressed
        startPoint.x = e.getX();
        startPoint.y = e.getY();

//        System.out.println("Pressed:  x = " + startPoint.x +  " y = " +  startPoint.y);
    }

    @Override
    public void mouseReleased(MouseEvent e) { //location when mouse released
        ICommand command;
        shapeType = appState.getActiveShapeType();
        shapeAttributes = new ShapeAttributes(appState);

        endPoint.x = e.getX();
        endPoint.y = e.getY();
        int width;
        int height;

        width = Math.abs(endPoint.getX() - startPoint.getX());
        height = Math.abs(endPoint.getY() - startPoint.getY());

        switch (appState.getActiveMouseMode()){
            case SELECT:
                command = new SelectShape(appState, shapeList, shapeAttributes, startPoint, endPoint);
                command.execute();
//                System.out.println("selected SELECT: " + shapeList.getSelectedList());
                break;
            case MOVE:
                if ((startPoint.getX() != endPoint.getX() || startPoint.getY() != endPoint.getY())
                        && !(shapeList.getSelectedList().isEmpty())) {
                    command = new MoveShape(shapeList.getSelectedList(), startPoint, endPoint);
                    command.execute();
//                    System.out.println("selected MOVE: " + shapeList.getSelectedList());
                }
                break;
            case DRAW:
                if(width != 0 && height != 0) {
                    command = new CreateShape(appState, shapeList, shapeAttributes, startPoint, endPoint);
                    command.execute();
                }
                break;
        }
//        System.out.println("Released: x = " + endPoint.x + " y = " +  endPoint.y);
    }
}
