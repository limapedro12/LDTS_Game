package spaceinvaders.model.menu;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.menu.MainMenuController;
import spaceinvaders.model.RunStateModel;
import spaceinvaders.view.MenuStateViewer;
import spaceinvaders.view.RunStateViewer;

public class MainMenuStateModel implements RunStateModel {
    private MainMenuModel model;
    private MenuStateViewer viewer;
    public MainMenuStateModel(MainMenuModel model){
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
        return MainMenuController.getInstance(model);
    }
}
