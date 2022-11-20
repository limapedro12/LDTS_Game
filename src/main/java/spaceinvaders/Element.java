package spaceinvaders;

public abstract class Element {
    private Position position;

    public Element(Position position) {
        this.position = position;
    }

    public abstract void draw();

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }
}
