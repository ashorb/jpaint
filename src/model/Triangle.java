package model;

import model.drawing.PaintTriangle;
import model.drawing.ShapePainter;
import model.interfaces.IApplicationState;
import model.interfaces.IPaintStrategy;

import java.awt.*;

class Triangle extends Shape {
    int[] xPoints;
    int[] yPoints;

    public Triangle(IApplicationState appState, ShapeAttributes shapeAttributes, int startX, int startY, int endX, int endY, int[] xPoints, int[] yPoints) {
        super(appState, shapeAttributes, startX, startY, endX, endY);

        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    @Override
    public int[] getXPoints() {
        return xPoints;
    }
    @Override
    public int[] getYPoints() {
        return yPoints;
    }

    @Override
    public void move(int deltaX, int deltaY){
        x = x + deltaX;
        y = y + deltaY;

        startX += deltaX;
        startY += deltaY;
        endX = endX + deltaX;
        endY = endY + deltaY;

        xPoints = new int[]{startX, endX, startX};
        yPoints = new int[]{startY, endY, endY};
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        IPaintStrategy paintStrategy = new PaintTriangle();
        ShapePainter painter = new ShapePainter(paintStrategy);
        painter.paintShape(this, graphics2D);
    }

    @Override
    public void select(Graphics2D graphics2d) {
        int startX = getStartX();
        int startY = getStartY();
        int endX = getEndX();
        int endY = getEndY();

        int[] xPoints;
        int[] yPoints;

        if (startX < endX){ //draw from left to right
            xPoints = new int[]{getStartX() - 5, getEndX() + 10, getStartX() - 5};
        }
        else{ //draw from right to left
            xPoints = new int[]{getStartX() + 5, getEndX() - 10, getStartX() + 5};
        }
        if (startY < endY){ //draw from top to bottom
            yPoints = new int[]{getStartY() - 10, getEndY() + 5, getEndY() + 5};
        }
        else{ //draw from bottom to top
            yPoints = new int[]{getStartY() + 10, getEndY() - 5, getEndY() - 5};
        }

        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.MAGENTA);
        graphics2d.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public String getIShapeType() {
        return "TRIANGLE";
    }
}

