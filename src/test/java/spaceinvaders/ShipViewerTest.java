package spaceinvaders;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.ShipModel;
import spaceinvaders.view.ShipViewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ShipViewerTest {
    @Test
    public void drawTest() {
        ShipModel model = new ShipModel();
        ShipViewer ship = new ShipViewer(model);
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        ship.draw(graphics);
        verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        verify(graphics, Mockito.times(1)).putString(model.getX(), model.getUpperBound(),"\"");
        verify(graphics, Mockito.times(1)).putString(model.getRightBound(), model.getUpperBound()+1,",");
        for (int i = model.getLeftBound()+1; i <= model.getRightBound()-1; i++)
            verify(graphics, Mockito.times(1)).putString(i, model.getUpperBound()+1, "=");
        for (int i = model.getLeftBound(); i <= model.getRightBound(); i++)
            verify(graphics, Mockito.times(1)).putString(i, model.getUpperBound()+2,"=");

    }
    @Test
    public void getModelTest() {
        ShipModel model = new ShipModel();
        ShipViewer ship = new ShipViewer(model);
        assertEquals(model, ship.getModel());
    }
}