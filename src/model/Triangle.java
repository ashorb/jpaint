package model;

import model.interfaces.IApplicationState;

class Triangle extends Shape {
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shadingType;

    public Triangle(IApplicationState appState, ShapeAttributes shapeAttributes, int startX, int startY, int endX, int endY) {
        super(appState, shapeAttributes, startX, startY, endX, endY);
    }

//    @Override
//    public void draw() {
//
//    }
//    @Override
//    public void paste() {
//
//    }
//    @Override
//    public void delete() {
//
//    }
}

