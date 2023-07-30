package model;

import model.interfaces.IApplicationState;

class Ellipse extends Shape {

    public Ellipse(IApplicationState appState, ShapeAttributes shapeAttributes, int startX, int startY, int endX, int endY) {
        super(appState, shapeAttributes, startX, startY, endX, endY);
    }

    @Override
    public void move(int deltaX, int deltaY){
        x = x + deltaX;
        y = y + deltaY;

        startX += deltaX;
        startY += deltaY;
        endX = endX + deltaX;
        endY = endY + deltaY;
    }
}
