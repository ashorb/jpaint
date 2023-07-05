package model;
import model.interfaces.IShape;

public class Shape implements IShape{
    int x;
    int y;
    int width;
    int height;

    public Shape (int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

//    @Override
//    public String toString() {
//        return "Rectangle: " +
//                "x = " + x + " y = " + y;
//    }
}
