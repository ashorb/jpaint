package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    int[] getXPoints();
    int[] getYPoints();
    ShapeType getShapeType();
    ShapeShadingType getShapeShadingType();
    ShapeColor getPrimaryColor();
    ShapeColor getSecondaryColor();

    void draw();
    void move(int deltaX, int deltaY);
    void paste();
    void delete();


}
