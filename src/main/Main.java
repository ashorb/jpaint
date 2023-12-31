package main;

import controller.JPaintController;
import controller.ObserverSubject;
import controller.interfaces.IShapeListSubject;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.ClickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        ShapeList shapeList = new ShapeList();
        PaintCanvas.getInstance().setShapeList(shapeList);

        IShapeListSubject observer = new ObserverSubject();
        observer.registerObserver(PaintCanvas.getInstance());

        IGuiWindow guiWindow = new GuiWindow(PaintCanvas.getInstance());
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        new JPaintController(uiModule, appState, shapeList);

        PaintCanvas.getInstance().addMouseListener(new ClickHandler(appState, shapeList));
    }
}
