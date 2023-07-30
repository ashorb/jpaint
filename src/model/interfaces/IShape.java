package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {
    int getX();
    int getY();

    int getStartX();
    int getStartY();
    int getEndX();
    int getEndY();

    int getWidth();
    int getHeight();

    default int[] getXPoints() {
        return new int[]{0,0,0};
    }
    default int[] getYPoints() {
        return new int[]{0,0,0};
    }

    void setIsSelected(Boolean bool);
    Boolean getIsSelected();
    ShapeType getShapeType();
    ShapeShadingType getShapeShadingType();
    ShapeColor getPrimaryColor();
    ShapeColor getSecondaryColor();

    void move(int deltaX, int deltaY);
}
