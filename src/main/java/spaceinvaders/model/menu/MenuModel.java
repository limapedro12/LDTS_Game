package spaceinvaders.model.menu;

import spaceinvaders.view.menu.MenuViewer;

public abstract class MenuModel {
    protected MenuViewer viewer;
    public MenuViewer getViewer(){
        return viewer;
    }
}
