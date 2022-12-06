package spaceinvaders.model;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.HighScoreMenuController;
import spaceinvaders.controller.MainMenuController;
import spaceinvaders.controller.NullController;
import spaceinvaders.view.HighScoreMenuViewer;
import spaceinvaders.view.MenuStrategyViewer;
import spaceinvaders.view.RunStrategyViewer;

public class HighScoreMenuStrategy implements RunStrategyModel{
    private HighScoreMenuModel model;
    private MenuStrategyViewer viewer;
    public HighScoreMenuStrategy(HighScoreMenuModel model){
        this.model = model;
        this.viewer = new MenuStrategyViewer(model.getViewer());
    }
    public void run(){}

    @Override
    public RunStrategyViewer getViewer() {
        return viewer;
    }

    @Override
    public Controller getController() {
        return HighScoreMenuController.getInstance(model);
    }
}
