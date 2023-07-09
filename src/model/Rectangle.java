package model;

import model.persistence.ApplicationState;

class Rectangle extends Shape {
//    private final int width;
//    private final int height;
//    private final int x;
//    private final int y;
//    private ApplicationState appState;
//    ShapeType shapeType;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shadingType;

    public Rectangle(ApplicationState appState, int startX, int startY, int endX, int endY) {
        super(appState, startX, startY, endX, endY);

//        this.appState = appState;
//        shapeType = appState.getActiveShapeType();

//        x = Math.min(startX, endX);
//        y = Math.min(startY, endY);
//        width = Math.abs(endX - startX);
//        height = Math.abs(endY - startY);
    }

//    @Override
//    public int getX() {
//        return x;
//    }
//    @Override
//    public int getY() {
//        return y;
//    }
//    @Override
//    public int getWidth() {
//        return width;
//    }
//    @Override
//    public int getHeight() {
//        return height;
//    }
//
//
    @Override
    public int[] getXPoints() {
        return new int[0];
    }
    @Override
    public int[] getYPoints() {
        return new int[0];
    }

//    @Override
//    public ShapeType getShapeType() {
//        return shapeType;
//    }

    @Override
    public void draw() {

    }
    @Override
    public void move() {

    }
    @Override
    public void paste() {

    }
    @Override
    public void delete() {

    }
}
