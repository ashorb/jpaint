package model;
import model.drawing.PaintRectangle;
import model.drawing.ShapePainter;
import model.interfaces.IApplicationState;
import model.interfaces.IPaintStrategy;
import model.interfaces.IShape;

import java.awt.*;

public abstract class Shape implements IShape{
    int x;
    int y;

    int largestX;
    int largestY;

    int startX;
    int startY;
    int endX;
    int endY;
    int width;
    int height;

//    int[] xPoints;
//    int[] yPoints;

    ShapeType shapeType;
    ShapeShadingType shapeShadingType;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    Boolean isSelected = false;

    public Shape(IApplicationState appState, ShapeAttributes shapeAttributes, int startX, int startY, int endX, int endY){
        x = Math.min(startX, endX);
        y = Math.min(startY, endY);

        largestX = Math.max(startX, endX);
        largestY = Math.max(startY, endY);

        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

        width = Math.abs(endX - startX);
        height = Math.abs(endY - startY);

        this.shapeType = shapeAttributes.getShapeType();
        this.shapeShadingType = shapeAttributes.getShapeShadingType();
        this.primaryColor = shapeAttributes.getPrimaryColor();
        this.secondaryColor = shapeAttributes.getSecondaryColor();
    }

    public Shape(IApplicationState appState, ShapeAttributes shapeAttributes){
        this.shapeType = shapeAttributes.getShapeType();
        this.shapeShadingType = shapeAttributes.getShapeShadingType();
        this.primaryColor = shapeAttributes.getPrimaryColor();
        this.secondaryColor = shapeAttributes.getSecondaryColor();
    }

    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getLargestX() {
        return largestX;
    }
    @Override
    public int getLargestY() {
        return largestY;
    }

    @Override
    public int getStartX() {
        return startX;
    }
    @Override
    public int getStartY() {
        return startY;
    }
    @Override
    public int getEndX() {
        return endX;
    }
    @Override
    public int getEndY() {
        return endY;
    }

    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setIsSelected(Boolean bool){
        isSelected = bool;
    }
    @Override
    public Boolean getIsSelected(){
        return isSelected;
    }
    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }
    @Override
    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }
    @Override
    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }
    @Override
    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

//    @Override
//    public void move(int deltaX, int deltaY){
//        x = x + deltaX;
//        y = y + deltaY;
//
//        startX += deltaX;
//        startY += deltaY;
//        endX = endX + deltaX;
//        endY = endY + deltaY;
//
//        xPoints = new int[]{startX, endX, startX};
//        yPoints = new int[]{startY, endY, endY};
//    }
//
//    @Override
//    public void draw(IPaintStrategy paintStrategy, Graphics2D graphics2D) {
//        ShapePainter painter = new ShapePainter(paintStrategy);
//        painter.paintShape(this, graphics2D);
//    }

//    public int getMinCoordinate() {
//        return 0;
//    }
//
//    public int getMaxCoordinate() {
//        return 0;
//    }

}
