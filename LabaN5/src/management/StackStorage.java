/**
 * @author Troitskaya Tamara (TT6)
 */

package management;

import task.Coordinates;
import task.Location;
import task.Route;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;

public class StackStorage {
    private static Stack<Route> stack = new Stack<>();

    private final String type;
    private final java.time.LocalDateTime creationDate;
    private static Long lastId = 0L;

    public static Long getLastId() {
        return lastId;
    }

    public static void setLastId(Long Id) {
        lastId = Id;
    }

    public Stack<Route> stack() {
        return stack;
    }

    public StackStorage() {
        type = "Stack";
        creationDate = LocalDateTime.now();
    }

    /**
     * Print the collection to screen.
     */
    public void show() {
        System.out.println("SHOW COLLECTION:");
        for (var el : stack) {
            System.out.println("ID: \t\t" + el.getId() + "\nName: \t\t" + el.getName()
                    + "\nDistance: \t" + el.getDistance() + "\n");
        }
    }

    /**
     * Save collection to json file.
     */
    public void save_json() {
        String out = "out.json";
        System.out.println("SAVE COLLECTION:\nСохранение производится в файл " + out + "\n");
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(out));

            output.write("\"MyStack\": [\n");
            for (var el : stack) {
                output.write("\t\"Route\" : {\n"
                        + "\t\t\"id\": " + el.getId() + ", \n"
                        + "\t\t\"name\": \"" + el.getName() + "\", \n"
                        + "\t\t\"creationDate\": \"" + el.getCreationDate()
                        + "\",\n\t\t\"coordinates\": {\n\t\t\t\"x\": " + el.getCoordinates().getX() + ",\n\t\t\t\"y\": " + el.getCoordinates().getY()
                        + "\n\t\t},\n\t\t\"to\": {\n\t\t\t\"name\": \"" + el.getTo().getName() + "\",\n\t\t\t\"x\": " + el.getTo().getX() + ",\n\t\t\t\"y\": " + el.getTo().getY() + ",\n\t\t\t\"z\": " + el.getTo().getZ()
                        + "\n\t\t},\n\t\t\"from\": {\n\t\t\t\"name\": \"" + el.getFrom().getName() + "\",\n\t\t\t\"x\": " + el.getFrom().getX() + ",\n\t\t\t\"y\": " + el.getFrom().getY() + ",\n\t\t\t\"z\": " + el.getFrom().getZ()
                        + "\n\t\t},\n\t\t\"distance\": " + el.getDistance() + "\n"
                        + "\t},\n");
            }
            output.write("]\n");
            output.close();
        }
        catch (IOException e) {
            System.err.println("Exception while output: " + e.getMessage());
        }
    }

    /**
     * Prints to screen all the management available.
     */
    public void help() {
        System.out.println("""
                COMMANDS AVAILABLE:
                 - help: prints the list of all commands;
                 - add: adds your element to the collection;
                 - add_if_max: adds the element if it is larger than every element stored there;
                 - insert_at: insert to place of inputted id;
                 - info: prints info about the collection;
                 - save: writes the collection data to file;
                 - clear: deletes all the elements in collection;
                 - show: writes all the elements to console;
                 - execute_script: inputs elements from file;
                 - delete_by_id: deletes the element with inputted id;
                 - remove_lower: removes all elements lower than inputted;
                 - print_field_descending_distance: prints distances in descending order;
                 - filter_greater_than_distance: prints elements with distance greater than the inputted one;
                 - update: updates element with id inputted;
                 - group_counting_by_from: outputs numbers of elements with the same from;
                 - exit;
                 - other.
                """);
    }

    /**
     * Prints to screen all the attributes of the collection.
     */
    public void info() {
        LocalDateTime date = creationDate;
        System.out.println("COLLECTION INFO:\n"
                + "creation time: " + date.getHour() + ":" + (date.getMinute() > 9 ? date.getMinute() : "0" + date.getMinute())
                + "\ntype of storage: " + type + "\nnumber of elements: " + stack.size() + "\n");
    }

    /**
     * Adding one element from console.
     */
    public void add(Scanner sc) {
        System.out.println("Input route data");
        System.out.println("Name (String)");
        String Name = sc.nextLine();

        Coordinates coords = null;
        Location f = null;
        Location t = null;

        try {
            System.out.println("Coordinates (Double, Float)");
            coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Coordinates (Double, Float)");
                    coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location from (Float, Float, Long, String name)");
            float x = Float.parseFloat(sc.nextLine());
            Float y = Float.parseFloat(sc.nextLine());
            long z = sc.nextLong();
            sc.nextLine();
            f = new Location(x, y, z, sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location from (Float, Float, Long, String name)");
                    float x = Float.parseFloat(sc.nextLine());
                    Float y = Float.parseFloat(sc.nextLine());
                    long z = sc.nextLong();
                    sc.nextLine();
                    f = new Location(x, y, z, sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location to (Float, Float, Long, String name)");
            float x = Float.parseFloat(sc.nextLine());
            Float y = Float.parseFloat(sc.nextLine());
            long z = sc.nextLong();
            sc.nextLine();
            t = new Location(x, y, z, sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location to (Float, Float, Long, String name)");
                    float x = Float.parseFloat(sc.nextLine());
                    Float y = Float.parseFloat(sc.nextLine());
                    long z = sc.nextLong();
                    sc.nextLine();
                    t = new Location(x, y, z, sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }
        Route route = new Route(Name, coords, f, t);
        stack.add(route);

        System.out.println("NEW ELEMENT ADDED SUCCESSFULLY\n");
    }

    /**
     * Input some elements from file by default.
     * @param filename - name of input file. For example, "defaultcollection.txt"
     */
    public void defaultInputFromFile(String filename) {
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file).useLocale(Locale.US);
            // сначала в файле должно быть написано, сколько в нём элементов
            int q = sc.nextInt();
            // это чтобы не считывал энтер между числом исходных Route и именем
            sc.nextLine();
            while (q > 0) {
                // Route's name
                String Name = sc.nextLine();
                // Coordinates (double, float)
                Coordinates coords = new Coordinates(Double.parseDouble(sc.next()), Float.parseFloat(sc.next()));
                // значения координат для Location from и название локации
                Location f = new Location(Float.parseFloat(sc.next()), Float.parseFloat(sc.next()), sc.nextLong(), sc.nextLine());
                // значения координат для Location to и название локации:
                Location t = new Location(Float.parseFloat(sc.next()), Float.parseFloat(sc.next()), sc.nextLong(), sc.nextLine());
                stack.add(new Route(Name, coords, f, t));
                q--;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes element with provided id.
     * @param id - id of element to be deleted
     */
    public void deleteById(Long id) {
        int begin = stack().size();
        if (begin != 0) {
            stack().removeIf(el -> Objects.equals(el.getId(), id));
            if (Objects.equals(stack().size(), begin)) {
                System.err.println("There is no element with this id: " + id);
                System.out.println("Input id correctly:");
                deleteById(new Scanner(System.in).nextLong());
            } else {
                System.out.println("SUCCESS");
                show();
            }
        } else {
            System.err.println("Collection doesn't have any elements");
        }
    }

    /**
     * Gets the management from file.
     */
    public void execute_script(Scanner sc) {
        try {
            String path = sc.nextLine();
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            loop(scanner);
        } catch (FileNotFoundException e) {
            boolean loop = true;
            do {
                try {
                    System.out.println("execute script: " + e.getMessage());
                    System.err.println("Input filename again:");
                    execute_script(sc);
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);

        }
    }

    /**
     * Loop of client commands.
     */
    public void loop(Scanner scanner) {
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            switch (command) {
                case "help" -> help();
                case "info" -> info();
                case "clear" -> {
                    stack.clear();
                    System.out.println("Now the collection is empty.\n");
                }
                case "save", "json" -> save_json();
                case "add" -> add(scanner);
                case "exit" -> exit(0);
                case "show" -> show();
                case "delete", "remove", "delete_by_id" -> {
                    System.out.println("Input the index");
                    deleteById(scanner.nextLong());
                }
                case "execute_script" -> {
                    System.out.println("Input filename");
                    execute_script(scanner);
                }
                case "print_field_descending_distance" -> print_field_descending_distance();
                case "filter_greater_than_distance" -> filter_greater_than_distance(scanner);
                case "update" -> update(scanner);
                case "add_if_max" -> add_if_max(scanner);
                case "remove_lower" -> remove_lower(scanner);
                case "insert_at" -> insert_at(scanner);
                case "group_counting_by_from" -> group_counting_by_from();
                default -> System.out.println(command + ": this command doesn't exist yet.");
            }
        }
        //? is it nice?
        scanner.close();
    }

    /**
     * Prints distances in descending order.
     */
    public void print_field_descending_distance() {
        System.out.println("ALL DISTANCES IN DESCENDING ORDER:");
        ArrayList<Double> distances = new ArrayList<>();
        for (var el : stack) {
            distances.add(el.getDistance());
        }
        distances.sort(Comparator.comparing(el -> el));
        for (int i = distances.size() - 1; i >= 0; i--) {
            System.out.println(distances.get(i));
        }
        System.out.println('\n');
    }

    /**
     * Shows elements with distance greater than the inputted one.
     */
    public void filter_greater_than_distance(Scanner sc) {
        System.out.println("ROUTES WITH DIST GREATER THAN INPUTTED:\nInput distance (Double), and I will output all routes with greater one:");
        Double distance = Double.parseDouble(sc.next());
        for (var el : stack) {
            if (el.getDistance() > distance) {
                System.out.println("ID: \t\t" + el.getId() + "\nName: \t\t" + el.getName()
                        + "\nDistance: \t" + el.getDistance() + "\n");
            }
        }
    }

    /**
     * Method for update.
     */
    private void show_by_id(Long id) {
         for (var r : stack) {
            if (r.getId().equals(id)) {
                System.out.println("Route Id:      " + r.getId() + "\nName:          " + r.getName()
                        + "\nCreation date: " + r.getCreationDate()
                        + "\nCoordinates:   " + r.getCoordinates().getX() + " " + r.getCoordinates().getY()
                        + "\nLocation To:   " + r.getTo().getName() + " " + r.getTo().getX() + " " + r.getTo().getY() + " " + r.getTo().getZ()
                        + "\nLocation From: " + r.getFrom().getName() + " " + r.getFrom().getX() + " " + r.getFrom().getY() + " " + r.getFrom().getZ()
                        + "\nDistance:      " + r.getDistance() + "\n");
            }
        }
    }

    /**
     * Updates element with id.
     */
    public void update(Scanner sc) {
        System.out.println("Id of element to be updated:");
        Long id = sc.nextLong();
        sc.nextLine();

        // later: we might ask the client which fields they would like to change...
        // but now they have to change all the fields

        show_by_id(id);
        System.out.println("Name (String)");
        String Name = sc.nextLine();

        Coordinates coords = null;
        Location f = null;
        Location t = null;

        try {
            System.out.println("Coordinates (Double, Float)");
            coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Coordinates (Double, Float)");
                    coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location from (Float, Float, Long, String name)");
            float x = Float.parseFloat(sc.nextLine());
            Float y = Float.parseFloat(sc.nextLine());
            long z = sc.nextLong();
            sc.nextLine();
            f = new Location(x, y, z, sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location from (Float, Float, Long, String name)");
                    float x = Float.parseFloat(sc.nextLine());
                    Float y = Float.parseFloat(sc.nextLine());
                    long z = sc.nextLong();
                    sc.nextLine();
                    f = new Location(x, y, z, sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location to (Float, Float, Long, String name)");
            float x = Float.parseFloat(sc.nextLine());
            Float y = Float.parseFloat(sc.nextLine());
            long z = sc.nextLong();
            sc.nextLine();
            t = new Location(x, y, z, sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location to (Float, Float, Long, String name)");
                    float x = Float.parseFloat(sc.nextLine());
                    Float y = Float.parseFloat(sc.nextLine());
                    long z = sc.nextLong();
                    sc.nextLine();
                    t = new Location(x, y, z, sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        for (var r : stack) {
            if (r.getId().equals(id)) {
                r.setName(Name);
                r.setCoordinates(coords);
                r.setFrom(f);
                r.setTo(t);
                Double dist = sqrt((f.getX()-t.getX()) * (f.getX()-t.getX()) + (f.getY()-t.getY()) * (f.getY()-t.getY())
                        + (f.getZ()-t.getZ()) * (f.getZ()-t.getZ()));
                r.setDistance(dist);
            }
        }
        System.out.println("ELEMENT UPDATED SUCCESSFULLY\n");
        show();
    }

    /**
     * Adds element only if it is larger than every element in the collection.
     */
    public void add_if_max(Scanner sc) {
        int n = stack.size();

        System.out.println("ADD IF MAX:");
        System.out.println("Input route data");
        System.out.println("Name (String)");
        String Name = sc.nextLine();

        Coordinates coords = null;
        Location f = null;
        Location t = null;

        try {
            System.out.println("Coordinates (Double, Float)");
            coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Coordinates (Double, Float)");
                    coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location from (Float, Float, Long, String name)");
            float x = Float.parseFloat(sc.nextLine());
            Float y = Float.parseFloat(sc.nextLine());
            long z = sc.nextLong();
            sc.nextLine();
            f = new Location(x, y, z, sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location from (Float, Float, Long, String name)");
                    float x = Float.parseFloat(sc.nextLine());
                    Float y = Float.parseFloat(sc.nextLine());
                    long z = sc.nextLong();
                    sc.nextLine();
                    f = new Location(x, y, z, sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location to (Float, Float, Long, String name)");
            float x = Float.parseFloat(sc.nextLine());
            Float y = Float.parseFloat(sc.nextLine());
            long z = sc.nextLong();
            sc.nextLine();
            t = new Location(x, y, z, sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location to (Float, Float, Long, String name)");
                    float x = Float.parseFloat(sc.nextLine());
                    Float y = Float.parseFloat(sc.nextLine());
                    long z = sc.nextLong();
                    sc.nextLine();
                    t = new Location(x, y, z, sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }
        Route route = new Route(Name, coords, f, t);
        // сравнение
        boolean flag = true;
        for (var el : stack) {
            if (route.compare(el) != 1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            stack.add(route);
            System.out.println("NEW ELEMENT ADDED SUCCESSFULLY\n");
        }
        else {
            System.out.println("The element is not max, so it was not added.\n");
        }
    }

    /**
     * Removes all elements lower than inputted.
     */
    public void remove_lower(Scanner sc) {
        // firstly, input an element but not put it in collection
        System.out.println("REMOVE LOWER:");
        System.out.println("Input route data");
        System.out.println("Name (String)");
        String Name = sc.nextLine();

        Coordinates coords = null;
        Location f = null;
        Location t = null;

        try {
            System.out.println("Coordinates (Double, Float)");
            coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Coordinates (Double, Float)");
                    coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location from (Float, Float, Long, String name)");
            float x = Float.parseFloat(sc.nextLine());
            Float y = Float.parseFloat(sc.nextLine());
            long z = sc.nextLong();
            sc.nextLine();
            f = new Location(x, y, z, sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location from (Float, Float, Long, String name)");
                    float x = Float.parseFloat(sc.nextLine());
                    Float y = Float.parseFloat(sc.nextLine());
                    long z = sc.nextLong();
                    sc.nextLine();
                    f = new Location(x, y, z, sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location to (Float, Float, Long, String name)");
            float x = Float.parseFloat(sc.nextLine());
            Float y = Float.parseFloat(sc.nextLine());
            long z = sc.nextLong();
            sc.nextLine();
            t = new Location(x, y, z, sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location to (Float, Float, Long, String name)");
                    float x = Float.parseFloat(sc.nextLine());
                    Float y = Float.parseFloat(sc.nextLine());
                    long z = sc.nextLong();
                    sc.nextLine();
                    t = new Location(x, y, z, sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }
        Route route = new Route(Name, coords, f, t);

        // and then remove all the elements less than inputted
        for (var el : stack) {
            if (route.compare(el) == -1) {
                stack.remove(el);
            }
        }
    }

    /**
     * Inserts an element on place of index you input;
     */
    public void insert_at(Scanner sc) {
        System.out.println("Input index");
        try {
            Long id = sc.nextLong();
            sc.nextLine();

            if (id > lastId) {
                lastId = id - 1;
                add(sc);
            }
            else if (id < 1) {
                System.err.println("insert_at: Incorrect id: less than 1");
                throw new InputMismatchException();
            } else {
                boolean exist = false;
                // check if this index exists
                for (var el : stack) {
                    if (el.getId().equals(id)) {
                        exist = true;
                        // inside foreach you can't change the size of the collection
                    }
                    // as soon as exist becomes true, start to shift all indexes
                    if (exist) {
                        el.setId(el.getId() + 1);
                    }
                }
                // by shifting indexes we got the same situation as for !exist
                add(sc);
                stack.peek().setId(id);
            }
        } catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    insert_at(sc);
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }
    }

    /**
     * Outputs number of elements with equal Location from.
     */
    public void group_counting_by_from() {
        HashMap<String, Integer> grouped = new HashMap<>();

        for (var el : stack) {
            String from = el.getFrom().toString();
            if (!grouped.containsKey(from)) {
                grouped.put(from, 1);
            }
            else {
                grouped.put(from, grouped.get(from) + 1);
            }
        }
        for (var el : grouped.keySet()) {
            System.out.println("Location from: " + el + "\nNumber of elements with this from: " + grouped.get(el));
        }
    }

}
