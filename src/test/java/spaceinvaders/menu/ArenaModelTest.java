package spaceinvaders.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.PlayerScore;
import spaceinvaders.model.*;
import spaceinvaders.model.menu.Command;
import spaceinvaders.view.ArenaViewer;

import javax.sound.sampled.Clip;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaModelTest {
    private GameModel gameModel;
    private ArenaModel arena;
    @BeforeEach
    public void helper() {
        gameModel = Mockito.mock(GameModel.class);
        arena = new ArenaModel(gameModel);
    }

    @Test
    public void getLevelTest() {
        arena.getLevel();
        assertEquals(arena.getLevel(), 1);
    }

    @Test
    public void getLevelTest2() {
        arena = new ArenaModel(gameModel, 42);
        arena.getLevel();
        assertEquals(arena.getLevel(), 42);
    }

    @Test
    public void getExitCommandTest() {
        Command exitCommand = Mockito.mock(Command.class);
        arena.setExitCommand(exitCommand);
        assertEquals(arena.getExitCommand(), exitCommand);
    }

    @Test
    public void updateTest() {
        ShotModel shotMock = Mockito.mock(ShotModel.class);
        arena.update(shotMock);
        assertEquals(arena.getShots().size(), 1);
        assertEquals(arena.getShots().get(0), shotMock);
    }

    @Test
    public void runTest() {
        arena.setTargetTime(0);
        AlienGroupModel alienGroupMock = Mockito.mock(AlienGroupModel.class);
        arena.setAliens(alienGroupMock);
        arena.run();
        assertEquals(arena.getHasRan(), true);
        Mockito.verify(alienGroupMock, Mockito.times(1)).fire(Mockito.anyFloat());
    }

    @Test
    public void runTest2() {
        List aliens = new ArrayList();
        AlienGroupModel alienGroupMock = Mockito.mock(AlienGroupModel.class);
        Mockito.when(alienGroupMock.getAliens()).thenReturn(aliens);
        arena.setAliens(alienGroupMock);
        arena.run();
        assertEquals(arena.getHasRan(), true);
        assertEquals(arena.getYouWon(), true);
    }

    @Test
    public void runTest3() {
        arena.setYouWon(true);
        arena.setYouWonTime(0);
        arena.run();
        assertEquals(arena.getHasRan(), true);
        assertEquals(arena.getYouWon(), false);
    }

    @Test
    public void runTest4() {
        ProtectionModel protectionMock = Mockito.mock(ProtectionModel.class);
        arena.addProtection(protectionMock);
        List aliens = new ArrayList();
        aliens.add(new AlienModel(new PositionModel(0, 100), "P", "FFFFFF"));
        AlienGroupModel alienGroupMock = Mockito.mock(AlienGroupModel.class);
        Mockito.when(alienGroupMock.getAliens()).thenReturn(aliens);
        arena.setAliens(alienGroupMock);
        arena.run();
        Mockito.verify(protectionMock, Mockito.times(1)).kill();
    }

    @Test
    public void runTest5() {
        ShipModel shipMock = Mockito.mock(ShipModel.class);
        Mockito.when(shipMock.isAlive()).thenReturn(false);
        arena.setShip(shipMock);
        arena.run();
        Assertions.assertTrue(arena.isLost());
        Mockito.verify(gameModel, Mockito.times(1)).setState(Mockito.any());
    }

    @Test
    public void moveAliensTest() {
        arena.setLastAlienDirection(0);
        AlienGroupModel alienGroupMock = Mockito.mock(AlienGroupModel.class);
        Mockito.when(alienGroupMock.canIMove(true)).thenReturn(true);
        arena.setAliens(alienGroupMock);
        arena.moveAliens();
        Mockito.verify(alienGroupMock, Mockito.times(1)).move(0);
    }

    @Test
    public void moveAliensTest2() {
        arena.setLastAlienDirection(0);
        AlienGroupModel alienGroupMock = Mockito.mock(AlienGroupModel.class);
        Mockito.when(alienGroupMock.canIMove(true)).thenReturn(false);
        arena.setAliens(alienGroupMock);
        arena.moveAliens();
        Mockito.verify(alienGroupMock, Mockito.times(1)).move(2);
        Mockito.verify(alienGroupMock, Mockito.times(1)).move(1);
        assertEquals(arena.getLastAlienDirection(), 1);
    }

    @Test
    public void moveAliensTest3() {
        arena.setLastAlienDirection(1);
        AlienGroupModel alienGroupMock = Mockito.mock(AlienGroupModel.class);
        Mockito.when(alienGroupMock.canIMove(false)).thenReturn(true);
        arena.setAliens(alienGroupMock);
        arena.moveAliens();
        Mockito.verify(alienGroupMock, Mockito.times(1)).move(1);
    }

    @Test
    public void moveAliensTest4() {
        arena.setLastAlienDirection(1);
        AlienGroupModel alienGroupMock = Mockito.mock(AlienGroupModel.class);
        Mockito.when(alienGroupMock.canIMove(false)).thenReturn(false);
        arena.setAliens(alienGroupMock);
        arena.moveAliens();
        Mockito.verify(alienGroupMock, Mockito.times(1)).move(2);
        Mockito.verify(alienGroupMock, Mockito.times(1)).move(0);
        assertEquals(arena.getLastAlienDirection(), 0);
    }

    @Test
    public void incrementLevelTest() {
        arena.incrementLevel();
        assertEquals(arena.getLevel(), 2);
        assertEquals(arena.getElements().size(), 5);
        assertEquals(arena.getProtections().size(), 3);
        for(ProtectionModel protection : arena.getProtections()) {
            assertEquals(protection.getLife(), 29);
        }
    }

    @Test
    public void levelConstructorTest() {
        arena = new ArenaModel(gameModel, 16);
        assertEquals(arena.getLevel(), 16);
        assertEquals(arena.getElements().size(), 5);
        assertEquals(arena.getProtections().size(), 3);
        for(ProtectionModel protection : arena.getProtections()) {
            assertEquals(protection.getLife(), 15);
        }
    }

    @Test
    public void levelConstructorTest2() {
        arena = new ArenaModel(gameModel, 42);
        assertEquals(arena.getLevel(), 42);
        assertEquals(arena.getElements().size(), 5);
        assertEquals(arena.getProtections().size(), 3);
        for(ProtectionModel protection : arena.getProtections()) {
            assertEquals(protection.getLife(), 5);
        }
    }

    @Test
    public void checkDead(){
        ElementModel elementMock = Mockito.mock(ElementModel.class);
        Mockito.when(elementMock.isAlive()).thenReturn(false);
        int sizeBeforeElement = arena.getElements().size();
        arena.addElement(elementMock);
        assertEquals(arena.getElements().size(), sizeBeforeElement + 1);
        arena.checkDead();
        assertEquals(arena.getElements().size(), sizeBeforeElement);
    }

    @Test
    public void checkDead2(){
        ElementModel elementMock = Mockito.mock(ElementModel.class);
        Mockito.when(elementMock.isAlive()).thenReturn(true);
        int sizeBeforeElement = arena.getElements().size();
        arena.addElement(elementMock);
        arena.checkDead();
        assertEquals(arena.getElements().size(), sizeBeforeElement + 1);
    }

    @Test
    public void checkShotTest() {
        ShotModel shotMock = Mockito.mock(ShotModel.class);
        Mockito.when(shotMock.getX()).thenReturn(-5);
        Mockito.when(shotMock.getY()).thenReturn(10);
        arena.update(shotMock);
        assertEquals(arena.getShots().size(), 1);
        arena.checkShot();
        assertEquals(arena.getShots().size(), 0);
    }

    @Test
    public void checkShotTest2() {
        ShotModel shotMock = Mockito.mock(ShotModel.class);
        Mockito.when(shotMock.getX()).thenReturn(10);
        Mockito.when(shotMock.getY()).thenReturn(-5);
        arena.update(shotMock);
        assertEquals(arena.getShots().size(), 1);
        arena.checkShot();
        assertEquals(arena.getShots().size(), 0);
    }

    @Test
    public void checkShotTest3() {
        ShotModel shotMock = Mockito.mock(ShotModel.class);
        Mockito.when(shotMock.getX()).thenReturn(100);
        Mockito.when(shotMock.getY()).thenReturn(10);
        arena.update(shotMock);
        assertEquals(arena.getShots().size(), 1);
        arena.checkShot();
        assertEquals(arena.getShots().size(), 0);
    }

    @Test
    public void checkShotTest4() {
        ShotModel shotMock = Mockito.mock(ShotModel.class);
        Mockito.when(shotMock.getX()).thenReturn(10);
        Mockito.when(shotMock.getY()).thenReturn(100);
        arena.update(shotMock);
        assertEquals(arena.getShots().size(), 1);
        arena.checkShot();
        assertEquals(arena.getShots().size(), 0);
    }

    @Test
    public void checkShotTest5() {
        ShotModel shotMock = Mockito.mock(ShotModel.class);
        Mockito.when(shotMock.getY()).thenReturn(10);
        Mockito.when(shotMock.getX()).thenReturn(10);
        arena.update(shotMock);
        assertEquals(arena.getShots().size(), 1);
        arena.checkShot();
        assertEquals(arena.getShots().size(), 1);
    }

    @Test
    public void checkCollisionsTest() {
        arena.clearElements();
        ShotModel shotMock = Mockito.mock(ShotModel.class);
        ElementModel elementMock = Mockito.mock(ElementModel.class);
        Mockito.when(elementMock.collideWith(shotMock)).thenReturn(true);
        arena.update(shotMock);
        arena.addElement(elementMock);
        assertEquals(arena.getShots().size(), 1);
        assertEquals(arena.getElements().size(), 1);
        arena.checkCollisions();
        assertEquals(arena.getShots().size(), 0);
        Mockito.verify(elementMock, Mockito.times(1)).damage();
    }

    @Test
    public void getAliensTest() {
        AlienGroupModel alienGroupMock = Mockito.mock(AlienGroupModel.class);
        List<AlienModel> aliens = new ArrayList<>();
        Mockito.when(alienGroupMock.getAliens()).thenReturn(aliens);
        arena.setAliens(alienGroupMock);
        assertEquals(arena.getAliens(), aliens);
    }

    @Test
    public void getScoreTest() {
        assertEquals(arena.getScore(), 0);
    }

    @Test
    public void getScoreTest2() {
        arena.addScore(10);
        assertEquals(arena.getScore(), 10);
    }

    @Test
    public void isLostTest(){
        Assertions.assertTrue(arena.isLost());
    }

    @Test
    public void isLostTest2(){
        arena.run();
        assertFalse(arena.isLost());
    }

    @Test
    public void isLost3() {
        ShipModel shipMock = Mockito.mock(ShipModel.class);
        Mockito.when(shipMock.isAlive()).thenReturn(false);
        arena.setShip(shipMock);
        arena.run();
        Assertions.assertTrue(arena.isLost());
    }

    @Test
    public void isLost4() {
        ShipModel shipMock = Mockito.mock(ShipModel.class);
        Mockito.when(shipMock.isAlive()).thenReturn(true);
        Mockito.when(shipMock.getY()).thenReturn(100);
        arena.setShip(shipMock);
        arena.run();
        Assertions.assertTrue(arena.isLost());
    }

    @Test
    public void checkScore() {
        Assertions.assertTrue(arena.checkScore());
    }

    /*@Test
    public void checkScore2() {
        TreeSet<PlayerScore> scores = PlayerScore.loadScores();
        int val = scores.first().getScore() + 1;
        arena.addScore(val);
        assert arena.checkScore();
        TreeSet<PlayerScore> scores2 = PlayerScore.loadScores();
        boolean found = false;
        for (PlayerScore score : scores2) {
            if (score.getScore() == val) {
                found = true;
            }
        }
        assert found;
    }*/

    @Test
    public void dieSound(){
        arena.dieSound();
    }

    @Test
    public void dieSound2(){
        Clip clipMock = Mockito.mock(Clip.class);
        arena.setClip(clipMock);
        arena.dieSound();
        Mockito.verify(clipMock, Mockito.times(1)).start();
    }

    @Test
    public void getShipTest(){
        ShipModel shipMock = Mockito.mock(ShipModel.class);
        arena.setShip(shipMock);
        assertEquals(arena.getShip(), shipMock);
    }

    @Test
    public void getViewerTest(){
        ArenaViewer viewerMock = Mockito.mock(ArenaViewer.class);
        arena.setViewer(viewerMock);
        assertEquals(arena.getViewer(), viewerMock);
    }

}
