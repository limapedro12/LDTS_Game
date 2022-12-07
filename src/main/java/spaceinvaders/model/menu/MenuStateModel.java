package spaceinvaders.model.menu;

import spaceinvaders.controller.Controller;
import spaceinvaders.model.RunStateModel;
import spaceinvaders.view.RunStateViewer;
import spaceinvaders.view.menu.MenuStateViewer;

import java.awt.*;

public class MenuStateModel implements RunStateModel {
    private MenuModel model;
    private Controller controller;
    private MenuStateViewer viewer;
    public MenuStateModel(MenuModel model, Controller controller){
        this.model = model;
        this.controller = controller;
        this.viewer = new MenuStateViewer(model.getViewer());
    }
    public void run(){}

    @Override
    public RunStateViewer getViewer() {
        return viewer;
    }

    @Override
    public Controller getController() {
        return controller;
    }
}
