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
    public void move(){
        this.position.setX(position.getX()+1);
        this.position.setY(position.getY()+1);
        assertEquals(21,position.getX());
        assertEquals(10,position.getY());
        this.position.setX(position.getX()-2);
        this.position.setY(position.getY()-2);
        assertEquals(19,position.getX());
        assertEquals(8,position.getY());
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

}
