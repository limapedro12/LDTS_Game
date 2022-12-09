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
        graphics.putString(20, 13, "Controls");
        graphics.putString(13, 15, "Move left: A or Left Arrow");
        graphics.putString(13, 16, "Move right: D or Right Arrow");
        graphics.putString(13, 17, "Shoot: Space or Up Arrow");
        graphics.putString(13, 18, "Back: Q or ESC key");
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(13, 25, "> Exit");
    }
}
