package spaceinvaders.model;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;

public class AlienModel extends ElementModel {
    boolean alive = true;
    private final String alien = "imagens/kisspng-emoji-alien-iphone-monster-space-invaders-5ac4f1fae15e76.0256511115228564429231.png";
    protected char symbol;

    public AlienModel(PositionModel position, char symbol) {
        super(position);
        this.symbol = symbol;
    }

    @Override
    public void draw(TextGraphics graphics){
         /*ImageIcon image = new (this.getClass().getResource(alien));
        setImage(image.getImage());*/
        graphics.setCharacter(new TerminalPosition(position.getX(), position.getY()), TextCharacter.fromCharacter(symbol)[0]);
    }
    public void move(PositionModel direction) {

        this.position.setX(position.getX()+direction.getX());
        this.position.setY(position.getY()+direction.getY());
    }

    public void damage() {
        alive = false;
    }
    public boolean isAlive() {
        return alive;
    }
}
