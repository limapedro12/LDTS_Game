package spaceinvaders.model;

import spaceinvaders.controller.menu.MainMenuController;
import spaceinvaders.model.menu.MainMenuModel;
import spaceinvaders.model.menu.MenuModel;
import spaceinvaders.model.menu.MenuStateModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GameModel {
    private RunStateModel state;
    public GameModel() {
        MainMenuModel menu = MainMenuModel.getInstance(this);
        state = new MenuStateModel(menu, MainMenuController.getInstance(menu));
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
}
