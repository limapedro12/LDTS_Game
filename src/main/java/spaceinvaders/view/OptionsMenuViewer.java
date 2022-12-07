package spaceinvaders.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.OptionsMenuModel;

public class OptionsMenuViewer implements MenuViewer {
    private static OptionsMenuViewer instance = null;
    private OptionsMenuModel model;

    private OptionsMenuViewer(OptionsMenuModel model) {
        this.model = model;
    }

    public static OptionsMenuViewer getInstance(OptionsMenuModel model) {
        if (instance == null) {
            instance = new OptionsMenuViewer(model);
        }
        return instance;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(20, 18, "Options");
        for (int i = 0; i < model.getCommands().size(); i++) {
            if (model.getCommands().get(i) != null) {
                if (i == model.getSelectedCommandInt()) {
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
                    graphics.putString(10, 20 + i, "> " + model.getCommands().get(i).getTitle());
                } else {
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
                    graphics.putString(10, 20 + i, model.getCommands().get(i).getTitle());
                }
            }
        }
    }
}
