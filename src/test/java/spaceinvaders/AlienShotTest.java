package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class AlienShotTest {
    AlienShot alienShot;
    @BeforeEach
    public void helper() {
        alienShot = new AlienShot(new Position(2, 2));
    }

    @Test
    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        alienShot.draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).setCharacter(2, 2, TextCharacter.fromCharacter('v')[0]);
    }

    @Test
    public void update() {
        alienShot.update();
        assertEquals(3, alienShot.getPosition().getY());
    }

    @Test
    public void collideWith1() {
        Ship ship = Mockito.mock(Ship.class);
        alienShot.collideWith(ship);
        Mockito.when(ship.getX()).thenReturn(alienShot.getX());
        Mockito.when(ship.getY()).thenReturn(alienShot.getY());
        Mockito.when(ship.getWidth()).thenReturn(1);
        Mockito.when(ship.getHeight()).thenReturn(1);
        assertTrue(alienShot.collideWith(ship));
    }

    @Test
    public void collideWith2() {
        Ship ship = Mockito.mock(Ship.class);
        alienShot.collideWith(ship);
        Mockito.when(ship.getX()).thenReturn(alienShot.getX() + 1);
        Mockito.when(ship.getY()).thenReturn(alienShot.getY());
        Mockito.when(ship.getWidth()).thenReturn(1);
        Mockito.when(ship.getHeight()).thenReturn(1);
        assertFalse(alienShot.collideWith(ship));
    }

    @Test
    public void collideWith3() {
        Ship ship = Mockito.mock(Ship.class);
        alienShot.collideWith(ship);
        Mockito.when(ship.getX()).thenReturn(alienShot.getX());
        Mockito.when(ship.getY()).thenReturn(alienShot.getY() + 1);
        Mockito.when(ship.getWidth()).thenReturn(1);
        Mockito.when(ship.getHeight()).thenReturn(1);
        assertFalse(alienShot.collideWith(ship));
    }

    @Test
    public void isAlive(){
        assertFalse(alienShot.isAlive());
    }

    @Test
    public void getSpeed(){
        assertEquals(1, alienShot.getSpeed());
    }
}
