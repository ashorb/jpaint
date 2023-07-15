package model;

import model.persistence.ApplicationState;

class Ellipse extends Shape {
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shadingType;

    public Ellipse(ApplicationState appState, int startX, int startY, int endX, int endY) {
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
