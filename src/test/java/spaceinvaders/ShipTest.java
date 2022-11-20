package spaceinvaders;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShipTest {
    private Ship ship;
    @BeforeEach
    private void helper() {
        this.ship = new Ship();
        Screen screen = Mockito.mock(Screen.class);
    }
    @Test
    public void canIMoveTest() {
        Assertions.assertEquals(true, ship.canIMove(-1));
    }
}
