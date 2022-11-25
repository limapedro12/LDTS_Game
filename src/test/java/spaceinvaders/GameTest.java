package spaceinvaders;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameTest {

    private Screen screen;
    private Arena arena;

    private Game game;
    @BeforeEach
    public void helper(){
       game = new Game();
    }

    @Test
    private void draw() throws IOException {
        screen.clear();
       arena.draw(screen.newTextGraphics(), screen);
        screen.refresh();
        Mockito.verify(arena,Mockito.times(1)).draw(screen.newTextGraphics(), screen);
    }


}
