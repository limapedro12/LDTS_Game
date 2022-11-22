package spaceinvaders;

import java.util.List;

public interface ShotSubject {
    List<ShotObserver> observers = new java.util.ArrayList<>();
    public void addObserver(ShotObserver observer);
    public void removeObserver(ShotObserver observer);
    public void notifyObservers(Shot shot);
}
