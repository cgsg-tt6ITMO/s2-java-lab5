/**
 * @author Troitskaya Tamara (TT6)
 */

package task;

public class Coordinates {
    private Double x; //Поле не может быть null
    private float y;

    /**
     * Coordinates constructor.
     * @param X abscissa (!= null);
     * @param Y ordinate.
     */
    public Coordinates(Double X, float Y) {
        setX(X);
        y = Y;
    }

    public void setX(Double x) {
        if (x != null) {
            this.x = x;
        }
        else {
            System.err.println("You are trying to make Coordinate x equal null");
        }
    }

    public void setY(float y) {
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
