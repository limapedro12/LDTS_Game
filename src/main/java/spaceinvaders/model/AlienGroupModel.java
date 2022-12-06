package spaceinvaders.model;

import spaceinvaders.view.AlienGroupViewer;

import java.util.ArrayList;
import java.util.List;

public class AlienGroupModel extends ElementModel{
    private List<AlienModel> aliens;
    public AlienGroupModel() {
        super(new PositionModel(0, 0));
        aliens = new ArrayList<AlienModel>();
        viewer = new AlienGroupViewer(this);
        createAliens();
    }

    private void createAliens() {
        for (int j = 0; j < 10; j++) {
            AlienModel a = new AlienModel(new PositionModel(13 + 8 * j, 9), '&');
            AlienModel b = new AlienModel(new PositionModel(13 + 8 * j, 11), 'Y');
            AlienModel c = new AlienModel(new PositionModel(13 + 8 * j, 13), 'Y');
            AlienModel d = new AlienModel(new PositionModel(13 + 8 * j, 15), 'X');
            AlienModel e = new AlienModel(new PositionModel(13 + 8 * j, 17), 'X');
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

    @Override
    public boolean isTangible() {
        return false;
    }
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
}
