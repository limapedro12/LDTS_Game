package spaceinvaders.model.menu;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.menu.HighScoreMenuController;
import spaceinvaders.model.RunStateModel;
import spaceinvaders.view.MenuStateViewer;
import spaceinvaders.view.RunStateViewer;

public class HighScoreMenuState implements RunStateModel {
    private HighScoreMenuModel model;
    private MenuStateViewer viewer;
    public HighScoreMenuState(HighScoreMenuModel model){
        this.model = model;
        this.viewer = new MenuStateViewer(model.getViewer());
    }
    public void run(){}

    @Override
    public RunStateViewer getViewer() {
        return viewer;
    }

    @Override
    public Controller getController() {
        return HighScoreMenuController.getInstance(model);
    }
}
