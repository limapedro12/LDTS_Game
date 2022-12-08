package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.AlienShotModel;
import spaceinvaders.model.ElementModel;
import spaceinvaders.model.PositionModel;
import spaceinvaders.model.ShipModel;

import static org.junit.jupiter.api.Assertions.*;

public class AlienShotTest {
    AlienShotModel alienShot;
    @BeforeEach
    public void helper() {
        alienShot = new AlienShotModel(new PositionModel(2, 2),1);
    }

    @Test
    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        alienShot.getViewer().draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).setCharacter(2, 2, TextCharacter.fromCharacter('_')[0]);
    }

    @Test
    public void update() {
        alienShot.update();
        assertEquals(3, alienShot.getPosition().getY());
    }

    @Test
    public void collideWith1() {
        ShipModel ship = Mockito.mock(ShipModel.class);
        ship.collideWith(alienShot);
        Mockito.when(ship.getX()).thenReturn(alienShot.getX());
        Mockito.when(ship.getY()).thenReturn(alienShot.getY());
        Mockito.when(ship.getWidth()).thenReturn(1);
        Mockito.when(ship.getHeight()).thenReturn(1);
        assertTrue(ship.collideWith(alienShot));
    }

    @Test
    public void collideWith2() {
        ShipModel ship = Mockito.mock(ShipModel.class);
        ship.collideWith(alienShot);
        Mockito.when(ship.getX()).thenReturn(alienShot.getX() + 1);
        Mockito.when(ship.getY()).thenReturn(alienShot.getY());
        Mockito.when(ship.getWidth()).thenReturn(1);
        Mockito.when(ship.getHeight()).thenReturn(1);
        assertFalse(ship.collideWith(alienShot));
    }

    @Test
    public void collideWith3() {
        ShipModel ship = Mockito.mock(ShipModel.class);
        ship.collideWith(alienShot);
        Mockito.when(ship.getX()).thenReturn(alienShot.getX());
        Mockito.when(ship.getY()).thenReturn(alienShot.getY() + 1);
        Mockito.when(ship.getWidth()).thenReturn(1);
        Mockito.when(ship.getHeight()).thenReturn(1);
        assertFalse(ship.collideWith(alienShot));
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
