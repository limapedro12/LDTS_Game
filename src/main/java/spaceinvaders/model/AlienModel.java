package spaceinvaders.model;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.view.AlienViewer;

public class AlienModel extends ElementModel {
    boolean alive = true;
    private String symbol;
    private String color;

    public AlienModel(PositionModel position, String symbol, String color) {
        super(position);
        this.symbol = symbol;
        this.color = color;
        this.viewer = new AlienViewer(this);
    }
    @Override
    public void damage() {
        alive = false;
    }
    @Override
    public boolean isAlive() {
        return alive;
    }
    public String getSymbol(){
        return symbol;
    }
    public String getColor() {
        return color;
    }
    public void fire(float level) {
        AlienShotModel shot = new AlienShotModel(new PositionModel(getX(), getY() + 1), level);
        notifyObservers(shot);
    }
    @Override
    public boolean collideWith(ShotModel shot){
        return !(shot instanceof AlienShotModel) && super.collideWith(shot);
//                isTangible() && (
//                (position.getX() >= shot.getX() && position.getX() <= shot.getX() + shot.getWidth() - 1 &&
//                position.getY() >= shot.getY() && position.getY() <= shot.getY() + shot.getHeight() - 1) ||
//                (shot.getX() >= position.getX() && shot.getX() <= position.getX() + getWidth() - 1 &&
//                shot.getY() >= position.getY() && shot.getY() <= position.getY() + getHeight() - 1));
    }
}
