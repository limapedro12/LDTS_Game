package spaceinvaders;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {
    /*@Test
    public void addObserverTest() {
        Ship ship = new Ship();
        ShotObserver observer = Mockito.mock(ShotObserver.class);
        ship.addObserver(observer);
        Mockito.verify(observer, Mockito.times(1)).add();
    }
    @Test
    public void removeObserverTest() {
        Ship ship = new Ship();
    }*/
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
}
