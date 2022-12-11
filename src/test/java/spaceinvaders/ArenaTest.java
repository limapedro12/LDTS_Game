package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.controller.ArenaController;
import spaceinvaders.model.*;
import spaceinvaders.model.menu.Command;
import spaceinvaders.model.menu.ExitToMenuCommand;
import spaceinvaders.view.ArenaViewer;
import spaceinvaders.view.ElementViewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class ArenaTest {
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
    public void moveAliensTest(){
        model.moveAliens();
        assertEquals(9, model.getAliens().get(0).getPosition().getY());
    }

    @Test
    public void incrementLevelTest(){
        model.incrementLevel();
        assertEquals(2,model.getLevel());
    }
    
//    @Test
//    public void createAliens(){
//        assertEquals(50, model.getAliens().size());
//        model.createAliens();
//        assertEquals(100, model.getAliens().size());
//        assertEquals(104, model.getElements().size());
//    }
    
    @Test
    public void draw1(){
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        ElementModel elementModel = Mockito.mock(ElementModel.class);
        ElementViewer elementViewer = Mockito.mock(ElementViewer.class);
        Mockito.when(elementModel.getViewer()).thenReturn(elementViewer);
        model.getElements().add(elementModel);
        viewer.draw(graphics);
        Mockito.verify(elementViewer, Mockito.times(1)).draw(graphics);
        //Mockito.verify(elementModel, Mockito.times(1)).isAlive();
    }

    @Test
    public void draw2(){
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        ShotModel shotModel = Mockito.mock(ShotModel.class);
        ElementViewer elementViewer = Mockito.mock(ElementViewer.class);
        Mockito.when(shotModel.getViewer()).thenReturn(elementViewer);
        model.getShots().add(shotModel);
        viewer.draw(graphics);
        Mockito.verify(elementViewer, Mockito.times(1)).draw(graphics);
        //Mockito.verify(shotModel, Mockito.times(1)).update();
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

    @Test
    public void processKey1(){
        controller.processKey(new KeyStroke('a', false, false));
        assertEquals(49, model.getShip().getX());
    }

    @Test
    public void processKey2(){
        controller.processKey(new KeyStroke('d', false, false));
        assertEquals(51, model.getShip().getX());
    }

    @Test
    public void processKey3(){
        controller.processKey(new KeyStroke(' ', false, false));
        assertEquals(1, model.getShots().size());
    }

    @Test
    public void processKey4(){
        controller.processKey(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(49, model.getShip().getX());
    }

    @Test
    public void processKey5(){
        controller.processKey(new KeyStroke(KeyType.ArrowRight));
        assertEquals(51, model.getShip().getX());
    }

    @Test
    public void processKey6(){
        controller.processKey(new KeyStroke(KeyType.ArrowUp));
        assertEquals(1, model.getShots().size());
    }
}
