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

    int getStartX();

    int getStartY();

    int getEndX();

    int getEndY();

    void setIsSelected(Boolean bool);
    Boolean getIsSelected();

    ShapeType getShapeType();
    ShapeShadingType getShapeShadingType();
    ShapeColor getPrimaryColor();
    ShapeColor getSecondaryColor();

    void move(int deltaX, int deltaY);
//    void draw();
//    void paste();
//    void delete();
}
