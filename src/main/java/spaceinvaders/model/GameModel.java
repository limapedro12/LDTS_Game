package spaceinvaders.model;

import spaceinvaders.model.menu.MainMenuModel;
import spaceinvaders.model.menu.MainMenuStateModel;
import spaceinvaders.model.menu.MenuModel;

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
