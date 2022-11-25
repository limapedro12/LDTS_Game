package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class ArenaTest {
    Arena arena;
    @BeforeEach
    public void helper() {
        arena = new Arena();
    }

    @Test
    public void update(){
        Shot shot = Mockito.mock(Shot.class);
        assertEquals(arena .getShots().size(), 0);
        arena.update(shot);
        assertEquals(arena.getShots().size(), 1);
    }
    
    @Test
    public void createAliens(){
        assertEquals(50, arena.getAliens().size());
        arena.createAliens();
        assertEquals(100, arena.getAliens().size());
        assertEquals(104, arena.getElements().size());
    }
    
    @Test
    public void draw1(){
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        Element element = Mockito.mock(Element.class);
        arena.getElements().add(element);
        arena.draw(graphics);
        Mockito.verify(element, Mockito.times(1)).draw(graphics);
        Mockito.verify(element, Mockito.times(1)).isAlive();
    }

    @Test
    public void draw2(){
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        Shot shot = Mockito.mock(Shot.class);
        arena.getShots().add(shot);
        arena.draw(graphics);
        Mockito.verify(shot, Mockito.times(1)).draw(graphics);
        Mockito.verify(shot, Mockito.times(1)).update();
    }

    @Test
    public void checkCollisions(){
        Shot shot = Mockito.mock(Shot.class);
        Mockito.when(shot.collideWith(any())).thenReturn(true);
        arena.getShots().add(shot);
        Element element = Mockito.mock(Element.class);
        arena.getElements().add(element);
        arena.checkCollisions();
        Mockito.verify(shot, Mockito.atLeast(1)).collideWith(any());
        Mockito.verify(element, Mockito.times(1)).damage();
        assertEquals(0, arena.getShots().size());
    }

    @Test
    public void processKey1(){
        arena.processKey(new KeyStroke('a', false, false));
        assertEquals(49, arena.getShip().getX());
    }

    @Test
    public void processKey2(){
        arena.processKey(new KeyStroke('d', false, false));
        assertEquals(51, arena.getShip().getX());
    }

    @Test
    public void processKey3(){
        arena.processKey(new KeyStroke(' ', false, false));
        assertEquals(1, arena.getShots().size());
    }

    @Test
    public void processKey4(){
        arena.processKey(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(49, arena.getShip().getX());
    }

    @Test
    public void processKey5(){
        arena.processKey(new KeyStroke(KeyType.ArrowRight));
        assertEquals(51, arena.getShip().getX());
    }

    @Test
    public void processKey6(){
        arena.processKey(new KeyStroke(KeyType.ArrowUp));
        assertEquals(1, arena.getShots().size());
    }
}
