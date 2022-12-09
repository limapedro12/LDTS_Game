package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.AlienModel;
import spaceinvaders.model.PositionModel;
import spaceinvaders.model.ShipShotModel;

import static org.junit.jupiter.api.Assertions.*;

public class ShipShotTest {
    ShipShotModel shipShot;
    @BeforeEach
    public void helper() {
        shipShot = new ShipShotModel(new PositionModel(2, 2));
    }

    @Test
    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        shipShot.getViewer().draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).setCharacter(2, 2, TextCharacter.fromCharacter('^')[0]);
    }

    @Test
    public void update() {
        shipShot.update();
        assertEquals(1, shipShot.getPosition().getY());
    }


    @Test
    public void isAlive(){
        assertFalse(shipShot.isAlive());
    }

    @Test
    public void getSpeed(){
        assertEquals(1, shipShot.getSpeed());
    }

    @Test
    public void getCharacter(){
        assertEquals('^', shipShot.getCharacter());
    }

    @Test
    public void isTangible(){
        assertFalse(shipShot.isTangible());
    }

}
