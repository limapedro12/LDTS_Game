package spaceinvaders;

import org.junit.jupiter.api.Test;
import spaceinvaders.model.PositionModel;
import spaceinvaders.model.ShotModel;
import spaceinvaders.view.ShotViewer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShotViewerTest {
    @Test
    public void getModelTest() {
        ShotModel shotModel = new ShotModel(new PositionModel(1,2), 2,true, 'a');
        ShotViewer shotViewer = new ShotViewer(shotModel);
        assertEquals(shotModel, shotViewer.getModel());

    }
}
