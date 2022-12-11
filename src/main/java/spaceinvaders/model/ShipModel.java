package spaceinvaders.model;

import spaceinvaders.view.ShipViewer;

import javax.sound.sampled.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ShipModel extends ElementModel {
    private List<PositionModel> drawnPositions;
    private int leftBound;
    private int rightBound;
    private int upperBound;
    private int lowerBound;
    private int lives = 3;
    public ShipModel() {

        super(new PositionModel(24, 22));

        this.upperBound = position.getY();
        this.lowerBound = position.getY() + 3;
        this.leftBound = position.getX() - 2;
        this.rightBound = position.getX() + 2;
        this.viewer = new ShipViewer(this);
        this.drawnPositions = new ArrayList<>();
    }
    public ShipModel(int x) {
        super(new PositionModel(x, 22));
        this.leftBound = x-4;
        this.rightBound = x+4;
        this.viewer = new ShipViewer(this);
    }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }
    public void setX(int x) {
        position.setX(x);
    }
    public void setY(int y) {
        position.setY(y);
    }
    public int getUpperBound() {
        return upperBound;
    }
    public int getLowerBound() {
        return lowerBound;
    }
    public int getLeftBound() {
        return leftBound;
    }
    public int getRightBound() {
        return rightBound;
    }
    public void setLeftBound(int leftBound) {
        this.leftBound = leftBound;
    }
    public void setRightBound(int rightBound) {
        this.rightBound = rightBound;
    }
    public int getWidth() {
        return rightBound - leftBound + 1;
    }
    public int getHeight() {
        return lowerBound - upperBound + 1;
    }
    public boolean isAlive() {
        return lives > 0;
    }
    public void fire() {
        ShipShotModel shot = new ShipShotModel(new PositionModel(getX(), upperBound - 1));
        notifyObservers(shot);
        shotSound();
    }
    public int getLives(){
        return lives;
    }
    public void damage(){
        lives--;
    }
    @Override
    public boolean collideWith(ShotModel shot) {
        for(PositionModel drawnPosition : drawnPositions) {
            if(drawnPosition.getX() == shot.getX() && drawnPosition.getY() == shot.getY()) {
                return true;
            }
        }
        return false;
//        if (shot.getX() >= leftBound && shot.getX() <= rightBound && shot.getY() >= upperBound && shot.getY() <= lowerBound) {
//            return true;
//        }
//        return false;
    }
    public void addDrawnPosition(PositionModel position) {
        drawnPositions.add(position);
    }
    public void resetDrawnPositions() {
        drawnPositions = new ArrayList<>();
    }
    @Override
    public boolean canIMove(boolean goingLeft) {
        if (goingLeft) {
            return leftBound > 0;
        } else {
            return rightBound < 49;
        }
    }
    private void shotSound() {
        File f = new File("resources/sound/shot.wav");

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(f));
            clip.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
