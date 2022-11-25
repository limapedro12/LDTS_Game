package spaceinvaders;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienTest {
    private Alien alien;
    private Position position;

    @BeforeEach
    public void helper(){
    this.alien = new Alien(new Position(20, 9), '&');
    this.position = new Position(20, 9);
    }

    @Test
    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        alien.draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).setCharacter(new TerminalPosition(20, 9), TextCharacter.fromCharacter('&')[0]);
    }

    @Test
    public void move1(){
        alien.move(new Position(1, 1));
        assertEquals(21,alien.getPosition().getX());
        assertEquals(10,alien.getPosition().getY());
    }
    @Test
    public void move2(){
        alien.move(new Position(-1, -1));
        assertEquals(19,alien.getPosition().getX());
        assertEquals(8,alien.getPosition().getY());
    }
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
}
