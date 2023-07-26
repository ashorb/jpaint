package model;

import model.interfaces.IApplicationState;

public class ShapeAttributes {
    ShapeType shapeType;
    ShapeShadingType shapeShadingType;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;

    public ShapeAttributes (IApplicationState appState) {
        this.shapeType = appState.getActiveShapeType();
        this.shapeShadingType = appState.getActiveShapeShadingType();
        this.primaryColor = appState.getActivePrimaryColor();
        this.secondaryColor = appState.getActiveSecondaryColor();
    }
    public ShapeAttributes(ShapeType shapeType, ShapeShadingType shapeShadingType, ShapeColor primaryColor, ShapeColor secondaryColor) {
        this.shapeType = shapeType;
        this.shapeShadingType = shapeShadingType;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
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