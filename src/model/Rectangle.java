package model;

import model.interfaces.IApplicationState;

class Rectangle extends Shape {

    public Rectangle(IApplicationState appState, ShapeAttributes shapeAttributes, int startX, int startY, int endX, int endY) {
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
