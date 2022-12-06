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
    private RunStateModel state;
    private MenuModel menu;
    private ArenaModel arena;
    public GameModel() {
        menu = MainMenuModel.getInstance(this);
        //arena = new ArenaModel();
        state = new MainMenuStateModel((MainMenuModel) menu);
        //state = new ArenaStateModel(arena);
    }

    public void run() throws IOException {
        state.run();
    }
    public void setState(RunStateModel state) {
        this.state = state;
    }
    public RunStateModel getState() {
        return state;
    }
    //public ArenaModel getArenaModel() {
//        return arena;
//    }
}
