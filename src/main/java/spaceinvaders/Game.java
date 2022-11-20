package spaceinvaders;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
public class Game {
    private int x = 10;
    private int y = 40;
    private Screen screen;
    private Arena arena;
    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(100, 50)).createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            arena = new Arena();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            arena.checkCollisions();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.EOF) break;
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                screen.stopScreen();
        }
    }

    private void processKey(com.googlecode.lanterna.input.KeyStroke key) {
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'a')
            x -= 2;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'd')
            x += 2;
        if (key.getKeyType() == KeyType.ArrowLeft)
            x -= 2;
        if (key.getKeyType() == KeyType.ArrowRight)
            x += 2;
    }
}
