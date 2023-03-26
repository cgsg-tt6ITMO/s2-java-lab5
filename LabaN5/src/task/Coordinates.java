/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package task;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    /**
     * Скорее всего, проверки здесь избыточны, потому что проверка на null происходит в add.
     */
    public void setX(Double x) {
        if (x != null) {
            this.x = x;
        }
        else {
            boolean loop = true;
            do {
                try {
                    System.err.println("Coordinate: You are trying to make X equal null");
                    System.out.println("Input X again:");
                    setX(new Scanner(System.in).nextDouble());
                    loop = true;
                } catch (NumberFormatException | InputMismatchException e) {
                    loop = false;
                }
            } while (loop);
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
