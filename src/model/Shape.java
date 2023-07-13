package model;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

public abstract class Shape implements IShape{
    int x;
    int y;
    int width;
    int height;
//    int[] xPoints;
//    int[] yPoints;
    ShapeType shapeType;
    ShapeShadingType shapeShadingType;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;

    public Shape(ApplicationState appState, int startX, int startY, int endX, int endY){
        x = Math.min(startX, endX);
        y = Math.min(startY, endY);
        width = Math.abs(endX - startX);
        height = Math.abs(endY - startY);

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
}
