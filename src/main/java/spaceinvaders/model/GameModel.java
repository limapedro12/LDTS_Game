package spaceinvaders.model;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class GameModel {
    private ArenaModel arena;
    public GameModel() {
        arena = new ArenaModel();
    }

    public void run() throws IOException {
        arena.run();
    }

    public ArenaModel getArenaModel() {
        return arena;
    }
}
