package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import model.ShapeList;
import model.interfaces.IShape;
import controller.interfaces.IShapeListObserver;

public class PaintCanvas extends JComponent implements IShapeListObserver {
    private static PaintCanvas paintCanvasInstance;
    private ShapeList shapeList;

    private PaintCanvas() {
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;

        for (IShape s : shapeList.getMasterList()) {
            s.draw(graphics2d);

            if (s.getIsSelected() == true){
                s.select(graphics2d);
            }
        }
    }

    @Override
    public void update() {
        this.repaint();
    }

    public void setShapeList(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    public static PaintCanvas getInstance() {
        if (paintCanvasInstance == null) {
            paintCanvasInstance = new PaintCanvas();
        }
        return paintCanvasInstance;
    }
}
