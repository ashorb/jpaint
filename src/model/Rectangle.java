package model;

import model.persistence.ApplicationState;

class Rectangle extends Shape {
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shadingType;

    public Rectangle(ApplicationState appState, int startX, int startY, int endX, int endY) {
        super(appState, startX, startY, endX, endY);
    }

    @Override
    public void draw() {

    }
    @Override
    public void paste() {

    }
    @Override
    public void delete() {

    }
}
