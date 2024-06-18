package com.kodilla.patterns2.observer.homework;

public interface ExObservable {
    void registerObserver(ObserverMt mentor);
    void removeObserver(ObserverMt mentor);
    void notifyObservers();
}
