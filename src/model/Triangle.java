package model;

import model.interfaces.IApplicationState;

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
}

