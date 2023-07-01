package model;

import view.gui.PaintCanvas;

import java.util.ArrayList;

final public class ShapeList {
    private final ArrayList<Shape> list;

    public ShapeList() {
        list = new ArrayList<Shape>();
    }

    public void add(Shape s) {
        if (s == null) throw new IllegalArgumentException();
        list.add(s);
    }

    public ArrayList<Shape> getList() {
        return list;
    }
}
