package spaceinvaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.AlienGroupModel;
import spaceinvaders.view.AlienGroupViewer;

public class AlienGroupViewerTest {
    @Test
    public void drawTest() {

    }
    @Test
    public void getModelTest() {
        AlienGroupModel alienGroupModel = Mockito.mock(AlienGroupModel.class);
        AlienGroupViewer alienGroupViewer = new AlienGroupViewer(alienGroupModel);
        Assertions.assertEquals(alienGroupModel, alienGroupViewer.getModel());
    }
}
