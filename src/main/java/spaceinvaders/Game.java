package spaceinvaders;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import spaceinvaders.controller.GameController;
import spaceinvaders.model.GameModel;
import spaceinvaders.view.GameViewer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Game {
    static private GameModel model;
    static private GameController controller;
    static private GameViewer viewer;
    static private Screen screen;
    static private int width = 100;
    static private int height = 50;

    public static void main(String[] args) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        model = new GameModel();
        controller = new GameController(model, screen);
        viewer = new GameViewer(model, screen);

        run();


    }

    static public void run() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;
        while (true) {
            long startTime = System.currentTimeMillis();

            model.run();
            viewer.draw();
            if (!controller.processKey()) break;

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

    }
}
