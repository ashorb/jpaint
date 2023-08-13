package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

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

    default ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }
    default ShapeShadingType getShapeShadingType() {
        return ShapeShadingType.FILLED_IN;
    }
    default ShapeColor getPrimaryColor() {
        return ShapeColor.BLUE;
    }
    default ShapeColor getSecondaryColor() {
        return ShapeColor.GREEN;
    }

    void move(int deltaX, int deltaY);
    void draw(Graphics2D graphics2D);
    void select(Graphics2D graphics2D);
    String getIShapeType();
    default List<IShape> getChildren() {
        return new ArrayList<>();
    }
}
