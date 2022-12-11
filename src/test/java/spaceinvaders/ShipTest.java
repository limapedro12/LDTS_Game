package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Captor;
import org.mockito.Mockito;
import spaceinvaders.controller.ShipController;
import spaceinvaders.model.*;
import spaceinvaders.view.ShipViewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import static com.googlecode.lanterna.input.KeyType.ArrowLeft;
import static com.googlecode.lanterna.input.KeyType.ArrowRight;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

public class ShipTest {
    @Test
    public void getXTest() {
        ShipModel ship = new ShipModel();
        assertEquals(24, ship.getX());
    }
    @Test
    public void getYTest() {
        ShipModel ship = new ShipModel();
        assertEquals(22, ship.getY());
    }
    @Test
    public void setYTest() {
        ShipModel ship = new ShipModel();
        ship.setY(10);
        assertEquals(10, ship.getY());
    }
    @Test
    public void getLeftBoundTest() {
        ShipModel ship = new ShipModel();
        assertEquals(22, ship.getLeftBound());
    }
    @Test
    public void getRightBoundTest() {
        ShipModel ship = new ShipModel();
        assertEquals(26, ship.getRightBound());
    }

    @Test
    public void getUpperBoundTest() {
        ShipModel ship = new ShipModel();
        assertEquals(22, ship.getUpperBound());
    }

    @Test
    public void getLowerBoundTest() {
        ShipModel ship = new ShipModel();
        assertEquals(25, ship.getLowerBound());
    }


