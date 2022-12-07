package spaceinvaders.model.menu;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.menu.OptionsMenuController;
import spaceinvaders.model.RunStateModel;
import spaceinvaders.view.MenuStateViewer;
import spaceinvaders.view.RunStateViewer;

public class OptionsMenuState implements RunStateModel {
    private OptionsMenuModel model;
    private MenuStateViewer viewer;
    public OptionsMenuState(OptionsMenuModel model){
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
        return OptionsMenuController.getInstance(model);
    }
}
