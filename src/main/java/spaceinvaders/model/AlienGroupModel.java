package spaceinvaders.model;

import spaceinvaders.view.AlienGroupViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AlienGroupModel extends ElementModel {
    private List<AlienModel> aliens;

    private int score =0;
    public AlienGroupModel() {
        super(new PositionModel(0, 0));
        aliens = new ArrayList<AlienModel>();
        viewer = new AlienGroupViewer(this);
        createAliens();
    }

    private void createAliens() {
        for (int j = 0; j < 10; j++) {
            AlienModel a = new AlienModel(new PositionModel(13 + 8 * j, 9), '*');
            AlienModel b = new AlienModel(new PositionModel(13 + 8 * j, 11), '/');
            AlienModel c = new AlienModel(new PositionModel(13 + 8 * j, 13), '-');
            AlienModel d = new AlienModel(new PositionModel(13 + 8 * j, 15), '.');
            AlienModel e = new AlienModel(new PositionModel(13 + 8 * j, 17), '.');
            aliens.add(a); aliens.add(b); aliens.add(c); aliens.add(d); aliens.add(e);
        }
    }
    public void addAlien(AlienModel alien) {
        aliens.add(alien);
    }
    public List<AlienModel> getAliens() {
        return aliens;
    }
    public boolean isAlive() {
        return true;
    }

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public int getScore() { return score;}

    @Override
    public boolean isTangible() {
        return false;
    }
    public void damage() {}
    @Override
    public boolean canIMove(boolean goingLeft) {
        for (AlienModel alien : aliens) {
            if (!alien.canIMove(goingLeft)) return false;
        }
        return true;
    }
    @Override
    public void move(int direction) {
        switch (direction) {
            case 0: // left
                this.position.setX(this.position.getX()-1);
                break;
            case 1: // right
                this.position.setX(this.position.getX()+1);
                break;
            case 2: // down
                this.position.setY(this.position.getY()+1);
                break;
        }
        for (AlienModel alien : aliens) alien.move(direction);
    }
    public void fire(float level) {
        if(aliens.size() > 0) {
            int random = ThreadLocalRandom.current().nextInt(0, 2 * aliens.size());
            if (random < aliens.size()) aliens.get(random).fire(level);
        }
    }
    @Override
    public boolean collideWith(ShotModel shot) {
        for (AlienModel alien : aliens) {
            if (alien.collideWith(shot)) {
                if (alien.getSymbol() == '*'){
                    score+=10;
                }
                else if (alien.getSymbol() == '/'){
                    score+=20;
                }
                else if (alien.getSymbol() == '-'){
                    score+=30;
                }
                else if (alien.getSymbol() == '.'){
                    score += 40;
                }
                alien.damage();
                aliens.remove(alien);
                return true;
            }
        }
        return false;
    }
}
