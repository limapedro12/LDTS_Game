package spaceinvaders.view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.menu.ControlsMenuModel;

public class ControlsMenuViewer implements MenuViewer {
    private static ControlsMenuViewer instance = null;
    private ControlsMenuModel model;
    private ControlsMenuViewer(ControlsMenuModel model){
        this.model = model;
    }
    public static ControlsMenuViewer getInstance(ControlsMenuModel model){
        if(instance == null){
            instance = new ControlsMenuViewer(model);
        }
        return instance;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(40, 18, "Controls");
        graphics.putString(30, 20, "Move left: A or Left Arrow");
        graphics.putString(30, 21, "Move right: D or Right Arrow");
        graphics.putString(30, 22, "Shoot: Space or Up Arrow");
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(40, 40, "> Exit");
    }

    public static void reset(){
        instance = null;
    }
}
