package spaceinvaders.model;

import spaceinvaders.controller.ArenaController;
import spaceinvaders.controller.ArenaStrategyController;
import spaceinvaders.controller.Controller;
import spaceinvaders.view.ArenaStrategyViewer;

public class ArenaStrategyModel implements RunStrategyModel{
    private ArenaModel model;
    private ArenaStrategyViewer viewer;
    public ArenaStrategyModel(ArenaModel model){
        this.model = model;
        this.viewer = new ArenaStrategyViewer(model.getViewer());
    }
    public void run(){
        model.run();
    }
    public ArenaStrategyViewer getViewer(){
        return viewer;
    }
    public Controller getController(){
        return new ArenaController(model);
    }
}
