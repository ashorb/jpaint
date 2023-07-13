package model;

import model.interfaces.IShape;
import view.interfaces.IShapeListObserver;
import view.interfaces.IShapeListSubject;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

final public class ShapeList implements IShapeListSubject {
    private final ArrayList<IShape> list;

    private List<IShapeListObserver> shapeListObservers = new ArrayList<>();

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

    @Override
    public void registerObserver(IShapeListObserver observer) {
        shapeListObservers.add(observer);
    }
//    @Override
//    public void removeObserver(IShapeListObserver observer) {
//        shapeListObservers.remove(observer);
//    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : shapeListObservers){
            shapeListObserver.update();
        }
    }
}
