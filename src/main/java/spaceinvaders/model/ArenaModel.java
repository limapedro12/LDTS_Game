package spaceinvaders.model;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import spaceinvaders.view.ArenaViewer;
import spaceinvaders.view.Viewer;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

public class ArenaModel implements ShotObserverModel {
    private ArenaViewer viewer;
    private ShipModel ship;
    private AlienGroupModel aliens;
    private List<ElementModel> elements;
    private List<ShotModel> shots;
    private Command exitCommand;
    public ArenaModel(GameModel gameModel){
        this.exitCommand = new ExitToMenuCommand(gameModel);
        viewer = new ArenaViewer(this);
        ship = new ShipModel();
        ship.addObserver(this);
        elements = new ArrayList<>();
        shots = new ArrayList<>();
        aliens = new AlienGroupModel();
        elements.add(aliens);
        elements.add(ship);
        elements.add(new ProtectionModel(new PositionModel(48, 35),  1));
        elements.add(new ProtectionModel(new PositionModel(22, 35), 1));
        elements.add(new ProtectionModel(new PositionModel(72, 35), 30));
        // shots.add(new ShipShot(new Position(54, 45)));
        // shots.add(new AlienShot(new Position(25, 5)));
    }
    public Command getExitCommand(){
        return exitCommand;
    }

    public void update(ShotModel shot) {
        shots.add(shot);
    }

    public void run() {
        checkDead();
        checkShot();
        checkCollisions();
    }

    public void checkDead() {
        List<ElementModel> dead = new ArrayList<>();
        for (ElementModel element : elements) {
            if(!element.isAlive()) dead.add(element);
        }
        elements.removeAll(dead);
    }

    public void checkShot() {
        for (ShotModel shot : shots) {
            shot.update();
        }
    }

    public void checkCollisions() {
        List<ShotModel> collided = new ArrayList<>();
        for (ElementModel element : elements) {
            for (ShotModel shot : shots) {
                if (element.collideWith(shot)) {
                    element.damage();
                    collided.add(shot);
                }
            }
        }
        shots.removeAll(collided);
    }

    public List<ShotModel> getShots() {
        return shots;
    }

    public List<ElementModel> getElements() {
        return elements;
    }

    public List<AlienModel> getAliens() {
        return aliens.getAliens();
    }

    public ShipModel getShip() {
        return ship;
    }

    public ArenaViewer getViewer() {
        return viewer;
    }
}
