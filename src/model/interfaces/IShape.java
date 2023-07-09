package model.interfaces;

import model.ShapeType;

public interface IShape {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    int[] getXPoints();
    int[] getYPoints();
    ShapeType getShapeType();

    void draw();
    void move();
    void paste();
    void delete();
}
