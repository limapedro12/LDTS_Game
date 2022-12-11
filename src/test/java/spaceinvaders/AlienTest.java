package spaceinvaders;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class AlienTest {
    private AlienModel alien;

    @BeforeEach
    public void helper(){
    this.alien = new AlienModel(new PositionModel(20, 9), "&","#FFFFFF");
    }

    @Test
    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        alien.getViewer().draw(graphics);
        Mockito.verify(graphics).setForegroundColor(TextColor.Factory.fromString(alien.getColor()));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(20, 9), alien.getSymbol());
    }

    @Test
    public void getModel() {
        assertEquals(alien, alien.getViewer().getModel());
    }

    /*@Test
    public void move1(){
        alien.move(new PositionModel(1, 1));
        assertEquals(21,alien.getPosition().getX());
        assertEquals(10,alien.getPosition().getY());
    }
    @Test
    public void move2(){
        alien.move(new PositionModel(-1, -1));
        assertEquals(19,alien.getPosition().getX());
        assertEquals(8,alien.getPosition().getY());
    }*/
    @Test
    public void damage() {
        alien.damage();
        assertEquals(false, alien.isAlive());
    }

    @Test
    public void isAlive() {
        assertEquals(true,alien.isAlive());
        alien.damage();
        assertEquals(false,alien.isAlive());

    }

    @Test
    public void getWidth() {
        assertEquals(1,alien.getWidth());
    }

    @Test
    public void getHeight() {
        assertEquals(1,alien.getHeight());
    }

    @Test
public void getSymbol() {
        assertEquals("&",alien.getSymbol());
    }

    @Test
public void getColor() {
        assertEquals("#FFFFFF",alien.getColor());
    }

    @Test
    public void collideWith() {
        assertEquals(true, alien.collideWith( new ShipShotModel(new PositionModel(20, 9))));
    }

    @Test
    public void collideWith2() {
        assertEquals(false, alien.collideWith( new ShipShotModel(new PositionModel(20, 10))));
    }

    @Test
    public void fireTest() {
        ShotObserverModel observer = Mockito.mock(ShotObserverModel.class);
        alien.addObserver(observer);
        alien.fire(1);
        verify(observer, Mockito.times(1)).update(any(AlienShotModel.class));
    }

}
