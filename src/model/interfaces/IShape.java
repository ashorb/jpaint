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

    public int getStartX();

    public int getStartY();

    public int getEndX();

    public int getEndY();

    void setIsSelected(Boolean bool);
    Boolean getIsSelected();

    ShapeType getShapeType();
    ShapeShadingType getShapeShadingType();
    ShapeColor getPrimaryColor();
    ShapeColor getSecondaryColor();

    void draw();
    void move(int deltaX, int deltaY);
    void paste();
    void delete();


}
