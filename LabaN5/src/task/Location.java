/**
 * @author Troitskaya Tamara (TT6)
 * 2023/02/08:
 * now != null is checked not in constructor, but in setters
 * need javadoc
 */

package task;

import java.util.Objects;

public class Location {
    private float x;
    private Float y; //Поле не может быть null
    private long z;
    private String name; //Строка не может быть пустой, Поле может быть null

    /**
     * Default Location constructor.
     */
    public Location() {
        this(0, (float)0.010, 0, null);
    }

    /**
     * Location constructor of 4 arguments.
     * First three arguments are coordinates.
     * @param X - abscissa;
     * @param Y - ordinate;
     * @param Z - applicate;
     * @param nm - name of the location.
     */
    public Location(float X, Float Y, long Z, String nm) {
        setX(X);
        setY(Y);
        setZ(Z);
        setName(nm);
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(Float y) {
        if (y != null) {
            this.y = y;
        } else {
            System.err.println("Class task\\Location: Y is null");
        }
    }

    public Float getY() {
        return y;
    }

    public void setZ(long z) {
        this.z = z;
    }

    public long getZ() {
        return z;
    }

    public void setName(String name) {
        if (!Objects.equals(name, "")) {
            this.name = name;
        } else {
            System.err.println("Class task\\Location: name is ''");
        }
    }

    public String getName() {
        return name;
    }
}
