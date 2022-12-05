package spaceinvaders;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.PositionModel;
import spaceinvaders.model.ProtectionModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProtectionTest {
    ProtectionModel protection;
    @BeforeEach
    public void helper() {
        protection = new ProtectionModel(new PositionModel(2, 2), 2);
    }
    @Test

    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        protection.getViewer().draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).drawRectangle(new TerminalPosition(2, 2), new TerminalSize(8, 3), TextCharacter.fromCharacter('#')[0]);
        Mockito.verify(graphics, Mockito.times(1)).drawRectangle(new TerminalPosition(2 + 1, 2 + 3 - 1), new TerminalSize(8-2, 1), TextCharacter.fromCharacter('\'')[0]);
        Mockito.verify(graphics, Mockito.times(1)).setCharacter(2 + 8/2 - 1, 2 + 1, TextCharacter.fromCharacter((char) ((char) 2 / 10 + '0'))[0]);
        Mockito.verify(graphics, Mockito.times(1)).setCharacter(2 + 8/2, 2 + 1, TextCharacter.fromCharacter((char) ((char) 2 % 10 + '0'))[0]);
    }

    @Test
    public void getWidth() {
        assertEquals(8, protection.getWidth());
    }

    @Test
    public void getHeight() {
        assertEquals(3, protection.getHeight());
    }

    @Test
    public void damage() {
        protection.damage();
        assertEquals(1, protection.getLife());
    }

    @Test
    public void isAlive() {
        assertEquals(true, protection.isAlive());
        protection.damage();
        assertEquals(true, protection.isAlive());
        protection.damage();
        assertEquals(false, protection.isAlive());
    }
}
