package spaceinvaders.view;

import com.googlecode.lanterna.TextColor;
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
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(20, 18, "Space Invaders");
        for(int i = 0; i < model.getCommands().size(); i++){
            if(model.getCommands().get(i) != null){
                if(i == model.getSelectedCommandInt()){
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
                    graphics.putString(10, 20 + i, "> " + model.getCommands().get(i).getTitle());
                }else{
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
                    graphics.putString(10, 20 + i, model.getCommands().get(i).getTitle());
                }
            }
        }
    }
}
