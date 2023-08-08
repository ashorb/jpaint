package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.drawing.ShapePainter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface IShape {
    int getX();
    int getY();

    int getLargestX();
    int getLargestY();

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
//    void draw(IPaintStrategy paintStrategy, Graphics2D graphics2D);
    void draw(Graphics2D graphics2D);

    default void setGroupCoordinates(){

    }

    void select(Graphics2D graphics2D);
//    void move();

//    public int getMinCoordinate();
//
//    public int getMaxCoordinate();

    String getIShapeType();


    default List<IShape> getChildren() {
        return new ArrayList<>();
    }
}
