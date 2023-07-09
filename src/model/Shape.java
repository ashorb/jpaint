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

    public Shape(ApplicationState appState, int startX, int startY, int endX, int endY){
        x = Math.min(startX, endX);
        y = Math.min(startY, endY);
        width = Math.abs(endX - startX);
        height = Math.abs(endY - startY);

        shapeType = appState.getActiveShapeType();
    }


//    public Shape (int x, int y, int width, int height){
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//    }

//    public Shape (Point x, Point y){
//        this.x = x;
//        this.y = y;
//    }

//    @Override
//    public Point getX() {
//        return x;
//    }
//    @Override
//    public Point getY() {
//        return y;
//    }

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
//    public int[] getXPoints() {
//        return xPoints;
//    }
//    public int[] getYPoints() {
//        return yPoints;
//    }
}
