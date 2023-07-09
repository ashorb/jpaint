package main;


import controller.JPaintController;
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
        PaintCanvas paintCanvas = new PaintCanvas(shapeList);
        shapeList.setPaintCanvas(paintCanvas);

        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        new JPaintController(uiModule, appState);
        paintCanvas.addMouseListener(new ClickHandler(appState, shapeList));
    }
}
