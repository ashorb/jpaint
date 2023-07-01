package model;

import java.util.ArrayList;

final public class ShapeList {
    final private ArrayList<Shape> list;
    public ShapeList() {
        list = new ArrayList<Shape>();
    }
//    ArrayList<Shape> shapeList = new ArrayList();

    public void add(Shape s) {
        if (s == null) throw new IllegalArgumentException();
        list.add(s);

//        for (int i = 0; i < list.size();i++)
//        {
//            System.out.println(list.get(i));
//        }

    }
}
