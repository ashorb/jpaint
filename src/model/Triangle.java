package model;

import model.persistence.ApplicationState;

class Triangle extends Shape {
    private final int[] xPoints;
    private final int[] yPoints;
//    private ApplicationState appState;
//    ShapeType shapeType;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shadingType;

    public Triangle(ApplicationState appState, int startX, int startY, int endX, int endY) {
        super(appState, startX, startY, endX, endY);

//        this.appState = appState;
//        shapeType = appState.getActiveShapeType();

        this.xPoints = new int[]{startX, endX, startX};
        this.yPoints = new int[]{startY, endY, endY};
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

    @Override
    public int[] getXPoints() {
        return xPoints;
    }
    @Override
    public int[] getYPoints() {
        return yPoints;
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

