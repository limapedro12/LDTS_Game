package spaceinvaders.model;

import spaceinvaders.view.MenuViewer;

public abstract class MenuModel {
    protected MenuViewer viewer;
    public MenuViewer getViewer(){
        return viewer;
    }
}
