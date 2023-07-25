package model;

import controller.ObserverSubject;
import model.interfaces.IShape;

import java.util.ArrayList;
import java.util.EmptyStackException;

final public class ShapeList extends ObserverSubject {
    private final ArrayList<IShape> list;
    private final ArrayList<IShape> selectedList = new ArrayList<>();
    private final ArrayList<IShape> copyList = new ArrayList<>();

    public ShapeList() {
        list = new ArrayList<>();
    }

    public void add(IShape s) {
        if (s == null) throw new IllegalArgumentException();
        list.add(s);
        notifyShapeListObservers();
    }

    public void remove() {
        if (list.isEmpty()) throw new EmptyStackException();
        list.remove(list.size()-1);
        notifyShapeListObservers();
    }

    public ArrayList<IShape> getList() {
        return list;
    }

    public ArrayList<IShape> getSelectedList() {
        return selectedList;
    }

    public ArrayList<IShape> getCopyList() {
        return copyList;
    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
