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

import static java.lang.System.exit;

public class StackStorage {
    private static Stack<Route> stack = new Stack<>();
    //тип, дата инициализации, количество элементов и т.д
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
     * Save collection to file (not json).
     * @param outp - name of file where to save the data.
     */
    public void save(String outp) {
        System.out.println("SAVE COLLECTION:\nСохранение производится в файл " + outp + "\n");
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(outp));

            for (var el : stack) {
                output.write(el.getId() + " " + el.getName()
                        + " " + el.getDistance() + "\n");
            }
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
                 - info: prints info about the collection;
                 - save: writes the collection data to file;
                 - clear: deletes all the elements in collection;
                 - show: writes all the elements to console;
                 - execute_script: inputs elements from file;
                 - delete_by_id: deletes the element with inputted id;
                 - print_field_descending_distance: prints distances in descending order;
                 - filter_greater_than_distance: prints elements with distance greater than the inputted one;
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
            f = new Location(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLong(), sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location from (Float, Float, Long, String name)");
                    f = new Location(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLong(), sc.nextLine());
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }

        try {
            System.out.println("Location to (Float, Float, Long, String name)");
            t = new Location(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLong(), sc.nextLine());
        }
        catch (NumberFormatException | InputMismatchException e) {
            boolean loop = true;
            do {
                try {
                    System.err.println("Incorrect data, input again:");
                    System.out.println("Location to (Float, Float, Long, String name)");
                    t = new Location(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLong(), sc.nextLine());
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
                // название маршрута
                String Name = sc.nextLine();
                // координаты (double, float)
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
        // начальный размер массива
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
     * @param path - path to file.
     */
    public void execute_script(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            loop(scanner);
        } catch (FileNotFoundException e) {
            System.out.println("execute script: " + e.getMessage());
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
                case "save" -> {
                    String outputfile = "out.txt";
                    save(outputfile);
                }
                case "add" -> add(scanner);
                case "exit" -> exit(0);
                case "show" -> show();
                case "delete", "remove", "delete_by_id" -> {
                    System.out.println("Input the index");
                    deleteById(scanner.nextLong());
                }
                case "execute_script" -> {
                    System.out.println("Input filename");
                    execute_script(scanner.nextLine());
                }
                case "print_field_descending_distance" -> {
                    print_field_descending_distance();
                }
                case "filter_greater_than_distance" -> {
                    filter_greater_than_distance(scanner);
                }
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

}
