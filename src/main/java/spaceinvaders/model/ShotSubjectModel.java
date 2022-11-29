package spaceinvaders.model;

import java.util.List;

public interface ShotSubjectModel {
    List<ShotObserverModel> observers = new java.util.ArrayList<>();
    public void addObserver(ShotObserverModel observer);
    public void removeObserver(ShotObserverModel observer);
    public void notifyObservers(ShotModel shot);
}
