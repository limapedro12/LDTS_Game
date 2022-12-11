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
import spaceinvaders.view.AlienShotViewer;

import static org.junit.jupiter.api.Assertions.*;

public class AlienShotTest {
    AlienShotModel alienShot;
    AlienShotViewer alienShotViewer;
    @BeforeEach
    public void helper() {
        alienShot = new AlienShotModel(new PositionModel(2, 2),1);
        alienShotViewer = new AlienShotViewer(alienShot);
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
    public void isAlive(){
        assertFalse(alienShot.isAlive());
    }

    @Test
    public void getSpeed(){
        assertEquals(1, alienShot.getSpeed());
    }


}
