/**
 * @author Troitskaya Tamara (TT6)
 */

package task;

import commands.StackStorage;

import java.time.LocalDateTime;

import static java.lang.Math.sqrt;

/**
 * Elements of the collection.
 */
public class Route {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private Location to; //Поле может быть null
    private long distance; //Значение поля должно быть больше 1

    @Override
    public String toString() {
        return "Name:" + name;
    }

    @Override
    public int hashCode() {
        return (int)distance;
    }

    /**
     * Дефолтный конструктор для дебаггинга.
     */
    public Route() {
        // автогенерируется
        setId();
        setCreationDate(LocalDateTime.now());
        // при не дефолтном конструкторе - меняется
        setName("route#" + id);
        setCoordinates(new Coordinates(5.17, 3.41f));
        setFrom(new Location());
        setTo(new Location(1.34f, 5.61f, 45, "loc-to"));
        long dist = (long)sqrt((getFrom().getX()-getTo().getX()) * (getFrom().getX()-getTo().getX())
                + (getFrom().getY()-getTo().getY()) * (getFrom().getY()-getTo().getY())
                + (getFrom().getZ()-getTo().getZ()) * (getFrom().getZ()-getTo().getZ()));
        setDistance(dist);
    }

    /**
     * Наиболее часто используется.
     */
    public Route(String Name, Coordinates coords, Location f, Location t) {
        this();
        setName(Name);
        setCoordinates(coords);
        setFrom(f);
        setTo(t);
        long dist = (long)sqrt((f.getX()-t.getX()) * (f.getX()-t.getX()) + (f.getY()-t.getY()) * (f.getY()-t.getY())
                + (f.getZ()-t.getZ()) * (f.getZ()-t.getZ()));
        setDistance(dist);
    }

    /**
     * Если захочется вручную задать расстояние.
     */
    public Route(String Name, Coordinates coords, Location f, Location t, long distance) {
        this(Name, coords, f, t);
        setDistance(distance);
    }

    /**
     * Автоматически генерирующийся id.
     */
    public void setId() {
        StackStorage.setLastId(StackStorage.getLastId()+1);;
        this.id = StackStorage.getLastId();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        if (name != null && name != "") {
            this.name = name;
        } else {
            System.err.println("Class Route: Field name is null or ''");
        }
    }

    public String getName() {
        return name;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates != null) {
            this.coordinates = coordinates;
        } else {
            System.err.println("Class Route: Field coordinates is null");
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets where do we go to.
     * @param to != null, Location - point of destination.
     */
    public void setTo(Location to) {
        if (to != null) {
            this.to = to;
        }
        else {
            System.err.println("Class Route: Location 'to' is null");
        }
    }

    public Location getTo() {
        return to;
    }

    /**
     * Sets where do we come from.
     * @param from != null, Location - the beginning of our route.
     */
    public void setFrom(Location from) {
        if (from != null) {
            this.from = from;
        }
        else {
            System.err.println("Class Route: Location 'from' is null");
        }
    }

    public Location getFrom() {
        return from;
    }

    /**
     * Sets the length of the route.
     * @param distance - the length (long)
     */
    public void setDistance(long distance) {
        if (distance > 1) {
            this.distance = distance;
        }
        else {
            // ? а что делать если такое происходит? нужно предложить заново ввести данные?
            System.err.println("Class Route: distance is less than 1 (or equals 1)");
        }
    }

    public long getDistance() {
        return distance;
    }
}
