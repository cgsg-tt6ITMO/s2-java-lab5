/**
 * @author Troitskaya Tamara (TT6)
 */

package task;

import management.StackStorage;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 * Elements of the collection.
 */
public class Route {
    private Long id; // Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private Location to; //Поле может быть null
    private Double distance; //Значение поля должно быть больше 1

    @Override
    public String toString() {
        return "Name:" + name;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(String.valueOf(distance));
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
        Double dist = sqrt((getFrom().getX()-getTo().getX()) * (getFrom().getX()-getTo().getX())
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
        Double dist = sqrt((f.getX()-t.getX()) * (f.getX()-t.getX()) + (f.getY()-t.getY()) * (f.getY()-t.getY())
                + (f.getZ()-t.getZ()) * (f.getZ()-t.getZ()));
        setDistance(dist);
    }

    /**
     * Если захочется вручную задать расстояние.
     */
    public Route(String Name, Coordinates coords, Location f, Location t, Double distance) {
        this(Name, coords, f, t);
        setDistance(distance);
    }

    /**
     * Автоматически генерирующийся id.
     * Он и так будет не null и > 0 и уникальный, можно не проверять.
     * Однако, потом добавится функция изменения полей элемента. Получается, для той функции поле id будет неизменяемым.
     */
    public void setId() {
        StackStorage.setLastId(StackStorage.getLastId() + 1);;
        this.id = StackStorage.getLastId();
    }

    public Long getId() {
        return id;
    }

    /**
     * Sets name and suggests you to correct your output.
     */
    public void setName(String name) {
        if (name != null && !name.equals("")) {
            this.name = name;
        } else {
            System.err.println("Class Route: Field name is null or ''");
            System.out.println("Input correct data:\nName (String)");
            setName(new Scanner(System.in).nextLine());
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
            System.out.println("Input correct data:\nCoordinates(Double, Float)");
            Scanner sc = new Scanner(System.in);
            Coordinates coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
            setCoordinates(coords);
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
            System.out.println("Input correct data:\nLocation(Float, Float, Long, String name)");
            Scanner sc = new Scanner(System.in);
            Location t = new Location(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLong(), sc.nextLine());
            setTo(t);
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
        try {
            if (from != null) {
                this.from = from;
            } else {
                throw new InputMismatchException();
            }
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Class Route: Location 'from' is null");
                    System.out.println("Input correct data:\nLocation(Float, Float, Long, String name)");
                    Scanner sc = new Scanner(System.in);
                    Location f = new Location(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLong(), sc.nextLine());
                    setFrom(f);
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception) {
                    loop = true;
                }
            } while (loop);
        }
    }

    public Location getFrom() {
        return from;
    }

    /**
     * Sets the length of the route.
     * @param distance - the length (long)
     */
    public void setDistance(Double distance) {
        try {
            if (distance > 1) {
                this.distance = distance;
            } else {
                System.err.println("Class Route: distance is less than 1 (or equals 1)");
                throw new InputMismatchException();
            }
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("setDistance: incorrect input");
                    System.out.println("Input correct data:");
                    setDistance(Double.parseDouble(new Scanner(System.in).next()));
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception) {
                    loop = true;
                }
            } while (loop);
        }
    }

    public Double getDistance() {
        return distance;
    }
}
