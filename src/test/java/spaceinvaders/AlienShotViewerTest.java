package spaceinvaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.AlienShotModel;
import spaceinvaders.view.AlienShotViewer;

public class AlienShotViewerTest {
    @Test
    public void alienShotViewer() {
        AlienShotModel shotModel = Mockito.mock(AlienShotModel.class);
        AlienShotViewer alienShotViewer = new AlienShotViewer(shotModel);
        Assertions.assertEquals(shotModel, alienShotViewer.getModel());
    }
}
