package spaceinvaders;

import org.junit.jupiter.api.Test;
import spaceinvaders.model.PositionModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionModelTest {
    @Test
    public void testPositionModel() {
        PositionModel positionModel = new PositionModel(new PositionModel(1, 2));
        assertEquals(1, positionModel.getX());
        assertEquals(2, positionModel.getY());
    }
}
