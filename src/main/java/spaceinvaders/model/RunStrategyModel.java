package spaceinvaders.model;

import spaceinvaders.view.RunStrategyViewer;

public interface RunStrategyModel {
    public void run();
    public RunStrategyViewer getViewer();
}
