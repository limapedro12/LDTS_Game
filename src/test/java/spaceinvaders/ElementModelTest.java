package spaceinvaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.AlienModel;
import spaceinvaders.model.ElementModel;
import spaceinvaders.model.PositionModel;
import spaceinvaders.model.ProtectionModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementModelTest {
@Test
    public void getPositionTest() {
        ElementModel element = new AlienModel(new PositionModel(10, 10),"&","#FFFFFF");
        assertEquals(10, element.getPosition().getX());
        assertEquals(10, element.getPosition().getY());
    }
      @Test
    public void moveTest() {
        ElementModel element = new AlienModel(new PositionModel(10, 10),"&","#FFFFFF");
        element.move(0);
        assertEquals(9, element.getPosition().getX());
        assertEquals(10, element.getPosition().getY());
    }
    @Test
    public void moveTest2() {
        ElementModel element = new AlienModel(new PositionModel(10, 10),"&","#FFFFFF");
        element.move(1);
        assertEquals(11, element.getPosition().getX());
        assertEquals(10, element.getPosition().getY());
    }

    @Test
    public void moveTest3() {
        ElementModel element = new AlienModel(new PositionModel(10, 10),"&","#FFFFFF");
        element.move(2);
        assertEquals(10, element.getPosition().getX());
        assertEquals(11, element.getPosition().getY());
    }

}
