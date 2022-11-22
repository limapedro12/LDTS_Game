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
    int width = 100;
    int height = 50;
    private Screen screen;
    private Arena arena;
    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
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
        arena.draw(screen.newTextGraphics(), screen);
        screen.refresh();
    }

    public void run() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (true) {
            long startTime = System.currentTimeMillis();

            draw();
            arena.checkCollisions();
            if(!processKey()) break;

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean processKey() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key == null) return true;
        if (key.getKeyType() == KeyType.EOF) return false;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
            screen.stopScreen();
        arena.processKey(key, screen);
        return true;
    }
}
