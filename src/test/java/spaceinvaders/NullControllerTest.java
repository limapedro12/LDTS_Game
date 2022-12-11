package spaceinvaders;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.controller.NullController;

public class NullControllerTest {
    @Test
    public void processKeyTest() {
        NullController nullController = new NullController();
    }
}
