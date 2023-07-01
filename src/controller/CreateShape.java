package controller;
import view.gui.PaintCanvas;

import java.awt.*;

public class CreateShape {
    public static void createShape(PaintCanvas paintCanvas, int x, int y, int width, int height){
        Graphics2D graphics2D = (Graphics2D) paintCanvas.getGraphics();
        graphics2D.setColor(Color.GREEN);
        graphics2D.fillRect(x, y, width, height);
    }
}
