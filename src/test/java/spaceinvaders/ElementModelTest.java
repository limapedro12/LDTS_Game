package spaceinvaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.*;
import spaceinvaders.view.ElementViewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ElementModelTest {
    @Test
    public void getX() {
        ElementModel elementModel = new ProtectionModel(new PositionModel(1, 2), 3);
        assertEquals(1, elementModel.getX());
    }

    @Test
    public void getY() {
        ElementModel elementModel = new ProtectionModel(new PositionModel(1, 2), 3);
        assertEquals(2, elementModel.getY());
    }

    @Test
    public void getPosition() {
        ElementModel elementModel = new ProtectionModel(new PositionModel(1, 2), 3);
        assertEquals(1, elementModel.getPosition().getX());
        assertEquals(2, elementModel.getPosition().getY());
    }

    @Test
    public void getHeight() {
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        assertEquals(1, elementModel.getHeight());
    }

    @Test
    public void getWidth() {
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        assertEquals(1, elementModel.getWidth());
    }

    @Test
    public void getViewer() {
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        ElementViewer elementViewer = Mockito.mock(ElementViewer.class);
        elementModel.setViewer(elementViewer);
        assertEquals(elementViewer, elementModel.getViewer());
    }

    @Test
    public void isTangible() {
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        assertEquals(true, elementModel.isTangible());
    }

    @Test
    public void canIMove() {
        ElementModel elementModel = new AlienModel(new PositionModel(-1, 2), "P", "FFFFFF");
        assertEquals(false, elementModel.canIMove(true));
        assertEquals(true, elementModel.canIMove(false));
    }

    @Test
    public void canIMove2() {
        ElementModel elementModel = new AlienModel(new PositionModel(100, 2), "P", "FFFFFF");
        assertEquals(true, elementModel.canIMove(true));
        assertEquals(false, elementModel.canIMove(false));
    }

    @Test
    public void addObserver() {
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        ShotObserverModel shotObserverModel = Mockito.mock(ShotObserverModel.class);
        elementModel.clearObservers();
        elementModel.addObserver(shotObserverModel);
        assertEquals(1, elementModel.getObservers().size());
        assert (elementModel.getObservers().contains(shotObserverModel));
    }

    @Test
    public void removeObserver() {
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        ShotObserverModel shotObserverModel = Mockito.mock(ShotObserverModel.class);
        elementModel.clearObservers();
        elementModel.addObserver(shotObserverModel);
        elementModel.removeObserver(shotObserverModel);
        assertEquals(0, elementModel.getObservers().size());
        assertFalse(elementModel.getObservers().contains(shotObserverModel));
    }

    @Test
    public void notifyObservers(){
        ShotModel shotModel = Mockito.mock(ShotModel.class);
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        ShotObserverModel shotObserverModel = Mockito.mock(ShotObserverModel.class);
        elementModel.addObserver(shotObserverModel);
        elementModel.notifyObservers(shotModel);
        Mockito.verify(shotObserverModel, Mockito.times(1)).update(shotModel);
    }

    @Test
    public void collideWith(){
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        ShotModel shotModel = Mockito.mock(ShotModel.class);
        Mockito.when(shotModel.getX()).thenReturn(1);
        Mockito.when(shotModel.getY()).thenReturn(2);
        assert(elementModel.collideWith(shotModel));
    }

    @Test
    public void collideWith2(){
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        ShotModel shotModel = Mockito.mock(ShotModel.class);
        Mockito.when(shotModel.getX()).thenReturn(3);
        Mockito.when(shotModel.getY()).thenReturn(2);
        assertFalse(elementModel.collideWith(shotModel));
    }

    @Test
    public void collideWith3(){
        ElementModel elementModel = new ProtectionModel(new PositionModel(1, 2), 3);
        ShotModel shotModel = Mockito.mock(ShotModel.class);
        Mockito.when(shotModel.getX()).thenReturn(2);
        Mockito.when(shotModel.getY()).thenReturn(3);
        assert(elementModel.collideWith(shotModel));
    }

    @Test
    public void moveLeft(){
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        int oldX = elementModel.getX();
        elementModel.move(0);
        assertEquals(oldX - 1, elementModel.getX());
    }

    @Test
    public void moveRight(){
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        int oldX = elementModel.getX();
        elementModel.move(1);
        assertEquals(oldX + 1, elementModel.getX());
    }

    @Test
    public void moveDown(){
        ElementModel elementModel = new AlienModel(new PositionModel(1, 2), "P", "FFFFFF");
        int oldY = elementModel.getY();
        elementModel.move(2);
        assertEquals(oldY + 1, elementModel.getY());
    }
}
