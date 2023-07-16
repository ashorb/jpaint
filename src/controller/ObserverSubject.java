package controller;

import controller.interfaces.IShapeListObserver;
import controller.interfaces.IShapeListSubject;

import java.util.ArrayList;
import java.util.List;

public class ObserverSubject implements IShapeListSubject {
    private static final List<IShapeListObserver> shapeListObservers = new ArrayList<>();
    @Override
    public void registerObserver(IShapeListObserver observer) {
        shapeListObservers.add(observer);
    }

    public List<IShapeListObserver> getShapeListObservers() {
        return shapeListObservers;
    }
}
