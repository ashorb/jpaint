package model;

import controller.ObserverSubject;
import model.interfaces.IShape;

import java.util.ArrayList;
import java.util.EmptyStackException;

final public class ShapeList extends ObserverSubject {
    private final ArrayList<IShape> masterList;
    private final ArrayList<IShape> selectedList = new ArrayList<>();
    private final ArrayList<IShape> copyList = new ArrayList<>();

    public ShapeList() {
        masterList = new ArrayList<>();
    }

    public void add(IShape s) {
        if (s == null) throw new IllegalArgumentException();
        masterList.add(s);
        notifyShapeListObservers();
    }
    public void remove(IShape shape) {
        if (masterList.isEmpty()) throw new EmptyStackException();
        masterList.remove(shape);
        notifyShapeListObservers();
    }

    public ArrayList<IShape> getMasterList() {
        return masterList;
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
