package model;

import model.persistence.ApplicationState;

class Triangle extends Shape {
    private final int[] xPoints;
    private final int[] yPoints;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shadingType;

    public Triangle(ApplicationState appState, int startX, int startY, int endX, int endY) {
        super(appState, startX, startY, endX, endY);

        this.xPoints = new int[]{startX, endX, startX};
        this.yPoints = new int[]{startY, endY, endY};
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
    public void draw() {

    }
    @Override
    public void paste() {

    }
    @Override
    public void delete() {

    }
}

