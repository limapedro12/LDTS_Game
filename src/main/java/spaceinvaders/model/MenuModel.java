package spaceinvaders.model;

import spaceinvaders.view.MenuViewer;
import spaceinvaders.view.Viewer;

public abstract class MenuModel {
    protected Viewer viewer;

    public Viewer getViewer(){
        return viewer;
    }
}
