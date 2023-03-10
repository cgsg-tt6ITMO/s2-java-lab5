/**
 * @author Troitskaya Tamara (TT6)
 */

package commands;

import task.Coordinates;
import task.Location;
import task.Route;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class StackStorage {
    private static Stack<Route> stack = new Stack<>();
    //тип, дата инициализации, количество элементов и т.д
    private final String type;
    private final java.time.LocalDateTime creationDate;
    private static int lastId = 0;

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int Id) {
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
     * Prints to screen all the commands available.
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
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input route data");
        System.out.println("Name (String)");
        String Name = sc.nextLine();
        System.out.println("Coordinates(Double, Float)");
        Coordinates coords = new Coordinates(Double.parseDouble(sc.nextLine()), Float.parseFloat(sc.nextLine()));
        System.out.println("Location(Float, Float, Long, String name)");
        Location f = new Location(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLong(), sc.nextLine());
        System.out.println("Yet nothing");
        Location t = new Location();

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

}
