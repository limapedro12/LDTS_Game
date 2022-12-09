package spaceinvaders.view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.menu.InfoMenuModel;

public class InfoMenuViewer implements MenuViewer {
    private static InfoMenuViewer instance = null;
    private InfoMenuModel model;
    private InfoMenuViewer(InfoMenuModel model){
        this.model = model;
    }
    public static InfoMenuViewer getInstance(InfoMenuModel model){
        if(instance == null){
            instance = new InfoMenuViewer(model);
        }
        return instance;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(40, 18, "Info");
        graphics.putString(20, 20, "This Game was created by a group of 3 students");
        graphics.putString(20, 21, "who dream of becoming excellent computer engineers.");
        graphics.putString(20, 22, "We hope you enjoy our game!");
        graphics.putString(20, 23, "Help us by giving us a good grade!");
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(40, 40, "> Exit");
    }

    public static void reset() {
        instance = null;
    }
}
