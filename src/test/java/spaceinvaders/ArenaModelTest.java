package spaceinvaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.controller.ArenaController;
import spaceinvaders.model.ArenaModel;
import spaceinvaders.model.ElementModel;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.ShotModel;
import spaceinvaders.view.ArenaViewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class ArenaModelTest {
    ArenaModel model;
    ArenaViewer viewer;
    ArenaController controller;

    private GameModel gameModel;


    @BeforeEach
    public void helper() {
        model = new ArenaModel(gameModel);
        viewer = new ArenaViewer(model);
        controller = new ArenaController(model);
    }


    @Test
    public void update(){
        ShotModel shot = Mockito.mock(ShotModel.class);
        assertEquals(0, model.getShots().size());
        model.update(shot);
        assertEquals(1, model.getShots().size());
    }

    @Test
    public void incrementLevelTest(){
        model.incrementLevel();
        assertEquals(2,model.getLevel());
    }

    @Test
    public void checkDeadTest(){
        ElementModel element = Mockito.mock(ElementModel.class);
        model.getElements().add(element);
        Assertions.assertEquals(6, model.getElements().size());
        element.damage();
        model.checkDead();
        Assertions.assertEquals(5, model.getElements().size());
    }

    @Test
    public void checkShotTest(){
        ShotModel shot = Mockito.mock(ShotModel.class);
        model.getShots().add(shot);
        model.checkShot();
        Mockito.verify(shot, Mockito.times(1)).update();
    }

    @Test
    public void checkCollisions(){
        ShotModel shotModel = Mockito.mock(ShotModel.class);
        ElementModel element = Mockito.mock(ElementModel.class);
        Mockito.when(element.collideWith(any())).thenReturn(true);
        model.getShots().add(shotModel);
        model.getElements().add(element);
        model.checkCollisions();
        Mockito.verify(element, Mockito.atLeast(1)).collideWith(any());
        Mockito.verify(element, Mockito.times(1)).damage();
        assertEquals(0, model.getShots().size());
    }

    @Test
    public void addScoreTest(){
        model.addScore(10);
        assertEquals(10, model.getScore());
    }
}
