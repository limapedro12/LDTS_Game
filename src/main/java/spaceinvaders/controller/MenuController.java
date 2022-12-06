package spaceinvaders.controller;

import spaceinvaders.model.MenuModel;

public class MenuController {
    private MenuModel model;
    private static MenuController instance = null;
    private MenuController(MenuModel model){
        this.model = model;
    }
    public static MenuController getInstance(MenuModel model){
        if(instance == null){
            instance = new MenuController(model);
        }
        return instance;
    }
    public static MenuController getInstance(){
        return instance;
    }
}
