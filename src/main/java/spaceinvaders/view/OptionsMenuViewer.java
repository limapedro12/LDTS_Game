package spaceinvaders.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.HighScoreMenuModel;
import spaceinvaders.model.OptionsMenuModel;

public class OptionsMenuViewer implements MenuViewer{
    private static OptionsMenuViewer instance = null;
    private OptionsMenuModel model;
    private OptionsMenuViewer(OptionsMenuModel model){
        this.model = model;
    }
    public static OptionsMenuViewer getInstance(OptionsMenuModel model){
        if(instance == null){
            instance = new OptionsMenuViewer(model);
        }
        return instance;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(40, 18, "Options");
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(40, 40, "> Exit");
    }
}
