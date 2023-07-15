package model;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

public abstract class Shape implements IShape{
    int x;
    int y;
    int startX;
    int startY;
    int endX;
    int endY;
    int width;
    int height;
    int[] xPoints;
    int[] yPoints;
    ShapeType shapeType;
    ShapeShadingType shapeShadingType;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;

    public Shape(ApplicationState appState, int startX, int startY, int endX, int endY){
        x = Math.min(startX, endX);
        y = Math.min(startY, endY);

        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

        width = Math.abs(endX - startX);
        height = Math.abs(endY - startY);

        xPoints = new int[]{startX, endX, startX};
        yPoints = new int[]{startY, endY, endY};

        shapeType = appState.getActiveShapeType();
        shapeShadingType = appState.getActiveShapeShadingType();
        primaryColor = appState.getActivePrimaryColor();
        secondaryColor = appState.getActiveSecondaryColor();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int[] getXPoints() {
        return xPoints;
    }
    @Override
    public int[] getYPoints() {
        return yPoints;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }
    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }
    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }
    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public void move(int deltaX, int deltaY){
        x = x + deltaX;
        y = y + deltaY;

        startX += deltaX;
        startY += deltaY;
        endX = endX + deltaX;
        endY = endY + deltaY;

        xPoints = new int[]{startX, endX, startX};
        yPoints = new int[]{startY, endY, endY};
    };
}
