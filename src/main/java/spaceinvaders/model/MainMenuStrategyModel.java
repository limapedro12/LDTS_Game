package spaceinvaders.model;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.MainMenuController;
import spaceinvaders.view.MenuStrategyViewer;
import spaceinvaders.view.RunStrategyViewer;

public class MainMenuStrategyModel implements RunStrategyModel{
    private MainMenuModel model;
    private MenuStrategyViewer viewer;
    public MainMenuStrategyModel(MainMenuModel model){
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
        return MainMenuController.getInstance(model);
    }
}
