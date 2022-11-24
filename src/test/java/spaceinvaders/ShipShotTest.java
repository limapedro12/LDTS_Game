package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ShipShotTest {
    ShipShot shipShot;
    @BeforeEach
    public void helper() {
        shipShot = new ShipShot(new Position(2, 2));
    }

    @Test
    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        shipShot.draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).setCharacter(2, 2, TextCharacter.fromCharacter('^')[0]);
    }

    @Test
    public void update() {
        shipShot.update();
        assertEquals(1, shipShot.getPosition().getY());
    }

    @Test
    public void collideWith1() {
        Alien alien = Mockito.mock(Alien.class);
        shipShot.collideWith(alien);
        Mockito.when(alien.getX()).thenReturn(shipShot.getX());
        Mockito.when(alien.getY()).thenReturn(shipShot.getY());
        Mockito.when(alien.getWidth()).thenReturn(1);
        Mockito.when(alien.getHeight()).thenReturn(1);
        assertTrue(shipShot.collideWith(alien));
    }

    @Test
    public void collideWith2() {
        Alien alien = Mockito.mock(Alien.class);
        shipShot.collideWith(alien);
        Mockito.when(alien.getX()).thenReturn(shipShot.getX() + 1);
        Mockito.when(alien.getY()).thenReturn(shipShot.getY());
        Mockito.when(alien.getWidth()).thenReturn(1);
        Mockito.when(alien.getHeight()).thenReturn(1);
        assertFalse(shipShot.collideWith(alien));
    }

    @Test
    public void collideWith3() {
        Alien alien = Mockito.mock(Alien.class);
        shipShot.collideWith(alien);
        Mockito.when(alien.getX()).thenReturn(shipShot.getX());
        Mockito.when(alien.getY()).thenReturn(shipShot.getY() + 1);
        Mockito.when(alien.getWidth()).thenReturn(1);
        Mockito.when(alien.getHeight()).thenReturn(1);
        assertFalse(shipShot.collideWith(alien));
    }

    @Test
    public void isAlive(){
        assertFalse(shipShot.isAlive());
    }

    @Test
    public void getSpeed(){
        assertEquals(1, shipShot.getSpeed());
    }
}
