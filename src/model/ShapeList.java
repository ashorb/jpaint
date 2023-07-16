package model;

import controller.ObserverSubject;
import model.interfaces.IShape;

import java.util.ArrayList;
import java.util.EmptyStackException;

final public class ShapeList extends ObserverSubject {
    private final ArrayList<IShape> list;
//    private List<IShapeListObserver> shapeListObservers = new ArrayList<>();

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

//    @Override
//    public void registerObserver(IShapeListObserver observer) {
//        shapeListObservers.add(observer);
//    }
//
//    private void notifyShapeListObservers(){
//        for (var shapeListObserver : shapeListObservers){
//            shapeListObserver.update();
//        }
//    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }

//    public List<IShapeListObserver> getShapeListObservers() {
//        return shapeListObservers;
//    }
}
