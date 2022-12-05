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
import spaceinvaders.model.ArenaModel;

import java.io.IOException;

public class GameTest {

    private Screen screen;
    private ArenaModel arena;

    private Game game;
    @BeforeEach
    public void helper(){
       game = new Game();
    }

    @Test
    public void draw() throws IOException {
        arena = Mockito.mock(ArenaModel.class);
        screen = Mockito.mock(Screen.class);
        screen.clear();
        arena.getViewer().draw(screen.newTextGraphics());
        screen.refresh();
        Mockito.verify(arena,Mockito.times(1)).getViewer().draw(screen.newTextGraphics());
    }


}