    @Test
    public void addObserverTest() {
        ShipModel ship = new ShipModel();
        ShotObserverModel observer = Mockito.mock(ShotObserverModel.class);
        HashSet<ShotObserverModel> expected = ship.getObservers();
        expected.add(observer);
        ship.addObserver(observer);
        assertEquals(expected.size(), ship.getObservers().size());
    }
    @Test
    public void removeObserverTest() {
        ShipModel ship = new ShipModel();
        ShotObserverModel observer = Mockito.mock(ShotObserverModel.class);
        ship.addObserver(observer);
        HashSet<ShotObserverModel> expected = ship.getObservers();
        expected.remove(observer);
        ship.removeObserver(observer);
        assertEquals(expected.size(), ship.getObservers().size());
    }
    @Test
    public void notifyObserversTest() {
        ShipModel ship = new ShipModel();
        ShotObserverModel observer = Mockito.mock(ShotObserverModel.class);
        ship.addObserver(observer);
        ShotModel shot = Mockito.mock(ShotModel.class);
        ship.notifyObservers(shot);
        verify(observer, Mockito.times(1)).update(shot);
    }
    @Test
    public void drawTest() {
        ShipModel model = new ShipModel();
        ShipViewer ship = new ShipViewer(model);
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        ship.draw(graphics);
        verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        verify(graphics, Mockito.times(1)).putString(model.getX(), model.getUpperBound(),"\"");
        verify(graphics, Mockito.times(1)).putString(model.getRightBound(), model.getUpperBound()+1,",");
        for (int i = model.getLeftBound()+1; i <= model.getRightBound()-1; i++)
            verify(graphics, Mockito.times(1)).putString(i, model.getUpperBound()+1, "=");
        for (int i = model.getLeftBound(); i <= model.getRightBound(); i++)
            verify(graphics, Mockito.times(1)).putString(i, model.getUpperBound()+2,"=");

    }
    @Test
    public void getModelTest() {
        ShipModel model = new ShipModel();
        ShipViewer ship = new ShipViewer(model);
        assertEquals(model, ship.getModel());
    }
    @Test
    public void canIMoveTestLeftTrue() {
        ShipModel ship = new ShipModel();
        assertTrue(ship.canIMove(true));
    }
    @Test
    public void canIMoveTestRightTrue() {
        ShipModel ship = new ShipModel();
        assertTrue(ship.canIMove(false));
    }
    @Test
    public void canIMoveTestLeftFalse() {
        ShipModel ship = new ShipModel(-5);
        assertFalse(ship.canIMove(true));
    }
    @Test
    public void canIMoveTestRightFalse() {
        ShipModel ship = new ShipModel(94);
        assertFalse(ship.canIMove(false));
    }
    @Test
    public void fireTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ShipModel ship = new ShipModel();
        ShotObserverModel observer = Mockito.mock(ShotObserverModel.class);
        ship.addObserver(observer);
        ship.fire();
        verify(observer, Mockito.times(1)).update(any(ShipShotModel.class));
    }
    @Test
    public void isAliveTest() {
        ShipModel ship = new ShipModel();
        assertTrue(ship.isAlive());
    }
    @Test
    public void damageTest() {
        ShipModel ship = new ShipModel();
        ship.damage();
        assertEquals(2,ship.getLives());
    }

    @Test
    public void getLivesTest() {
        ShipModel ship = new ShipModel();
        assertEquals(3,ship.getLives());
    }
    @Test
    public void getWidthTest() {
        ShipModel ship = new ShipModel();
        assertEquals(5,ship.getWidth());

    }
    @Test
    public void getHeightTest() {
        ShipModel ship = new ShipModel();
        assertEquals(4,ship.getHeight());
    }
    /*@Test
    public void collideWith1() {
        ShipModel ship = new ShipModel();
        ship.addDrawnPosition(new PositionModel(24,22));
        assertTrue(ship.collideWith(new AlienShotModel(new PositionModel(24,22),1)));
    }

    @Test
    public void collideWith2() {
        ShipModel ship = new ShipModel();
        ship.addDrawnPosition(new PositionModel(24,22));
        assertFalse(ship.collideWith(new AlienShotModel(new PositionModel(24,21),1)));

    }*/

    @Test
    public void processAKeyTest() {
        ShipModel model = new ShipModel();
        ShipController ship = new ShipController(model);
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn('a');
        int expectedLeftBound = model.getLeftBound()-1;
        int expectedRightBound = model.getRightBound()-1;
        int expectedX = model.getX()-1;
        ship.processKey(key);
        assertEquals(expectedLeftBound, model.getLeftBound());
        assertEquals(expectedRightBound, model.getRightBound());
        assertEquals(expectedX, model.getX());
    }
    @Test
    public void processDKeyTest() {
        ShipModel model = new ShipModel();
        ShipController ship = new ShipController(model);
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn('d');
        int expectedLeftBound = model.getLeftBound()+1;
        int expectedRightBound = model.getRightBound()+1;
        int expectedX = model.getX()+1;
        ship.processKey(key);
        assertEquals(expectedLeftBound, model.getLeftBound());
        assertEquals(expectedRightBound, model.getRightBound());
        assertEquals(expectedX, model.getX());
    }
    @Test
    public void processSpaceKeyTest() {
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn(' ');
        ShipModel model = new ShipModel();
        ShipController ship = new ShipController(model);
        ShotObserverModel observer = Mockito.mock(ShotObserverModel.class);
        model.addObserver(observer);
        ship.processKey(key);
        verify(observer, Mockito.times(1)).update(any(ShipShotModel.class));
    }
    @Test
    public void processLeftArrowKeyTest() {
        ShipModel model = new ShipModel();
        ShipController ship = new ShipController(model);
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(ArrowLeft);
        int expectedLeftBound = model.getLeftBound()-1;
        int expectedRightBound = model.getRightBound()-1;
        int expectedX = model.getX()-1;
        ship.processKey(key);
        assertEquals(expectedLeftBound, model.getLeftBound());
        assertEquals(expectedRightBound, model.getRightBound());
        assertEquals(expectedX, model.getX());
    }
    @Test
    public void processRightArrowKeyTest() {
        ShipModel model = new ShipModel();
        ShipController ship = new ShipController(model);
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(ArrowRight);
        int expectedLeftBound = model.getLeftBound()+1;
        int expectedRightBound = model.getRightBound()+1;
        int expectedX = model.getX()+1;
        ship.processKey(key);
        assertEquals(expectedLeftBound, model.getLeftBound());
        assertEquals(expectedRightBound, model.getRightBound());
        assertEquals(expectedX, model.getX());
    }
    @Test
    public void processUpArrowKeyTest() {
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.ArrowUp);
        ShipModel model = new ShipModel();
        ShipController ship = new ShipController(model);
        ShotObserverModel observer = Mockito.mock(ShotObserverModel.class);
        model.addObserver(observer);
        ship.processKey(key);
        verify(observer, Mockito.times(1)).update(any(ShipShotModel.class));
    }
}
