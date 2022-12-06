package spaceinvaders.model;

import spaceinvaders.controller.Controller;
import spaceinvaders.view.RunStrategyViewer;

public interface RunStrategyModel {
    public void run();
    public RunStrategyViewer getViewer();
    public Controller getController();
}
