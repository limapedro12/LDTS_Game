package spaceinvaders.model;

import spaceinvaders.controller.ArenaController;
import spaceinvaders.controller.Controller;
import spaceinvaders.view.ArenaStateViewer;

public class ArenaStateModel implements RunStateModel{
    private ArenaModel model;
    private ArenaStateViewer viewer;
    public ArenaStateModel(ArenaModel model){
        this.model = model;
        this.viewer = new ArenaStateViewer(model.getViewer());
    }
    public void run(){
        model.run();
    }
    public ArenaStateViewer getViewer(){
        return viewer;
    }
    public Controller getController(){
        return new ArenaController(model);
    }
}
