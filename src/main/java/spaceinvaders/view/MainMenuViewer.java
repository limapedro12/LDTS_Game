package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.MainMenuModel;
import spaceinvaders.model.MenuModel;

public class MainMenuViewer implements MenuViewer {
    private MainMenuModel model;
    private static MenuViewer instance = null;
    private MainMenuViewer(MainMenuModel model){
        this.model = model;
    }
    public static MainMenuViewer getInstance(MainMenuModel model){
        if(instance == null){
            instance = new MainMenuViewer(model);
        }
        return (MainMenuViewer) instance;
    }
    public static MenuViewer getInstance(){
        return instance;
    }
    public void draw(TextGraphics graphics){
        for(int i = 0; i < model.getCommands().length; i++){
            graphics.putString(0, 10 + i, model.getCommands()[i].getTitle());
        }
    }
}
