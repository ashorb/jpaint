package model;

import model.drawing.PaintEllipse;
import model.drawing.PaintRectangle;
import model.drawing.PaintTriangle;
import model.drawing.ShapePainter;
import model.interfaces.IPaintStrategy;
import model.interfaces.IShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroupedShapes implements IShape {

    private final List<IShape> children;
    public List<IShape> getChildren() {
        return children;
    }

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
    Boolean isSelected = false;
    String iShapeType;

    public GroupedShapes() {
        this.children = new ArrayList<>();
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
        return null;
    }
    @Override
    public ShapeShadingType getShapeShadingType() {
        return null;
    }
    @Override
    public ShapeColor getPrimaryColor() {
        return null;
    }
    @Override
    public ShapeColor getSecondaryColor() {
        return null;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x = x + deltaX;
        y = y + deltaY;

        startX += deltaX;
        startY += deltaY;
        endX = endX + deltaX;
        endY = endY + deltaY;

//        for (IShape shape : children){
//            x = x + deltaX;
//            y = y + deltaY;
//
//            startX += deltaX;
//            startY += deltaY;
//            endX = endX + deltaX;
//            endY = endY + deltaY;
//        }
    }

//    @Override
//    public void draw(IPaintStrategy paintStrategy, Graphics2D graphics2D) {
//        ShapePainter painter = new ShapePainter(paintStrategy);
//        for (IShape shape : children) {
//            painter.paintShape(shape, graphics2D);
//        }
//    }
//    @Override
//    public void draw(Graphics2D graphics2d){
//        drawRecursive(IShape shape, graphics2d);
//    }

    IShape iShape;

    @Override
    public void draw(Graphics2D graphics2d){

        for (IShape shape : children) {
            drawRecursive(shape, graphics2d);
        }
    }

    public void drawRecursive(IShape shape, Graphics2D graphics2D) {
        IPaintStrategy paintStrategy = null;
        ShapePainter painter;
//        for (IShape shape : children) {

            if(shape.getIShapeType().equals("GROUP")) {
                System.out.println("group children: " + shape.getChildren());
                for (IShape s : shape.getChildren()){
                    drawRecursive(s, graphics2D);

                }

            } else {
                if (shape.getIShapeType().equals("RECTANGLE")) {
                    paintStrategy = new PaintRectangle();
                } else if (shape.getIShapeType().equals("ELLIPSE")) {
                    paintStrategy = new PaintEllipse();
                } else if (shape.getIShapeType().equals("TRIANGLE")) {
                    paintStrategy = new PaintTriangle();
                }

                shape.setIsSelected(false);
                painter = new ShapePainter(paintStrategy);
                painter.paintShape(shape, graphics2D);
            }
//        this.setIsSelected(true);
    }


//    public void drawRecursive(IShape shape, Graphics2D graphics2D) {
//        IPaintStrategy paintStrategy = null;
//        for (IShape shape : children) {
//            if(getIShapeType().equals("GROUP")) {
//                for (IShape g : children) {
//                    if (g.getIShapeType().equals("RECTANGLE")) {
//                        paintStrategy = new PaintRectangle();
//                    } else if (g.getIShapeType().equals("ELLIPSE")) {
//                        paintStrategy = new PaintEllipse();
//                    } else if (g.getIShapeType().equals("TRIANGLE")) {
//                        paintStrategy = new PaintTriangle();
//                    }
//
//                    ShapePainter painter = new ShapePainter(paintStrategy);
//                    painter.paintShape(g, graphics2D);
//
//                }
//            } else {
//                if (shape.getIShapeType().equals("RECTANGLE")) {
//                    paintStrategy = new PaintRectangle();
//                } else if (shape.getIShapeType().equals("ELLIPSE")) {
//                    paintStrategy = new PaintEllipse();
//                } else if (shape.getIShapeType().equals("TRIANGLE")) {
//                    paintStrategy = new PaintTriangle();
//                }
//
//                shape.setIsSelected(false);
//                ShapePainter painter = new ShapePainter(paintStrategy);
//                painter.paintShape(shape, graphics2D);
//            }
//
//
//
//
//        }
//        select(graphics2D);
//    }

    public void addIShape(IShape shape) {
        children.add(shape);
    }

    @Override
    public int getStartX() {
        Integer minCoordinate = Integer.MAX_VALUE;
        for (IShape child : children){
            minCoordinate = Math.min(minCoordinate, child.getX());
        }
        System.out.println(minCoordinate);
        startX = minCoordinate;
        return minCoordinate;
    }
    @Override
    public int getStartY() {
        Integer minCoordinate = Integer.MAX_VALUE;
        for (IShape child : children){
            minCoordinate = Math.min(minCoordinate, child.getY());
        }
        System.out.println(minCoordinate);
        startY = minCoordinate;
        return minCoordinate;
    }
    @Override
    public int getEndX() {
        Integer maxCoordinate = Integer.MIN_VALUE;
        for (IShape child : children){
            maxCoordinate = Math.max(maxCoordinate, child.getLargestX());
        }
        System.out.println(maxCoordinate);
        endX = maxCoordinate;
        return maxCoordinate;
    }
    @Override
    public int getEndY() {
        Integer maxCoordinate = Integer.MIN_VALUE;
        for (IShape child : children){
            maxCoordinate = Math.max(maxCoordinate, child.getLargestY());
        }
        System.out.println(maxCoordinate);
        endY = maxCoordinate;
        return maxCoordinate;
    }
    public int getMinCoordinate() {
        Integer minCoordinate = Integer.MAX_VALUE;
        for (IShape child : children){
            minCoordinate = Math.min(minCoordinate, child.getMinCoordinate());
        }
//        System.out.println(minCoordinate);
        return minCoordinate;
    }

    public int getMaxCoordinate() {
        Integer maxCoordinate = Integer.MIN_VALUE;
        for (IShape child : children){
            maxCoordinate = Math.max(maxCoordinate, child.getMaxCoordinate());
        }
//        System.out.println(maxCoordinate);
        return maxCoordinate;
    }

    public void setGroupCoordinates(){

        x = Math.min(getStartX(), getEndX());
        y = Math.min(getStartY(), getEndY());

        largestX = Math.max(startX, endX);
        largestY = Math.max(startY, endY);

        width = Math.abs(getEndX() - getStartX());
        height = Math.abs(getEndY() - getStartY());
    }

    @Override
    public void select(Graphics2D graphics2d) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.MAGENTA);
        graphics2d.drawRect(getX() - 5, getY() - 5, getWidth() + 10, getHeight() + 10);
    }

    @Override
    public String getIShapeType() {
        return "GROUP";
    }
}
