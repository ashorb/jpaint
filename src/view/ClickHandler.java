package view;

import controller.commands.CreateShape;
import controller.commands.MoveShape;
import controller.commands.SelectShape;
import controller.interfaces.ICommand;
import model.Point;
import model.ShapeList;
import model.persistence.ApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickHandler extends MouseAdapter {

    private final ApplicationState appState;
    private final ShapeList shapeList;
    private final Point startPoint = new Point();
    private final Point endPoint = new Point();

    public ClickHandler(ApplicationState appState, ShapeList shapeList) {
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
        ICommand command = null;

        endPoint.x = e.getX();
        endPoint.y = e.getY();
        int width;
        int height;

        width = Math.abs(endPoint.getX() - startPoint.getX());
        height = Math.abs(endPoint.getY() - startPoint.getY());

        switch (appState.getActiveMouseMode()){
            case SELECT:
                command = new SelectShape(appState, shapeList, startPoint, endPoint);
                break;
            case MOVE:
                if ((startPoint.getX() != endPoint.getX() || startPoint.getY() != endPoint.getY())
                        && !(shapeList.getSelectedList().isEmpty())) {
                    command = new MoveShape(shapeList.getSelectedList(), startPoint, endPoint);
                }
                break;
            case DRAW:
                if(width != 0 && height != 0) {
                    command = new CreateShape(appState, shapeList, startPoint, endPoint);
                }
                break;
        }
        command.execute();

//        System.out.println("Released: x = " + endPoint.x + " y = " +  endPoint.y);
    }
}
