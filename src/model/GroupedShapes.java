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
    int offset = 0;
    Point startPoint;
    Point endPoint;

    public GroupedShapes() {
        this.children = new ArrayList<>();
        startPoint = new Point();
        endPoint = new Point();
        startPoint.x = x;
        startPoint.y = y;
        endPoint.x = largestX;
        endPoint.y = largestY;
    }
    public GroupedShapes(Point startPoint, Point endPoint, int offset) {
        this.children = new ArrayList<>();
        this.startX = startPoint.getX();
        this.startY = startPoint.getY();
        this.endX = endPoint.getX();
        this.endY = endPoint.getY();
        this.offset = offset;
    }

    public List<IShape> getChildren() {
        return children;
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
    public int getStartX() {
        Integer minCoordinate = Integer.MAX_VALUE;
        for (IShape child : children){
            minCoordinate = Math.min(minCoordinate, child.getX());
        }
        startX = minCoordinate;
        return minCoordinate;
    }
    @Override
    public int getStartY() {
        Integer minCoordinate = Integer.MAX_VALUE;
        for (IShape child : children){
            minCoordinate = Math.min(minCoordinate, child.getY());
        }
        startY = minCoordinate;
        return minCoordinate;
    }
    @Override
    public int getEndX() {
        Integer maxCoordinate = Integer.MIN_VALUE;
        for (IShape child : children){
            maxCoordinate = Math.max(maxCoordinate, child.getLargestX());
        }
        endX = maxCoordinate;
        return maxCoordinate;
    }
    @Override
    public int getEndY() {
        Integer maxCoordinate = Integer.MIN_VALUE;
        for (IShape child : children){
            maxCoordinate = Math.max(maxCoordinate, child.getLargestY());
        }
        endY = maxCoordinate;
        return maxCoordinate;
    }

    public void addIShape(IShape shape) {
        children.add(shape);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        for (IShape shape : children){
            shape.move(deltaX, deltaY);
        }

        x = x + deltaX;
        y = y + deltaY;

        largestX += deltaX;
        largestY += deltaY;

        startX += deltaX;
        startY += deltaY;
        endX = endX + deltaX;
        endY = endY + deltaY;
    }

    public void setGroupCoordinates(){
        x = Math.min(getStartX(), getEndX());
        y = Math.min(getStartY(), getEndY());

        largestX = Math.max(getStartX(), getEndX());
        largestY = Math.max(getStartY(), getEndY());

        width = Math.abs(getEndX() - getStartX());
        height = Math.abs(getEndY() - getStartY());
    }

    @Override
    public void draw(Graphics2D graphics2d){
        for (IShape shape : children) {
            drawRecursive(shape, graphics2d);
        }
        setGroupCoordinates();
    }

    public void drawRecursive(IShape shape, Graphics2D graphics2D) {
        IPaintStrategy paintStrategy = null;
        ShapePainter painter;

        if(shape.getIShapeType().equals("GROUP")) {
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
