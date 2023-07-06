package model;

import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.EmptyStackException;

final public class ShapeList {
    private final ArrayList<Shape> list;
    private PaintCanvas paintCanvas;

    public ShapeList() {
        list = new ArrayList<>();
    }

    public void add(Shape s) {
        if (s == null) throw new IllegalArgumentException();
        list.add(s);
        paintCanvas.repaint();
    }

    public void remove() {
        if (list.isEmpty()) throw new EmptyStackException();
        list.remove(list.size()-1);
        paintCanvas.repaint();
    }

    public ArrayList<Shape> getList() {
        return list;
    }

    public void setPaintCanvas(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }
}
