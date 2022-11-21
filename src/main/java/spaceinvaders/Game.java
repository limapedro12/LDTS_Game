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
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int x = 10;
    private int y = 40;
    private Ship ship;
    private List<Alien> aliens;
    private Screen screen;
    private Arena arena;
    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(100, 50)).createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            ship = new Ship();
            createAliens();
            arena = new Arena();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAliens() {
        aliens = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                Alien a = new Alien(new Position(13 + 8 * j, 5 + 4 * i));
                aliens.add(a);
            }
        }
    }
    private void draw() throws IOException {
        screen.clear();
        ship.draw(this.screen);
        for (Alien a :aliens){
            a.draw(screen);
        }
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            arena.checkCollisions();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.EOF) break;
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                screen.stopScreen();
            ship.processKey(key, screen);
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
