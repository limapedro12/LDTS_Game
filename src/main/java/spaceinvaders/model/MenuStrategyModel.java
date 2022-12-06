package spaceinvaders.model;

import spaceinvaders.view.MenuStrategyViewer;
import spaceinvaders.view.RunStrategyViewer;

public class MenuStrategyModel implements RunStrategyModel{
    private MenuModel model;
    private MenuStrategyViewer viewer;
    public MenuStrategyModel(MenuModel model){
        this.model = model;
        this.viewer = new MenuStrategyViewer(model.getViewer());
    }
    public void run(){}

    @Override
    public RunStrategyViewer getViewer() {
        return viewer;
    }
}
