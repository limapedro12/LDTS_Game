package spaceinvaders.model;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import spaceinvaders.view.ArenaViewer;
import spaceinvaders.view.Viewer;

import javax.swing.text.View;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArenaModel implements ShotObserverModel {
    private Viewer viewer;
    private ShipModel ship;
    private AlienGroupModel aliens;
    private List<ElementModel> elements;
    private List<ShotModel> shots;


    private List<LifeModel> lives;

    private int lifes;

    private int score;

    public ArenaModel() {
        score =0;
        viewer = new ArenaViewer(this);
        ship = new ShipModel();
        ship.addObserver(this);
        elements = new ArrayList<>();
        shots = new ArrayList<>();
        aliens = new AlienGroupModel();
        lives = new ArrayList<>();
        lifes = 3;
        elements.add(aliens);
        elements.add(ship);
        elements.add(new ProtectionModel(new PositionModel(48, 35),  1));
        elements.add(new ProtectionModel(new PositionModel(22, 35), 1));
        elements.add(new ProtectionModel(new PositionModel(72, 35), 30));
        lives.add(new LifeModel(new PositionModel(10,50)));
        lives.add(new LifeModel(new PositionModel(12,50)));
        lives.add(new LifeModel(new PositionModel(14,50)));
        // shots.add(new ShipShot(new Position(54, 45)));
        // shots.add(new AlienShot(new Position(25, 5)));
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
            if (!element.isAlive()) {
                if (element instanceof ShipModel) {
                    lifes--;
                    if (lifes == 0) {
                        dead.add(element);
                        PrintWriter pw = null;

                        try {
                            File file = new File("Highscores.csv");
                            FileWriter fw = new FileWriter(file, true);
                            pw = new PrintWriter(fw);
                            pw.println(score+"%n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (pw != null) {
                                pw.close();
                            }
                        }
                    }
                } else {
                    dead.add(element);
                }

            }

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
                if (shot.collideWith(element)) {
                    if (element instanceof AlienModel){
                        score +=10;
                    }

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

    public List<LifeModel> getLives(){ return lives;}

    public List<AlienModel> getAliens() {
        return aliens.getAliens();
    }

    public ShipModel getShip() {
        return ship;
    }

    public Viewer getViewer() {
        return viewer;
    }


    public int getLifes(){
        return lifes;
    }

    public int getScore(){return score;}

}
