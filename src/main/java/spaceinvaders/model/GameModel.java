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
    private RunStrategyModel strategy;
    private MenuModel menu;
    private ArenaModel arena;
    public GameModel() {
        menu = MainMenuModel.getInstance(this);
        arena = new ArenaModel();
        strategy = new MenuStrategyModel(menu);
        //strategy = new ArenaStrategyModel(arena);
    }

    public void run() throws IOException {
        strategy.run();
    }
    public void setStrategy(RunStrategyModel strategy) {
        this.strategy = strategy;
    }
    public RunStrategyModel getStrategy() {
        return strategy;
    }
    public ArenaModel getArenaModel() {
        return arena;
    }
}
