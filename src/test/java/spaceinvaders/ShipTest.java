package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Captor;
import org.mockito.Mockito;

import javax.swing.*;
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
        Ship ship = new Ship();
        assertEquals(50, ship.getX());
    }
    @Test
    public void getYTest() {
        Ship ship = new Ship();
        assertEquals(40, ship.getY());
    }
    @Test
    public void getLeftBoundTest() {
        Ship ship = new Ship();
        assertEquals(46, ship.getLeftBound());
    }
    @Test
    public void getRightBoundTest() {
        Ship ship = new Ship();
        assertEquals(54, ship.getRightBound());
    }
    @Test
    public void addObserverTest() {
        Ship ship = new Ship();
        ShotObserver observer = Mockito.mock(ShotObserver.class);
        List<ShotObserver> expected = ship.getObservers();
        expected.add(observer);
        ship.addObserver(observer);
        assertEquals(expected.size(), ship.getObservers().size());
    }
    @Test
    public void removeObserverTest() {
        Ship ship = new Ship();
        ShotObserver observer = Mockito.mock(ShotObserver.class);
        ship.addObserver(observer);
        List<ShotObserver> expected = ship.getObservers();
        expected.remove(observer);
        ship.removeObserver(observer);
        assertEquals(expected.size(), ship.getObservers().size());
    }
    @Test
    public void notifyObserversTest() {
        Ship ship = new Ship();
        ShotObserver observer = Mockito.mock(ShotObserver.class);
        ship.addObserver(observer);
        Shot shot = Mockito.mock(Shot.class);
        ship.notifyObservers(shot);
        verify(observer, Mockito.times(1)).update(shot);
    }
    @Test
    public void drawTest() {
        Ship ship = new Ship();
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        ship.draw(graphics);
        for (int i = ship.getLeftBound(); i <= ship.getRightBound(); i++)
            verify(graphics, Mockito.times(1)).setCharacter(i, 42, TextCharacter.fromCharacter('#')[0]);
        verify(graphics, Mockito.times(1)).setCharacter(ship.getX()-1, 41, TextCharacter.fromCharacter('#')[0]);
        verify(graphics, Mockito.times(1)).setCharacter(ship.getX()+1, 41, TextCharacter.fromCharacter('#')[0]);
        verify(graphics, Mockito.times(1)).setCharacter(ship.getX(), ship.getY(), TextCharacter.fromCharacter('+')[0]);
        for (int i = 43; i >= 39; i--)
            verify(graphics, Mockito.times(1)).setCharacter(ship.getX(), i, TextCharacter.fromCharacter('S')[0]);
        verify(graphics, Mockito.times(1)).setCharacter(ship.getX(), ship.getY(), TextCharacter.fromCharacter('U')[0]);
        verify(graphics, Mockito.times(1)).setCharacter(ship.getX()-1, 43, TextCharacter.fromCharacter('S')[0]);
        verify(graphics, Mockito.times(1)).setCharacter(ship.getX()-1, 43, TextCharacter.fromCharacter('S')[0]);
    }
    @Test
    public void canIMoveTestLeftTrue() {
        Ship ship = new Ship();
        assertTrue(ship.canIMove(true));
    }
    @Test
    public void canIMoveTestRightTrue() {
        Ship ship = new Ship();
        assertTrue(ship.canIMove(false));
    }
    @Test
    public void canIMoveTestLeftFalse() {
        Ship ship = new Ship(5);
        assertFalse(ship.canIMove(true));
    }
    @Test
    public void canIMoveTestRightFalse() {
        Ship ship = new Ship(94);
        assertFalse(ship.canIMove(false));
    }
    @Test
    public void fireTest() {
        Ship ship = new Ship();
        ShotObserver observer = Mockito.mock(ShotObserver.class);
        ship.addObserver(observer);
        ship.fire();
        verify(observer, Mockito.times(1)).update(any(ShipShot.class));
    }
    @Test
    public void isAliveTest() {
        Ship ship = new Ship();
        assertTrue(ship.isAlive());
    }
    @Test
    public void getWidthTest() {
        Ship ship = new Ship();
        assertEquals(9, ship.getWidth());
    }
    @Test
    public void getHeightTest() {
        Ship ship = new Ship();
        assertEquals(5, ship.getHeight());
    }
    @Test
    public void processAKeyTest() {
        Ship ship = new Ship();
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn('a');
        int expectedLeftBound = ship.getLeftBound()-1;
        int expectedRightBound = ship.getRightBound()-1;
        int expectedX = ship.getX()-1;
        ship.processKey(key);
        assertEquals(expectedLeftBound, ship.getLeftBound());
        assertEquals(expectedRightBound, ship.getRightBound());
        assertEquals(expectedX, ship.getX());
    }
    @Test
    public void processDKeyTest() {
        Ship ship = new Ship();
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn('d');
        int expectedLeftBound = ship.getLeftBound()+1;
        int expectedRightBound = ship.getRightBound()+1;
        int expectedX = ship.getX()+1;
        ship.processKey(key);
        assertEquals(expectedLeftBound, ship.getLeftBound());
        assertEquals(expectedRightBound, ship.getRightBound());
        assertEquals(expectedX, ship.getX());
    }
    @Test
    public void processSpaceKeyTest() {
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn(' ');
        Ship ship = new Ship();
        ShotObserver observer = Mockito.mock(ShotObserver.class);
        ship.addObserver(observer);
        ship.processKey(key);
        verify(observer, Mockito.times(1)).update(any(ShipShot.class));
    }
    @Test
    public void processLeftArrowKeyTest() {
        Ship ship = new Ship();
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(ArrowLeft);
        int expectedLeftBound = ship.getLeftBound()-1;
        int expectedRightBound = ship.getRightBound()-1;
        int expectedX = ship.getX()-1;
        ship.processKey(key);
        assertEquals(expectedLeftBound, ship.getLeftBound());
        assertEquals(expectedRightBound, ship.getRightBound());
        assertEquals(expectedX, ship.getX());
    }
    @Test
    public void processRightArrowKeyTest() {
        Ship ship = new Ship();
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(ArrowRight);
        int expectedLeftBound = ship.getLeftBound()+1;
        int expectedRightBound = ship.getRightBound()+1;
        int expectedX = ship.getX()+1;
        ship.processKey(key);
        assertEquals(expectedLeftBound, ship.getLeftBound());
        assertEquals(expectedRightBound, ship.getRightBound());
        assertEquals(expectedX, ship.getX());
    }
    @Test
    public void processUpArrowKeyTest() {
        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.ArrowUp);
        Ship ship = new Ship();
        ShotObserver observer = Mockito.mock(ShotObserver.class);
        ship.addObserver(observer);
        ship.processKey(key);
        verify(observer, Mockito.times(1)).update(any(ShipShot.class));
    }
}
